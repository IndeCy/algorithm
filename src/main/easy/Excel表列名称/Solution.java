package easy.Excel表列名称;

public class Solution {


    /**
     *
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {

        String ss = "ZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] cz = ss.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n % 26 == 0){
                sb.append(cz[0]);
                n = (n -1) / 26;
            }else {
                sb.append(cz[n % 26]);
                n /= 26;
            }
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

}
