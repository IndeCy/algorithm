package easy.供暖器475;

import java.util.Arrays;

public class Solution {

    /**
     * 暴力破解 遍历房子过程中遍历供暖器 找到每个房子距离最近的供暖器的距离 然后取这些房子中的最大值
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                int tempIn;
                temp = (tempIn = Math.abs(houses[i] - heaters[j])) < temp ? tempIn : temp;
            }
            res = temp > res ? temp : res;
        }
        return res;
    }

    /**
     * 针对这种解法的优化思路 查找制暖器时用二分查找
     *
     */
    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int[] distances = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            int left = 0;
            int right = heaters.length - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (heaters[mid] > houses[i]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if(left + 1 < heaters.length){
                distances[i] = Math.min(Math.abs(heaters[left] - houses[i]),Math.abs(heaters[left+1] - houses[i]));
            }else{
                distances[i] = Math.abs(heaters[left] - houses[i]);
            }
        }

        Arrays.sort(distances);
        return distances[distances.length - 1];
    }
}
