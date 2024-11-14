package chap_11.ex11_1_2_3;

public interface Phone 
{

    //인터페이스는 상수, 추상메소드, default 메소드 등을 사용할 수 있습니다.
    //상수는 static과 final 생략가능
    String PRODUCT_NAME = "Apple";
    //static final String PRODUCT_NAME = "Apple";

    // 추상메소드는 abstract와 public 생략 가능합니다.
    abstract public void callPhone(String phoneNumber);
    public abstract void receivePhone(String phoneNumber);
    // void callPhone(); // 가능
}
