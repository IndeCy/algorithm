package easy.位运算;

public class Main {

    public static void main(String[] args) {

        int a = 8191;
        String res = "";

        for (int i = 0; i < 32; i++) {
            if(((a >> i) & 1) == 1){
                res += (int)Math.pow(2,i)+",";
            }
        }
        System.out.println(res);
    }
}
