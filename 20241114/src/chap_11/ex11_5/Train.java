package chap_11.ex11_5;


public class Train implements Vehicle
{
    @Override
    public void horn() {
        System.out.println("빠아앙");
    }

    @Override
    public void move(String from, String to)
    {
        System.out.printf("기차가 %s에서 %s까지 운행될 예정입니다.\t", from, to);
    }
}
