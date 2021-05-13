package easy.第三大的数414;

import java.util.TreeSet;

public class Solution {


    /**
     * 运用TreeSet的自带顺序以及去重特性 可惜时间复杂度超过了O(n) 因为TreeSet的自平衡也是O(n)复杂度
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);

        }
        if(res.size() >= 3){
            for (int i = 0; i < 2; i++) {
                res.pollLast();
            }
        }
        return res.last();
    }

    /**
     * 定义一个长度为3的HashSet来做自适应 O(3n) = O(n)
     * @param nums
     * @return
     */
    public static int thirdMax2(int[] nums) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(res.size() < 3){
                res.add(nums[i]);
            }else if(res.first() < nums[i] && !res.contains(nums[i])){
                res.pollFirst();
                res.add(nums[i]);
            }

        }
        return res.size() < 3 ? res.last() : res.first();
    }

    /**
     * 思路同上 区别是直接将数组放进TreeSet 长度大于3之后去掉最小的
     * @param nums
     * @return
     */
    public static int thirdMax3(int[] nums) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
            if(res.size() > 3){
                res.pollFirst();
            }

        }
        return res.size() < 3 ? res.last() : res.first();
    }



    public static void main(String[] args) {
        thirdMax2(new int[]{1,2,2,5,3,5});
    }
}
