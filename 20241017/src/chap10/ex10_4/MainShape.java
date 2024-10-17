package chap10.ex10_4;

import java.util.ArrayList;
import java.util.List;

public class MainShape
{
    public static void main(String[] args)
    {
        Square s = new Square();
        s.name = "정사각형";
        Triangle t = new Triangle();
        t.name = "삼각형";
        Circle c = new Circle();
        c.name = "원";

        Shape s1 = new Square();
        Shape[] shapes = {s, t, c};

        for(int i = 0; i < shapes.length; i++)
        {
            System.out.printf("Index Number %d name Shape : %s\n",i+1,shapes[i].name);
        }



    }
}
