package Array;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,6};
        int i = 3;
        System.out.printf(a[i--]+"");
        System.out.printf(a[i--]+"");
        System.out.printf(a[i--]+"");

    }

    public static void generate(int[] a) {
        int p = 0, n = a.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                while (p > 0 && array[p-1] % 2 != 0) {
                    array[p--] = 0;
                }
            }
            array[p++] = a[i];
        }
    }
}
