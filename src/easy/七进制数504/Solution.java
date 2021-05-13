package easy.七进制数504;

public class Solution {
    public static String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        if(num < 0){
            num = -num;
            jinwei = 1;
        }
        while(num > 0){
            sb.append(num % 7);
            num /= 7;
        }
        if(jinwei == 1){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
}
