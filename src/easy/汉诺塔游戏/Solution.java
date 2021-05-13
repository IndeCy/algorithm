package easy.汉诺塔游戏;

public class Solution {

    /**
     * 将n个盘子从x 借助 y 移动到 z
     * @param n
     * @param x
     * @param y
     * @param z
     */
    public static void hanotio(int n,char x,char y,char z){
        //当只有一个盘的时候 就直接从x移到z
        if(n == 1){
            System.out.println(String.format("%s-->%s",x,z));
        }else {
            hanotio(n-1,x,z,y); //将n-1个盘子从x借助z移动到y上
            System.out.println(String.format("%s-->%s",x,z));//将第n个盘子从x移到z上
            hanotio(n-1,y,x,z);//将n-1个盘子从y借助x移动到z上
        }
    }

    public static void main(String[] args) {
        hanotio(4,'X','Y','Z');
    }

}
