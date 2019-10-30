package 求众数;

import java.util.*;

public class Solution {
    /**
     * O(n) O(n) 中规中矩
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> record = new HashMap<>();
        for(int i : nums){
            record.merge(i, 1, (a, b) -> a + b);
        }
        TreeMap<Integer,Integer> result = new TreeMap<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = record.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> temp = iterator.next();
            result.put(temp.getValue(),temp.getKey());
        }
        return result.lastEntry().getValue();
    }

}
