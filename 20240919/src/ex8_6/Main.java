package ex8_6;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;

        try {
            System.out.println("첫 번째 숫자를 입력해 주세요");
            n1 = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return;
        }

        try {
            System.out.println("두 번째 숫자를 입력해 주세요");
            n2 = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return;
        }

        sc.close();

        System.out.printf("%d와(과) %d중에 더 큰 값 : %d\n",n1, n2, MyMath.max(n1,n2));
        System.out.printf("%d와(과) %d중에 더 작은 값 : %d\n",n1, n2,MyMath.min(n1,n2));
    }
}
