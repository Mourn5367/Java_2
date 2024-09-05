package ex11;

public class Main
{
    public static void main(String[] args)
    {
        Cylinder c = new Cylinder();

        c.setRadius(4);
        c.setHeight(5);

        System.out.printf("원기둥의 부피: %.2f\n", c.getVolume());
        System.out.printf("원기둥의 겉넓이: %.2f\n", c.gerSurfaceaArea());
    }
}
