package easy.杨辉三角118;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(i-1);
            row.add(1);
            for(int j = 1;j < i;j++){
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
