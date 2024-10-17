package chap10.ex10_4;

public class MainSquare
{
    public static void main(String[] args) {

        //Object, Shape, Square 객체의 필드와 메소드를 접근할 수 있다.
        Square square = new Square();

        // Shape 객체의 필드와 메소드의 접근만 가능하다.
        // (예외적으로 Square 객체의 멤버를 접근할 수 있다.)
        // Square에서 오버라이딩된 것들만 사용가능하다.
        Shape shape = new Square();

    }
}
