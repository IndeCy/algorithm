package 牛客网.华为机试.牛牛的随机数;

import java.util.Scanner;
import java.util.*;
public class Solution{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<Integer>();
        while(scan.hasNext()){
            String end = scan.nextLine();
            if(end == null || end.length() == 0){
                break;
            }
            set.clear();
            int count = Integer.parseInt(end);
            for(int i = 0; i < count; i++){
                set.add(Integer.parseInt(scan.nextLine()));
            }
            set.forEach(System.out::println);
        }


    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            int count = scan.nextInt();
//            TreeSet<Integer> set = new TreeSet<Integer>();
//            for(int i = 0; i < count; i++){
//                set.add(scan.nextInt());
//            }
//            set.forEach(System.out::println);
//            set.clear();
//        }
//    }


}
