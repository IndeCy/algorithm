package hard.寻找两个有序数组的中位数4;

import java.util.Arrays;

public class Solution {

    /**
     * 题目要求是O(m+n)的时间复杂度 此处是O(m+n)达不到
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int ans[] = new int[nums1.length+nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                ans[k++] = nums1[i++];
            }else{
                ans[k++] = nums2[j++];
            }
        }
        while(i < nums1.length){
            ans[k++] = nums1[i++];
        }
        while(j < nums2.length){
            ans[k++] = nums2[j++];
        }
        return ans.length%2 == 0 ? (ans[0] + ans[ans.length-1])/2d : ans[ans.length/2+1];
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}
