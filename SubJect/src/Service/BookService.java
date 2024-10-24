package Service;
import DTO.BookDTO;
import DTO.BookDTOList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookService
{


    public int inputInt()
    {
        return 0;
    }

    public String InputString(Scanner sc)
    {
        return sc.nextLine();
    }

    public void newBook(Scanner sc, BookDTOList BDL)
    {
        BookDTO tmpBookDTO = new BookDTO(0,"0","0","0",0);
        System.out.println("새로운 도서정보를 입력하시오: ");
        for(int i = 0; i < tmpBookDTO.bookAttribute.length; i++) {
            System.out.printf("- %s: ", tmpBookDTO.bookAttribute[i]);
            try {
                if (i == 0) {
                    tmpBookDTO.setISBN(sc.nextLong());
                    sc.nextLine(); // 버퍼 비움
                } else if (i == 1)
                    tmpBookDTO.setBookName(sc.nextLine());
                else if (i == 2)
                    tmpBookDTO.setAuthor(sc.nextLine());
                else if (i == 3)
                    tmpBookDTO.setPublisher(sc.nextLine());
                else if (i == 4) {
                    tmpBookDTO.setPrice(sc.nextInt());
                    sc.nextLine(); // 버퍼 비움
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("숫자 입력란에 문자를 입력하였습니다. 입력을 종료합니다.");
                return;
            }
        }
        BDL.appendBookDTO(tmpBookDTO);
    }
    public void deleteBook(Scanner sc, BookDTOList BDL)
    {
        System.out.println("삭제할 도서를 선택하십시오.");
        int i = 1;
        for(BookDTO book : BDL.getDTOList())
        {
            if( i %3 == 0)
            System.out.printf("\n%d번 책 %s\t", i, book.getBookName());
            else  System.out.printf("%d번 책 %s\t", i, book.getBookName());
            i++;
        }
        System.out.println();
        int userInput = sc.nextInt();
        BDL.getDTOList().remove(userInput);
    }
}
