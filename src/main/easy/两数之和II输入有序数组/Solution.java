package easy.两数之和II输入有序数组;

public class Solution {

    /**
     * 这种解法有负数限制明显
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length <= 0 || numbers[0] > target/2){
            return new int[]{};
        }
        int j = 0;
        while(numbers[j] <= (target >> 1)){
            j++;
        }
        if(j <= 0){
            return new int[]{};
        }
        int mid = j;
        while(j < numbers.length) {
            for (int i = 0; i < mid; i++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i+1,j+1};
                //这一步是保证有两个同样的值的时候，进行相加得到结果 比如[0,0,4,5] 0
                }else if(numbers[i] + numbers[i+1] == target){
                    return new int[]{i+1,i+2};
                }
            }
            j++;
        }
        return new int[]{};

    }

    /**
     * 官方题解双指针法 牛逼
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        if(numbers.length <=0){
            return new int[]{};
        }
        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else {
                break;
            }
        }
        return new int[]{++left,++right};
    }


    public static void main(String[] args) {
        twoSum(new int[]{2,3,4},6);
//        System.out.println(6 >> 1);
    }
}
