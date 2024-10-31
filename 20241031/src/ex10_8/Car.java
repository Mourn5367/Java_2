package ex10_8;

public class Car
{
    private String name;
    Car(String name)
    {
        this.name = name;
        System.out.printf("모델명:\t[%s]\n",this.name);
    }
    public void move()
    {
        System.out.printf("[%s]가 이동중입니다.\n",this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
