package easy.只出现一次的数字136;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {


    /**
     * 用一个哈希表储存元素出现的次数 最初版
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : nums){
            map.put(a,1 + (map.get(a) == null?0:map.get(a)));
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> en = iterator.next();
            if(en.getValue() == 1){
                return en.getKey();
            }
        }
        return 0;
    }

    /**
     * 考虑到题干中明确每个数字要么出现一次要么出现两次 不知为何时间复杂度反而更高
     * @param nums
     * @return
     */
    public int singleNumberV2(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int a : nums){
            /**
             * 当当前数字在哈希表中存在时 将它移除
             */
            if(map.get(a) != null){
                map.remove(a);
            }else {
                map.put(a,1);
            }
        }
        return ((TreeMap<Integer, Integer>) map).firstKey();
    }
}
