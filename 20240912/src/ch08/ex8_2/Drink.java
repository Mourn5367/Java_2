package ch08.ex8_2;

public class Drink
{
    String name;
    int price;

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    Drink()
    {
        System.out.println("Default constructor response");
    }

    Drink(String name, int price)
    {
        this.name = name;
        this.price = price;
        System.out.println("(String name, int price) response");
    }
}
