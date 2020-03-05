package easy.出现次数最多的字符;

public class Main {


    public static Character aaa(String string){
        if(string == null || string.length() == 0){
            return null;
        }
        string = string.toLowerCase();
        int[] res = new int[64];
        for (char c : string.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                res[c - 'a']++;
            }
        }
        int maxIdx = 0,max = 0;
        for (int i = 0; i < res.length; i++) {
            if(res[i] > max){
                maxIdx = i;
                max = res[i];
            }
        }
        return max == 0 ? null : (char)('a' + maxIdx);
    }

    public static void main(String[] args) {
        System.out.println(aaa("12345"));
    }
}
