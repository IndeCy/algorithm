package easy.sorted;

public class InsertSort {

    public static void main(String[] args) {
        int[] r = {3,4,5,1,2,9,5,7,34,3};
        for(int i : r) {
            System.out.printf(i+" ");
        }
        System.out.println();
        r = insertSort(r,0,r.length-1);
        for(int i : r) {
            System.out.printf(i+" ");
        }

    }

    public static int[] insertSort(int[] r, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (r[i] < r[i - 1]) {
                int temp = r[i];
                r[i] = r[i - 1];
                int j = i - 2;
                for (; j >= low && temp < r[j]; j--) {
                    r[j + 1] = r[j];
                }
                r[j + 1] = temp;
            }
        }
        return r;
    }
}
