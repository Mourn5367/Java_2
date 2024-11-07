package ex10_11;

public class Item2
{
    String name;

    int price;

    Item2()
    {
        this.name = "기본이";
        System.out.println("Item2()의 기본생성자가 호출됨");
    }

    public Item2(String name, int price) {
        this.name = name;
        this.price = price;
    }



}
