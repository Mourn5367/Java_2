package chap10.ex10_1;

import ch08.ex8_1.Hero;

public class Knight extends Novice
{
    int stamina;
    void slash()
    {
        System.out.printf("%s(HP: %d, Stamina: %d)의 베기 🔪} \n",name,stamina,stamina);
    }
    Knight()
    {
        System.out.println("Knight");
    }


}
