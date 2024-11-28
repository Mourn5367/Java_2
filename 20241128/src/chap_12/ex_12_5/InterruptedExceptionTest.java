package chap_12.ex_12_5;

public class InterruptedExceptionTest
{
    public void printDelay()
    {
        String arr[] = {"대한민국","일본","중국","미국","북한"};
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}
