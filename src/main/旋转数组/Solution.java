package 旋转数组;

import java.util.Arrays;

public class Solution {
    /**
     * 分析
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 总长度 7 右移3位
     * 位置变化
     * 0 -> 3
     * 1 -> 4
     * 2 -> 5
     * 3 -> 6
     * 4 -> 0
     * 5 -> 1
     * 6 -> 2
     * 原来的index加上移动的数值对长度取模就是最新的index
     * @param nums
     * @param k
     */

    /**
     * 方法1 暴力法每次移动一位 移动k次
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 方法二 使用额外的数组
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i+k) % nums.length;
            temp[newIndex] = nums[i];
        }
        System.arraycopy(temp,0,nums,0,nums.length);
    }

    /**
     * 方法三 反转数组
     * 将数组反转 再将前k的前一部分和后一部分分别反转
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private static void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},2);
    }
}
