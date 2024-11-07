package ex10_10;

public class Item
{
    private String name;
    private int price;


    // 필드명과 지역변수(매개변수)의 이름이 같을때
    // 모호함을 this 키워드로 직접 지정해주어 구분한다.
    public Item(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
