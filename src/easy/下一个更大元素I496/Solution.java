package easy.下一个更大元素I496;

import java.util.*;

public class Solution {
    /**
     * 简单粗暴的思路 走两遍循环
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>(nums2.length);
        for(int i =0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int[] res = new int[nums1.length];
        int k=0;
        for(int i:nums1){
            int start = map.get(i);
            int end = -1;
            for(int j = start + 1;j<nums2.length;j++){
                if(nums2[j] > i){
                    end = nums2[j];
                    break;
                }
            }
            res[k++] = end;
        }
        return res;
    }

    /**
     * 改进的方式 通过map来记录值的下一个更大的值
     * 通过栈来处理
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums2) {
            while(stack.size() != 0 && i > stack.peek()) {
                    map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while(stack.size() !=0){
            map.put(stack.pop(),-1);
        }
        int res[] = new int[nums1.length];
        int i =0;
        for (int j :  nums1
             ) {
            res[i++] = map.get(j);
        }
        map.merge(1, 2, (integer, integer2) -> integer + integer2);
        return res;
    }


}
