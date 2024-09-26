package chap09.ex09_3;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random random = new Random();

        System.out.printf("임의의 정수값: %d\n", random.nextInt());
        System.out.printf("0 에서 9 사이의 임의의 정수값: %d\n", random.nextInt(10));
        System.out.printf("1 에서 10 사이의 임의의 정수값: %d\n", random.nextInt(10)+1);
        System.out.printf("임의의 실수값: %f\n", random.nextDouble());
        System.out.printf("0 에서 100 사이의 임의의 실수값: %f\n", random.nextDouble(100));
        System.out.printf("임의의 논리값: %b\n", random.nextBoolean());
    }
}
