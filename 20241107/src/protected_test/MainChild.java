package protected_test;

import protected_test.test.Child;

public class MainChild
{
    public static void main(String[] args)
    {
        Child child = new Child();
        child.testPro();
        System.out.println("Parent ID는 "+child.id);
    }
}
