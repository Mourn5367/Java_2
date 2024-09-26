package Prac;

public class Account
{
    private String num = "";
    private int balance = 0;

    public Account(String num, int balance) {
        this.num = num;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "num='" + num + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getNum() {
        return num;
    }

    public int getBalance() {
        return balance;
    }

    public boolean transfer(Account dest, int amount) {
        if (this.balance >= amount)
        {
            this.balance -= amount;
            dest.balance += amount;
            System.out.printf("%s 계좌에서 %s 계좌로 송금하였습니다.\n",this.num,dest.num);
            return true;
        }
        else {
            System.out.println("잔액이 부족하여 이체가 불가능");
            return false;
        }
    }
}
