package chap_12.ex12_1;

public class MainException
{
    public static void main(String[] args) {
        String[] season = {"Spring", "Summer", "Autumn", "Winter"};

        for (int i = 0; i < season.length; i++)
        {
            System.out.print(season[i]+" ");
        }
        System.out.println();
        for (String s : season)
        {
            System.out.print(s+" ");
        }
        System.out.println();
        try {
            System.out.println(season[5]);
        }
        catch (ArithmeticException e)
        {
            System.out.println("산술연산 잘못 0은 못나눈다.");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("배열의 인덱스 번호가 잘못되었습니다.");
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("산술, 인덱스 제외");
        }

        System.out.println(season[2]);
        System.out.println("프로그램이 종료됩니다.");
    }
}
