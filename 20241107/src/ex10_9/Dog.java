package ex10_9;

public class Dog extends Animal
{



    @Override
    public void eat(String food)
    {
        System.out.println(getName()+" 이(가)"+" "+food+"를 먹는다.");
    }

    @Override
    public void cry(String sound)
    {
        System.out.println(getName()+" 이(가)"+" "+ sound+"하고 소리를 낸다.");
    }

    public void wag()
    {
        System.out.println("꼬리를 살랑 살랑 흔든다.");
    }

}
