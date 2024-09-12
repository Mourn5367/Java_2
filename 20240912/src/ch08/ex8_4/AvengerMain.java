package ch08.ex8_4;

public class AvengerMain
{
    public static void main(String[] args)
    {
        Avenger thor = new Avenger("THOR", 1000);
        Avenger thanos = new Avenger("THANOS", 500);

        thor.punch(thanos);
        thor.punch(thanos);
        thanos.punch(thor);
        System.out.println(thor);
        System.out.println(thanos);
    }
}
