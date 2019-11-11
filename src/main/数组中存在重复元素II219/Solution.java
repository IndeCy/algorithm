package 数组中存在重复元素II219;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 用散列表解法
     * 用散列表来存储数组中的元素 让表的长度控制在k 这样当表长度超过k就移除掉最老的元素
     * 可以保证相同的元素之间的距离不会超过k（前提是已经知道我们遍历数组是先进先出的）
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < nums.length;i++){
            if(set.contains(i))return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;

    }
}
