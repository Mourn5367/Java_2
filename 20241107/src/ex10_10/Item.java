package ex10_10;

public class Item
{
    private String name;
    private int price;
    private int power;

    public Item()
    {
        this("이름없는 아이템",1,10);
        System.out.println("기본 생성자가 호출됨");
    }

    // 생성자에서 다른 생성자를 호출할 수 있다.
    // 단 최상위 위치에서 호출해야 한다.
    // 태어나기도 전에 행위를 한다? 말이안됨.
    // 필드명과 지역변수(매개변수)의 이름이 같을때
    // 모호함을 this 키워드로 직접 지정해주어 구분한다.

    public Item(String name)
    {
        this.name = name;
    }

    public Item(String name, int price)
    {
        this(name);
        this.price = price;
    }

    public Item(String name, int price, int power)
    {
        this(name,price);
        this.power = power;
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
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
