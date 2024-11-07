package protected_test;

public class Parent
{
    String name;

    protected String id;

    protected void printProtected()
    {
        System.out.println("Protected 접근 지정자로 지정된 print 함수입니다.\n " +
                "protected 접근 제한자는 패키지가 서로 다르지만 상관관계에 있는 부모의 멤버로 접근 가능");
    }
    void printDefault()
    {
        System.out.println("Default 접근 지정자로 지정된 print 함수입니다.\n" +
                "default 접근제한자는 패키지가 서로 다르면 부모의 멤버로 접근이 불가능 하다.");
    }
}
