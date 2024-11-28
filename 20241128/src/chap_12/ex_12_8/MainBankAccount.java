package chap_12.ex_12_8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainBankAccount
{
    public static void main(String[] args)
    {
        BankAccount b1 = new BankAccount("Elon","111-22-333", 9999999999999999L);
        BankAccount b2 = new BankAccount("P_DH","111-22-334", 290000);

        try
        {
            File file = new File("result_account.word");
            FileWriter fw = new FileWriter(file);
            fw.write(b1.toString());
            fw.write("\n");
            fw.write(b2.toString());
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
