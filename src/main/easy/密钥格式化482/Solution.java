package easy.密钥格式化482;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replace("-","");
        StringBuilder sb = new StringBuilder();
        int i = S.length();
        while(i >= 0){
            if(i - K > 0) {
                for (int j = i - 1; j >= i-K; j--) {
                    sb.append(S.charAt(j));
                }
                sb.append("-");
            }else {
                for (int j = i - 1; j >= 0; j--) {
                    sb.append(S.charAt(j));
                }
            }
            i -= K;
        }
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("2-5g-3-J",2));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
    }
}
