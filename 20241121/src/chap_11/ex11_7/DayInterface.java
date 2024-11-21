package chap_11.ex11_7;

// 상수 사용예제
public interface DayInterface
{
    // 인터페이스에서는 상수만 사용되기 때문에
    // public static final 생략 가능
    // final 처음에 초기화 한 후에는 다른 값으로 변경할 수 없다.
    // static은 인터페이스명에 .을 붙여서 상수를 사용할 수 있다,
    String MONDAY = "월요일";
    final public static String TUESDAY = "화요일";
}
