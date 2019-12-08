package 数字转化为十六进制405;

public class Solution {

    /**
     * 与二进制相比 16进制一位代表四位二进制
     * 四位一次与15&的值代表在16进制中的字符 每次加完右移四位
     * @param num
     * @return
     */
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        String hex = "0123456789abcdef";
        StringBuilder res = new StringBuilder();
        while(num != 0){
            res.append(hex.charAt(num & 15));
            num = num >>> 4;
        }
        return res.reverse().toString();
    }
}
