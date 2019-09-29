import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class PaperTest {
    public static void main(String[] args) {
        File bgp = new File("/Users/chenyang/bgp/paper3.jpg");
        File qrCode = new  File("/Users/chenyang/papers/qrCode.jpg");
        String phone = "用户188****760邀请你成为";
        File paper =new File( "/Users/chenyang/papers/testPaper.jpg");
        generatePaperWithQrCode(bgp,qrCode,phone,paper);
//
//        File paper = new File("/Users/chenyang/paperTest/");
//        if(!paper.exists() || !paper.isDirectory()){
//            paper.mkdir();
//        }
//        String a = "18818039760";
//
//        String b = a.replace(a.substring(3,7),"****");
//
//
//        System.out.println(a);
//        System.out.printf(b);
    }

    private static void generatePaperWithQrCode(File bgp, File qrCode, String phone, File paper) {
        try {
            //1.jpg是你的 主图片的路径  
            InputStream is = new FileInputStream(bgp);
            //通过JPEG图象流创建JPEG数据流解码器 
            JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
            //解码当前JPEG数据流，返回BufferedImage对象  
            BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
            //得到画笔对象  
            Graphics g = buffImg.getGraphics();

            //创建你要附加的图象。  
            //小图片的路径  
            ImageIcon imgIcon = new ImageIcon(qrCode.getPath());

            //得到Image对象。 
            Image img = imgIcon.getImage();




            g.drawImage(img, 290, 1145, 165,165,null);//图二

            //设置颜色。  
            g.setColor(Color.BLACK);


            //最后一个参数用来设置字体的大小，这是用来在海报上面写上字的方法  
            Font f = new Font("宋体",Font.PLAIN,40);//图二
            Color myColor = Color.WHITE;//new Color(0, 0, 255); //图一图二 
            g.setColor(myColor);
            g.setFont(f);

            g.drawString(phone,120,150);//图二

            g.dispose();

            OutputStream os;

            os = new FileOutputStream(paper);
            //创键编码器，用于编码内存中的图象数据。            
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
            en.encode(buffImg);
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ImageFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
