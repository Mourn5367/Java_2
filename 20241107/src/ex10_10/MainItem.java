package ex10_10;

public class MainItem
{
    public static void main(String[] args)
    {
        Item item = new Item("마법지팡이",888484);

        System.out.println("아이템명: "+ item.getName());
        System.out.println("아이템 가격: "+ item.getPrice());

    }
}
