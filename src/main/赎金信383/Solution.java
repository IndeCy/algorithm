package 赎金信383;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 老生常谈的map映射 没劲
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (char a : magazine.toCharArray())
        {
            map.merge(a, 1, (a1, b) -> a1 + b);
        }
        for(char a : ransomNote.toCharArray()){
            if(map.get(a) == null || map.get(a) == 0){
                return false;
            }else {
                map.put(a,map.get(a)-1);
            }
        }
        return true;
    }
}
