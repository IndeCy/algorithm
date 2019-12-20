package easy.最小移动次数使数组元素相等453;

public class Solution {

    /**
     * 将n-1个值+1等价于将一个值-1 所以只需要考虑 所有元素与最小值差的和
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i: nums
             ) {
            if(i < min){
                min = i;
            }
        }
        int moves = 0;
        for (int num : nums) {
            moves += (num - min);
        }
        return moves;
    }
}
