package easy;

import java.util.Arrays;
import java.util.Scanner;

public class IOTest {

    public static void main(String... args) {
//        mine();
//    other();
       main3();
    }

    public static  void mine(){
        Scanner scan = new Scanner(System.in);
        String totalSizeString = scan.nextLine();
        int lb = Integer.parseInt(totalSizeString);
//        int lb = scan.nextInt();
        int j = 0;
        while (scan.hasNext() && j < lb) {
            String[] a = scan.nextLine().split(" ");
            int sum = 0;
            for (int i = 1; i < a.length; i++) {
                sum += Integer.parseInt(a[i]);
            }
            System.out.println(sum);
            j++;
        }
    }

    public static void other() {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String totalSizeString = sc.nextLine();
         int totalSize = Integer.parseInt(totalSizeString);
//        int totalSize = sc.nextInt();
        int i = 0;
        while (sc.hasNextLine() && i < totalSize) {
            i++;
            String str = sc.nextLine();
            String[] split = str.split(" ");
            int lineSize = Integer.parseInt(split[0]);
            int sum = 0;
            for (int j = 1; j <= lineSize; j++) {
                sum += Integer.parseInt(split[j]);
            }
            System.out.println(sum);
        }
        sc.close();
    }

    /**
     * 正确的获取输入总数的做法
     * nextLine()总是获取这行的数据并且忽略行分隔将 scaner移动到下一行
     */
    public static void right(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String totalSizeString = sc.nextLine();
            int totalSize = Integer.parseInt(totalSizeString);
            String s = sc.nextLine();
            System.out.println(totalSize);
            System.out.println(s);
            int i = sc.nextInt();
            System.out.println(i);
            System.out.println(sc.nextLine());
        }
    }


        public static void main2() {
            Scanner scan = new Scanner(System.in);
            String totalSizeString = scan.nextLine();
            int lb = Integer.parseInt(totalSizeString);
            while (scan.hasNext()) {
                String[] a = scan.nextLine().split(" ");
                Arrays.sort(a);
                for (String s : a) {
                    System.out.println(s + " ");
                }

            }

    }
    public static void main3() {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String[] a = scan.nextLine().split(" ");
            Arrays.sort(a);
            System.out.println(String.join(" ",a));

        }
    }

}
