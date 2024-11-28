package chap_12.ex_12_4;

public class MainNullPointer
{
    public static void main(String[] args) {
        NullPointerExceptionTest nullTest = new NullPointerExceptionTest();

        nullTest.addName("E");
        nullTest.addName("R");

        nullTest.printAllNames();
    }
}
