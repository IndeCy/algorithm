package 数组中存在重复元素217;

import java.util.HashSet;

public class Solution {

    /**
     * 用hash表来做 还有种方法先排序 再判断相邻重复值
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i:nums) {
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
