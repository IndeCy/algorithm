package 第一个错误的版本278;

public class Solution {

    /**
     * 很显然用二分法查找 递归 未超出时间限制
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }

    private int firstBadVersion(int start,int end){
        if(start >= end){
            return start;
        }
        int mid = (start+end) >>> 1;
        if(isBadVersion(mid)){
            return firstBadVersion(start, mid);
        }else {
            return firstBadVersion(mid + 1,end);
        }
    }

    private boolean isBadVersion(int n){
        return false;
    }

    /**
     * 不使用递归 直接二分法查找
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right-left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }



}
