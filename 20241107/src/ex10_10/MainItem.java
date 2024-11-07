package ex10_10;

public class MainItem
{
    public static void main(String[] args)
    {
        Item item = new Item("마법지팡이",888484,10);
        Item item1 = new Item();

        System.out.println("아이템명: "+ item.getName());
        System.out.println("아이템 가격: "+ item.getPrice());

        System.out.println();

        System.out.println("아이템명: "+ item1.getName());
        System.out.println("아이템 가격: "+ item1.getPrice());

        Item item2 = new Item("이가닌자의 검", 7777,77);
        System.out.println("아이템명: "+ item2.getName());
        System.out.println("아이템 가격: "+ item2.getPrice());
        System.out.println("아이템 가격: "+ item2.getPower());
    }
}
