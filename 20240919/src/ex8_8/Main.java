package ex8_8;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print("계좌번호입력(5자리): ");
        String accountNumber = sc1.nextLine();

        System.out.print("이름: ");
        String accountName = sc1.nextLine();

        System.out.print("비밀번호(4자리): ");
        String accountPwd = sc1.nextLine();

        System.out.print("입금할 금액: ");
        int accountBalance = sc2.nextInt();

        //통장 계설
        Account account = new Account(accountNumber,accountName,accountPwd,accountBalance);

        // 입금
        System.out.print("예금 할 금액: ");
        int deposit = sc2.nextInt();
        account.deposit(deposit);
        //출금
        System.out.print("출금할 금액: ");
        int withdraw = sc2.nextInt();
        account.withdraw(withdraw);


        System.out.println(account);
        sc1.close();
        sc2.close();
    }
}
