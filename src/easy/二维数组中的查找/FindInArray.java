package easy.二维数组中的查找;

public class FindInArray {

    public boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0){
            return false;
        }

        for(int i=0;i < array.length; i++){
            if(array[i][0] <= target && array[i][array[i].length - 1] >= target){
                for(int j=0;j< array[i].length;j++){
                    if(array[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
