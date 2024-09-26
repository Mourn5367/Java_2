package chap09.ex09_3;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random random = new Random();

        System.out.printf("임의의 정수값: %d", random.nextInt(10));
    }
}
