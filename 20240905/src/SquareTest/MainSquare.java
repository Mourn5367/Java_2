package SquareTest;

public class MainSquare
{
    public static void main(String[] args)
    {
        Square square = new Square();
        square.setLength(20.2);
        System.out.printf("길이가 %.3f㎝인 정사각형의 넓이는 %.3f㎠입니다.\n",square.getLength(), square.getArea());

        Square square2 = new Square();
        square2.setLength(15.57);
        System.out.printf("길이가 %.3f㎝인 정사각형의 넓이는 %.3f㎠입니다.\n",square2.getLength(), square2.getArea());
    }
}
