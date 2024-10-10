package chap10.ex10_1;

public class Novice
{
    String name;
    int hp;
    void punch()
    {
        System.out.printf("%s(HP: %d)\n", name, hp);
    }
    Novice()
    {
        System.out.println("Novice");
    }
}
