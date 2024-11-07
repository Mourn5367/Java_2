package ex10_9;

public class Cat extends Animal
{

    @Override
    public void eat(String food)
    {
        System.out.println(getName() + " 이(가)" +" "+ food+"을(를) 먹는다.");
    }

    @Override
    public void cry(String sound)
    {
        System.out.println(getName()+" 이(가)"+" "+ sound+"하고 소리를 낸다.");
    }

    public void grooming()
    {
        System.out.println(getName()+" 이(가) 그루밍을 한다.");
    }

}
