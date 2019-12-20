package easy.NIO测试;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void IOtest(File file){
        try(InputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buf = new byte[10];
            int bufRead = in.read(buf);
            int j = 1;
            while (bufRead != -1) {
                System.out.println("第"+j+"次读");
                for (int i = 0; i < bufRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bufRead = in.read(buf);
                j++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void NIOtest(File file){
        try(RandomAccessFile in = new RandomAccessFile(file,"rw")) {
            FileChannel channel = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char)buf.get());
                }
                buf.compact();
                bytesRead = channel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOtest(new File("/Users/chenyang/workspace/Algorithm/src/main/easy.NIO测试/test.txt"));
        System.out.println();
        NIOtest(new File("/Users/chenyang/workspace/Algorithm/src/main/easy.NIO测试/test.txt"));
    }
}
