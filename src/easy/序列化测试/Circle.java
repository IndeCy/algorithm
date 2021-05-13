package easy.序列化测试;

import java.io.Serializable;

public class Circle extends Shape implements Serializable {

    private float radius;

    transient int color;

    public static String type = "Circle";

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
