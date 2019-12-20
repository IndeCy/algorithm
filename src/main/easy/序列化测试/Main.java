package easy.序列化测试;

import java.io.*;

public class Main {


    public static void main(String[] args){
        Circle circle = new Circle();
        circle.setColor(1);
        circle.setRadius(3);
        circle.name = "father";

        try(ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    new File("/Users/chenyang/workspace/Algorithm/src/main/easy.序列化测试/circle.txt")));
            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(
                                    new File("/Users/chenyang/workspace/Algorithm/src/main/easy.序列化测试/circle.txt")))
           ) {

            oos.writeObject(circle);
            Circle back = (Circle) ois.readObject();
            System.out.println(back.getColor() + back.name + back.getRadius() + Circle.type);

        }catch (Exception e){

        }


    }
}
