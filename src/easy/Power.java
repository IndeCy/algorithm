package easy;

public class Power {
    public static void main(String[] args) {
//        System.out.printf(""+ power(2,5));
        hanio(3,'x','y','z');
    }

    public static int power(int x,int n){
        int y;
        if(n==0){
            y=1;
        }else{
            y=power(x,n/2);
            y=y*y;
            if((n%2)==1){
                y=y*x;
            }
        }
        return y;
    }

    public static void hanio(int n,char x,char y,char z){
        if(n==1) {
            move(x, n, z);
        }
        else {
            hanio(n - 1, x, z, y);
            move(x, n, z);
            hanio(n - 1, y, x, z);
        }
    }

    public static void move(char x,int n,char y){
        System.out.println("Move "+n+" from "+x+" to "+y);
    }
}
