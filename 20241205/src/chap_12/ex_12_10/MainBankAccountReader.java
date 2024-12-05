package chap_12.ex_12_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainBankAccountReader
{
    public static void main(String[] args)
    {
        File file = new File("result_account.txt");
        try
        {
            FileReader fr = new FileReader(file);
            int ch;
            while((ch = fr.read()) != -1 )
            {
                Thread.sleep(100);
                System.out.print((char)ch);
                Thread.sleep(100);
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
