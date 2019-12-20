package easy.二进制手表401;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 使用Integer.bitCount来做
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                    strings.add(String.format("%d:%02d",i,j));
                }
            }
        }
        return strings;
    }
}
