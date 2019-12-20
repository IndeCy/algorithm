package easy.NIO测试;

public class ClientMain {

    public static void main(String[] args) {
        int i = 0;
        while(i < 10){
            new Client().start();
            i++;
        }

    }
}
