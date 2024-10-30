package Service;
import DTO.BookDTO;
import DTO.BookDTOList;
import View.BookManageView;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookService
{

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
                    for( BookDTO book : BDL.getDTOList())
                    {
                        if (book.getISBN() == tmpBookDTO.getISBN())
                        {
                            System.out.println("중복된 ISBN입니다.");
                            return;
                        }
                    }
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
                sc.nextLine();//버퍼 비움
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
        try
        {
            int userInput = sc.nextInt();
            sc.nextLine();
            BDL.getDTOList().remove(userInput - 1);
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
        }
        catch (IndexOutOfBoundsException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 접근입니다.");
        }
    }
    public void editBook(Scanner sc, BookDTOList BDL)
    {
        System.out.println("수정할 도서를 선택하십시오.");
        int i = 1;
        for(BookDTO book : BDL.getDTOList())
        {
            if( i %3 == 0)
                System.out.printf("%d번 책 %s\n", i, book.getBookName());
            else  System.out.printf("%d번 책 %s\t", i, book.getBookName());
            i++;
        }
        System.out.println();
        int userInput;
        BookDTO book;
        try
        {
            userInput = sc.nextInt();
            sc.nextLine();
            book = BDL.getDTOList().get(userInput-1);
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
            return;
        }
        catch (IndexOutOfBoundsException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 접근입니다.");
            return;
        }
        System.out.println("수정할 목록을 선택하시오.");
        for(int j = 0; j < book.bookAttribute.length; j++)
        {
            System.out.printf("%d. %s\t\t", j+1, book.bookAttribute[j]);
        }
        System.out.println();
        try {
            userInput = sc.nextInt();
            userInput--;
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
            return;
        }
        sc.nextLine();
        if (userInput >= 0 && userInput <= book.bookAttribute.length)
        {
            System.out.printf("수정 할 %s으로 입력 해 주세요.", book.bookAttribute[userInput]);
            userInput++;
            switch (userInput) {
                case 1:
                    book.setISBN(sc.nextLong());
                    sc.nextLine();
                    break;
                case 2:
                    book.setBookName(sc.nextLine());
                    break;
                case 3:
                    book.setAuthor(sc.nextLine());
                    break;
                case 4:
                    book.setPublisher(sc.nextLine());
                    break;
                case 5:
                    book.setPrice(sc.nextInt());
                    sc.nextLine();
                    break;
            }
        }
        else
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
        }
    }
    public void bookSearch(Scanner sc, BookDTOList BDL, int manageValue,BookManageView BMV)
    {
        System.out.println("1. 이름 검색, 2. ISBN 검색");
        int answer;
        try
        {
            answer = sc.nextInt();
            sc.nextLine();//버퍼 비움
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
            return;
        }
        boolean isSearch = false;
        String bookName = "";
        long bookISBN = 0;
        try
        {
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
        }
        catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        try {
            for (BookDTO bookDTO : BDL.getDTOList()) {
                if ((answer == 1 && bookDTO.getBookName().replaceAll("\\s","").equals(bookName.replaceAll("\\s",""))
                        || (answer == 2 && bookDTO.getISBN() == bookISBN))) {
                    isSearch = true;
                    switch (manageValue) // 2 조회  3 수정 4 삭제 5 출력
                    {
                        case 2:
                            BMV.viewBookOne(bookDTO);
                            break;
                        case 3:
                            editBook(sc, BDL);
                            break;
                        case 4:
                            deleteBook(sc, BDL);
                            break;
                        case 5:
                            BMV.viewBookAll(BDL);
                            break;
                    }
                }
            }
            if (answer == 1 && !isSearch) {
                System.out.printf("도서정보시스템에는 책 이름이 %s 책은 없습니다.", bookName);
            } else if (answer == 2 && !isSearch) {
                System.out.printf("도서정보시스템에는 ISBN이 %d인 책은 없습니다.", bookISBN);
            }
        }
        catch (Exception e)
        {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
