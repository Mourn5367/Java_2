package View;
import DTO.BookDTO;
import java.util.ArrayList;
public class BookManageView
{

    public void viewISBN(BookDTO book)
    {
        System.out.printf("이 도서의 ISBN은 %d 입니다.\n",book.getISBN());
    }
    public void viewBookName(BookDTO book)
    {
        System.out.printf("이 도서의 이름은 %s 입니다.\n",book.getBookName());
    }
    public void viewBookAuthor(BookDTO book)
    {
        System.out.printf("이 도서의 작가는 %s 입니다.\n",book.getAuthor());
    }
    public void viewBookPublish(BookDTO book)
    {
        System.out.printf("이 도서의 출판사는 %s 입니다.\n",book.getPublisher());
    }
    public void viewBookPrice(BookDTO book)
    {
        System.out.printf("이 도서의 가격은 %d 입니다.\n",book.getPrice());;
    }
    // 도서관리 시스템 책 전부 출력하기.
    public void viewBookAll(ArrayList<BookDTO> books)
    {

        int i = 0;
        for (BookDTO book : books)
        {
            i++;
            System.out.printf("순번:\t%d\n도서명:\t%s\nISBN:\t%s\n작가:\t%s\n출판사:\t%s\n가격:\t%d\n\n",i,
                    book.getBookName(),book.getISBN(),book.getAuthor(),book.getPublisher(), book.getPrice());
        }
        System.out.printf("출력한 총 출력 개수는 %d개 입니다.\n\n",i);
    }

    // 조회할때 쓰는 책 하나의 정보만 다 가져오기.
    public void viewBookOne(BookDTO book)
    {
        try {
            System.out.printf("도서의 이름은:\t%s\nISBN:\t%s\n작가:\t%s\n출판사:\t%s\n가격:\t%d\n\n",
                    book.getBookName(), book.getISBN(), book.getAuthor(), book.getPublisher(), book.getPrice());
        }
        catch (NullPointerException e)
        {
            System.out.println("해당하는 도서를 찾을 수 없습니다.");
        }
    }
}
