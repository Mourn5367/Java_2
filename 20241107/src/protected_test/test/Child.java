package protected_test.test;

import protected_test.Parent;

public class Child extends Parent
{
    public void testPro()
    {
        this.id = "Protected ID";
        printProtected();
    }
}
