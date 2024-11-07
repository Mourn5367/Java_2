package ex10_9;

// 추상 클래스 Abstract Class

// 자식 클래스를 표준화(특정 기능을 반드시 갖도록)하기 위해서.
// 인간의 실수 방지, 상속 자체가 어느정도 일관성을 보장해야하는 의무.
public abstract class Animal
{

    private String name;

    public abstract void eat(String food);
    public abstract void cry(String sound);

    public void sleep(int hours)
    {
        System.out.printf("%d 시간 잠을 자다.\n",hours);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
