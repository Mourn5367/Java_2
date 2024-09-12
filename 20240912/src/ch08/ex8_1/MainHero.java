package ch08.ex8_1;

public class MainHero
{

    public static void main(String[] args)
    {
        Hero ironMan = new Hero("Iron Man", 100, 170);
        Hero hulk = new Hero("Hulk", 150, 150);

        System.out.println(ironMan.toString());
        System.out.println(ironMan); // toString 만들면 두개 다 같다.'

        System.out.println(hulk);
    }
}
