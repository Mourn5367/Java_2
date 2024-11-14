package chap_11.ex11_1_2_3;

public class MainIPhone
{
    public static void main(String[] args)
    {
        // 업캐스팅된 경우의 참조 변수는 부모의 것을 사용할 수 있고,
        // 자식의 것은 오버라이딩 된것만 사용할 수 있다.
        Phone p = new IPhone();
        p.callPhone("0");
        p.receivePhone("1");
        System.out.println("제조사 이름 "+Phone.PRODUCT_NAME);


        IPhone iPhone = new IPhone();
        iPhone.beep();
        iPhone.callPhone("2");
        iPhone.playMusic("Into The Night");
        iPhone.sendAirdrop("Air");
        iPhone.sendMessage("[Wep 발신]너는 날 존중해야 한다 나는 5개의...[더보기]");

        // 이미 생성된 객체의 참조 값을 이용해서 업캐스팅이 가능하다.
        Alarm alarm = iPhone;
        alarm.beep();
        alarm.playMusic("Bless");

        //Alarm alarm2 = p;

    }
}
