package chap_12.ex_12_8;

public class BankAccount
{
    private final String USER_NAME;
    private final String ACCOUNT_NUMBER;

    private long balance;

    public BankAccount(String USER_NAME, String ACCOUNT_NUMBER, long balance) {
        this.USER_NAME = USER_NAME;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return String.format("이름: %s\t계좌번호: %s\t금액: %d\n", USER_NAME, ACCOUNT_NUMBER, balance);
    }
}
