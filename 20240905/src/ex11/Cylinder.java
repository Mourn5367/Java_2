package ex11;

public class Cylinder
{
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    int radius;
    int height;

    double getVolume()
    {
        return radius * radius * Math.PI * height;
    }

    double gerSurfaceaArea()
    {
        double circleArea = Math.PI * radius * radius;
        double rectangleArea = height * 2 * Math.PI * radius;

        return 2 * circleArea + rectangleArea;
    }
}
