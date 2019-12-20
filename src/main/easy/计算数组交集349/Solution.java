package easy.计算数组交集349;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0,j=0; i < nums1.length && j<nums2.length;) {
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int res[] = new int[set.size()];
        int k=0;
        for (Integer integer : set) {
            res[k++] = integer;
        }
        return res;
    }
}
