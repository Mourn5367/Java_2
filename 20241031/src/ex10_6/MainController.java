package ex10_6;

import java.util.ArrayList;

public class MainController
{
    public static void main(String[] args)
    {

        Square square = new Square();
        square.setWidth(9);

        Triangle triangle = new Triangle();
        triangle.setWidth(15);
        triangle.setHeight(9);

        Circle circle = new Circle();
        circle.setRadius(15);

        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(square);
        shapeList.add(triangle);
        shapeList.add(circle);

        square.name ="정사각형";
        triangle.name ="삼각형";
        circle.name = "원";

        Shape[] arr = {square, triangle, circle};

        viewShape(shapeList);
        viewShape(arr);
    }

    public static void viewShape(ArrayList<Shape> arrList)
    {
        for(Shape shape : arrList)
        {
            System.out.printf("%s의 면적은 %.3f㎠\n",shape.name,shape.area());
        }
    }
    public static void viewShape(Shape[] arrList)
    {
        for(Shape shape : arrList)
        {
            System.out.printf("%s의 면적은 %.3f㎠\n",shape.name,shape.area());
        }
    }

}
