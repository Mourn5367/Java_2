public class MainDog
{

    public static void main(String[] args)
    {
        Dog d1 = new Dog();
        Dog d2 = new Dog();

        d1.setName("에옹");
        d1.setBreeds("sigol");
        d1.setAge(15);

        d2.setName("훠");
        d2.setBreeds("jap");
        d2.setAge(8);

        System.out.printf
                ("d1 => (name : %s, breed: %s, age: %d)\n", d1.getName(),d1.getBreeds(),d1.getAge());
        System.out.printf
                ("d2 => (name : %s, breed: %s, age: %d)\n", d2.getName(),d2.getBreeds(),d2.getAge());

        d1.wag();
        d2.wag();

        d1.bark();
        d1.bark(1557,"왈왈컹컹크르릉캬아아악");

        d2.bark();
        d2.bark(88,"왈왈컹컹크르릉캬아아악!!!!!!!");

    }

}
