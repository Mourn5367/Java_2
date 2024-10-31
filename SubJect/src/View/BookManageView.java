package View;
import DTO.BookDTO;
import DTO.BookDTOList;

import java.util.ArrayList;
import java.util.List;
public class BookManageView
{

    public void viewISBN(BookDTO book)
    {
        System.out.printf("이 책의 ISBN은 %d 입니다.\n",book.getISBN());
    }
    public void viewBookName(BookDTO book)
    {
        System.out.printf("이 책의 이름은 %s 입니다.\n",book.getBookName());
    }
    public void viewBookAuthor(BookDTO book)
    {
        System.out.printf("이 책의 작가는 %s 입니다.\n",book.getAuthor());
    }
    public void viewBookPublish(BookDTO book)
    {
        System.out.printf("이 책의 출판사는 %s 입니다.\n",book.getAuthor());
    }
    public void viewBookPrice(BookDTO book)
    {
        System.out.printf("이 책의 가격은 %d 입니다.\n",book.getPrice());;
    }
    public void viewBookAll(ArrayList<BookDTO> books)
    {

        int i = 0;
        for (BookDTO book : books)
        {
            i++;
            System.out.printf("%d번 책의 이름은:\t%s\nISBN:\t%s\n작가:\t%s\n출판사:\t%s\n가격:\t%d\n\n",i,
                    book.getBookName(),book.getISBN(),book.getAuthor(),book.getPublisher(), book.getPrice());
//            viewISBN(in);
//            viewBookName(in);
//            viewBookAuthor(in);
//            viewBookPublish(in);
//            viewBookPrice(in);
        }
        System.out.printf("출력한 총 출력 개수는 %d개 입니다.\n",i);
    }
    public void viewBookOne(BookDTO book)
    {
        try {
            System.out.printf("책의 이름은:\t%s\nISBN:\t%s\n작가:\t%s\n출판사:\t%s\n가격:\t%d\n\n",
                    book.getBookName(), book.getISBN(), book.getAuthor(), book.getPublisher(), book.getPrice());
        }
        catch (NullPointerException e)
        {
            System.out.println("해당하는 책을 찾을 수 없습니다.");
        }
    }
    public void threePerBook(BookDTOList BDL)
    {
        int i = 1;
        for(BookDTO book : BDL.getDTOList())
        {
            if( i %3 == 0)
                System.out.printf("%d번 책 %s\n", i, book.getBookName());
            else  System.out.printf("%d번 책 %s\t", i, book.getBookName());
            i++;
        }
    }
}
