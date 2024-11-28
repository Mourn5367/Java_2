package chap_12.ex_12_7;

import chap_12.ex_12_6.MyAgeException;

public class ThrowsTest
{
    public void test1() throws MyAgeException {
        System.out.println("🚨Test1 Called🚨");
        test2();
    }

    public void test2() throws MyAgeException
    {
        System.out.println("🚨Test2 Called🚨");
        throw new MyAgeException("나이를 잘못입력했어요");
    }
}
