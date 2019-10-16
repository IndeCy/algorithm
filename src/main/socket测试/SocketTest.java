package socket测试;

import java.io.*;
import java.net.Socket;

public class SocketTest {

    public static void IOtest(File file){
        try(InputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buf = new byte[100];
            int bufRead = in.read(buf);
            while (bufRead != -1) {
                for (int i = 0; i < bufRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bufRead = in.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
