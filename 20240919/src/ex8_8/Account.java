package ex8_8;

public class Account
{

    private String accNumber = "";
    private String name = "";
    private String pwd = "";
    private int balance = 0;

    public Account(String accNumber, String name, String pwd, int balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount)
    {
        balance += amount;
        System.out.println("입금 후 금액: "+getBalance());
    }
    public int withdraw(int amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
            System.out.println("출금 후 금액: "+getBalance());
            return amount;
        }
        else
        {
            System.out.println("잔액 보다 출금액이 많습니다.");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber='" + accNumber + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
