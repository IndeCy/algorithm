package leet.code.Merge;

public class Merge2Array {
    static int  a[] = {12,4,7,6,3,19,22,56};
    static int b[] = {44,32,15,75,34,27,11};

    public static void main(String[] args) {
        int[] c = merge(sortAsc(a),sortAsc(b));
//        int[] c = merge(a,b);
        for (int i = 0; i < c.length; i++) {
            int arg = c[i];
            System.out.printf(arg+",");
        }
    }
    //将两个有序数组合并成一个大的有序数组
    public static int[] merge(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        int pa=0,pb=0,pc=0;
        while (pa<a.length&&pb<b.length){
            if(a[pa]<b[pb]){
                c[pc++] = a[pa++];
            }else {
                c[pc++] = b[pb++];
            }
        }
        if(pa<a.length){
            while(pa<a.length)c[pc++] = a[pa++];
        }else {
            while(pb<b.length)c[pc++] = b[pb++];
        }
        return c;
    }

    public static int[] sortAsc(int[] a) {
        int j =0;
        while(j<a.length) {
            int i =0;
            while (i < a.length - j -1) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
                i++;
            }
            j++;
        }
        return a;
    }
}
