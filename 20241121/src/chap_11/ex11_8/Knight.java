package chap_11.ex11_8;

public class Knight
{
    public String name;
    public int hp = 100;

    public Knight(String name)
    {
        this.name = name;
    }

    public void slash()
    {
        System.out.printf("[%s]의 베기",name);
    }
}
