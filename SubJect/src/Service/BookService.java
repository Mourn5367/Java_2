package Service;
import DTO.BookDTO;
import DTO.BookDTOList;
import View.BookManageView;
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
        BDL.getDTOList().remove(userInput-1);
    }
    public void editBook(Scanner sc, BookDTO bookDTO)
    {
        System.out.println("수정할 도서를 선택하십시오.");
    }
    public void bookSearch(Scanner sc, BookDTOList BDL, int manageValue,BookManageView BMV)
    {
        System.out.println("1. 이름 검색, 2. ISBN 검색");
        int answer = sc.nextInt();
        boolean isSearch = false;
        sc.nextLine();//버퍼 비움
        String bookName = "";
        long bookISBN = 0;
        if (answer == 1) {
            System.out.println("책 이름을 입력해 주세요.");
            bookName = sc.nextLine();
        }
        else if (answer == 2)
        {
            System.out.println("책 ISBN을 입력해 주세요.");
            bookISBN = sc.nextLong();
            sc.nextLine();
        }
        for(BookDTO bookDTO : BDL.getDTOList())
        {
            if ((answer == 1 && bookDTO.getBookName().equals(bookName)) || (answer == 2 && bookDTO.getISBN() == bookISBN))
            {
                isSearch = true;
                switch(manageValue) // 2 조회  3 수정 4 삭제 5 출력
                {
                    case 2:
                        BMV.viewBookOne(bookDTO);
                        break;
                    case 3:
                        editBook(sc, bookDTO);
                        break;
                    case 4:
                        deleteBook(sc,BDL);
                        break;
                    case 5:
                        BMV.viewBookAll(BDL);
                        break;
                }
                break;
            }
        }
        if (answer == 1 && !isSearch)
        {
            System.out.printf("도서정보시스템에는 책 이름이 %s 책은 없습니다.",bookName);
        }
        else if (answer == 2 && !isSearch)
        {
            System.out.printf("도서정보시스템에는 ISBN이 %d인 책은 없습니다.",bookISBN);
        }
    }
}
