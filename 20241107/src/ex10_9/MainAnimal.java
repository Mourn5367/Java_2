package ex10_9;

public class MainAnimal
{
    // 추상 클래스는 new 연산자로 객체 생성이 불가능하다.
    // Animal animal = new Animal()
    public static void main(String[] args)
    {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.setName("복덩이");
        dog.eat("사료");
        dog.cry("멍멍ㅁㅁㅁㅁ");
        dog.sleep(5);
        dog.wag();

        cat.setName("나비");
        cat.sleep(10);
        cat.cry("미야옹ㅇㅇㅇㅇㅇ");
        cat.grooming();
        cat.eat("오징어");

        // 업캐스팅시 오버라이딩된 함수만 사용가능
        // 즉 자식 전용 함수는 업캐스팅시 사용이 불가능 하다.
        // float 에서 int로 가면 소실되는거 마냥
        // 큰거에서 작은걸로 흉내만 내는거니 안됨.
        Animal animal = new Dog();

    }


}
