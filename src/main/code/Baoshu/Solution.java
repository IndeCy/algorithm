package main.code.Baoshu;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
//        System.out.println(generateStr("112111"));
//        System.out.println(count("11211"));
    }
    public static String countAndSay(int n) {
        if(n==0){
            return null;
        }
        if(n==1){
            return "1";
        }
        return count(countAndSay(n-1));
    }

    /**
     * 能实现 但是处理边界很丑陋
     * @param s
     * @return
     */
    public static String generateStr(String s){
        char[] chs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<chs.length;){
            int count = 1;
            if(i==chs.length-1){
                sb.append(count).append(chs[i]);
                break;
            }
            for(int j= i+1;j<chs.length+1;j++){
                if(j==chs.length){
                    sb.append(count).append(chs[i]);
                    i+=count;
                    break;
                }
                if(chs[i] == chs[j]){
                    count++;
                    continue;
                }else{
                    sb.append(count).append(chs[i]);
                    i+=count;
                    break;
                }
            }

        }
        return sb.toString();
    }

    /**
     * 高手处理边界
     * @param s
     * @return
     */
    private static String count(String s) {
        StringBuilder sb=new StringBuilder();
        char cur=s.charAt(0);
        int count=1;
        for(int i=1;i<s.length();++i){
            if(cur==s.charAt(i)){
                count++;
            }else {
                sb.append(count+""+cur);
                count=1;
                cur=s.charAt(i);
            }
        }
        sb.append(count+""+cur);
        return sb.toString();
    }

}
