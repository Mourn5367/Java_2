package chap10.ex10_1;

public class Wizard extends Novice
{
    int mp;
    void fireball()
    {
        System.out.printf("%s(HP: %d, MP: %d)의 파이어볼 🔥} \n",name,mp,mp);
    }
    Wizard()
    {
        System.out.println("Wizard");
    }

}
