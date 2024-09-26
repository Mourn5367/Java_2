package ex8_9;

public class Main {
    public static void main(String[] args)
    {
        int increasePrice = 500;
        Coffee c = new Coffee("아메리카노", 3500);
        System.out.printf("%s(%d원) -> ", c.getName(), c.getPrice());
        c.setPrice(c.getPrice()+ increasePrice);
        System.out.printf("%s(%d원)", c.getName(), c.getPrice());
    }
}
