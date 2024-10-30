package View;
import DTO.BookDTO;
import DTO.BookDTOList;
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
    public void viewBookAll(BookDTOList BDL)
    {

        int i = 0;
        for (BookDTO book : BDL.getDTOList())
        {
            i++;
            System.out.printf("책의 이름은:\t%s\nISBN:\t%s\n작가:\t%s\n출판사:\t%s\n가격:\t%d\n\n",
                    book.getBookName(),book.getISBN(),book.getAuthor(),book.getPublisher(), book.getPrice());
//            viewISBN(in);
//            viewBookName(in);
//            viewBookAuthor(in);
//            viewBookPublish(in);
//            viewBookPrice(in);
        }
        System.out.printf("출력한 총 출력 개수는 %d개 입니다.",i);
    }
    public void viewBookOne(BookDTO book)
    {
        System.out.printf("책의 이름은:\t%s\nISBN:\t%s\n작가:\t%s\n출판사:\t%s\n가격:\t%d\n\n",
                book.getBookName(),book.getISBN(),book.getAuthor(),book.getPublisher(), book.getPrice());
    }
}
