package ex12;

public class Main {

    public static void main(String[] args)
    {
        Cube cube = new Cube();
        cube.setLength(5);

        System.out.printf("정육면체의 부피: %.2f\n", cube.getVolume());
        System.out.printf("정육면체의 겉넓이: %.2f", cube.getSurfaceArea());
    }



}
