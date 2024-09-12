package ch08.ex8_2;


public class DrinkTest
{
    public static void main(String[] args)
    {
        Drink d1 = new Drink();
        Drink d2 = new Drink("2%.zero%",1500);

        System.out.println(d1);
        System.out.println(d2);
    }
}
