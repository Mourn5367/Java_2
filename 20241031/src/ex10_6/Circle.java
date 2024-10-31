package ex10_6;

public class Circle extends Shape
{
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius;

    double area()
    {
        double result = Math.PI * Math.pow(radius, 2);
        return result;
    }
}
