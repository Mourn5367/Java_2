package chap_12.ex12_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainException
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("😀 나누는 수를 입력하세요 😀: ");
        try {

            int dividend = sc.nextInt();
            double result = 30 / dividend;

            System.out.printf("😁 %d을 %d으로 나눈 수의 결과는 %.2f 😁\n", dividend, 30, result);
            System.out.println("프로그램 종료");
        }
        catch (ArithmeticException e)
        {
            System.out.println("😦 0 넣지마라 😦");
        }
        catch (InputMismatchException e)
        {
            System.out.println("😦 숫자 말고 넣지마라 😦");
        }
        sc.close();
    }
}
