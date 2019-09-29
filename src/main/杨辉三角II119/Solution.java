package 杨辉三角II119;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
       List<Integer> cur = new ArrayList<>();
       List<Integer> pre = new ArrayList<>();
       for (int i = 0; i <= rowIndex; i++) {
           cur = new ArrayList<>();
           for (int j = 0; j <= i; j++) {
               if(j == 0 || j==i){
                   cur.add(1);
               }else {
                   cur.add(pre.get(j-1)+pre.get(j));
               }
           }
           pre = cur;
       }
       return cur;
    }

    public List<Integer> getRowV2(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }

}
