package ex8_9;

public class Coffee
{
    private String name;
    private int price;

    public Coffee( String name,int price) {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
}
