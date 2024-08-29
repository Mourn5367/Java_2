package Cat;

public class Main
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        cat.setName("AICAT");
        cat.setBreeds("sigolzapjong");
        cat.setWeight(3.123546);

        System.out.printf("이름: %s\n", cat.getName());
        System.out.printf("품종: %s\n", cat.getBreeds());
        System.out.printf("무게: %.2fkg\n", cat.getWeight());

        System.out.println((cat.getName()+"이 "));
        cat.claw();

        System.out.println((cat.getName()+"이 "));
        cat.meow();

    }
}
