package chap8.ex8_5;

public class Main
{
    public static void main(String[] args)
    {
        Student park = new Student(2019122104,"Park");
        Student kim = new Student(2019206028,"Kim");
        Student lee = new Student(2019153237,"Lee");

        System.out.printf("현재 Student 객체의 수: %d개", Student.count);
    }
}
