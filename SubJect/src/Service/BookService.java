package Service;
import DTO.BookDTO;
import DTO.BookDTOList;
import View.BookManageView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookService
{
    // 책 추가하기
    public void newBook(Scanner sc, BookDTOList BDL)
    {
        // 추가 할 책 임시로 만들기
        BookDTO tmpBookDTO = new BookDTO(0,"0","0","0",0);
        System.out.println("새로운 도서정보를 입력하시오: ");
        // 책 속성만큼 뭘 할지 선택하게 반복함.
        for(int i = 0; i < tmpBookDTO.bookAttribute.length; i++) 
        {   // 속성 출력 다음번에는 리스트 안에 함수로 해서 if 이렇게 안쓰도록 하기
            System.out.printf("- %s: ", tmpBookDTO.bookAttribute[i]);
            try 
            {
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
                tmpBookDTO.setBookName(sc.nextLine());
                tmpBookDTO.setAuthor(sc.nextLine());
                tmpBookDTO.setPublisher(sc.nextLine());
                tmpBookDTO.setPrice(sc.nextInt());
                sc.nextLine(); // 버퍼 비움
            }
            catch (InputMismatchException e)
            {
                sc.nextLine();//버퍼 비움
                System.out.println("숫자 입력란에 문자를 입력하였습니다. 입력을 종료합니다.");
                return;
            }
        }
        // 오류 없다면 책 추가
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
    public void editBook(Scanner sc, BookDTOList BDL,BookManageView BMV)
    {
        System.out.println("수정할 도서를 선택하십시오.");
        BMV.threePerBook(BDL);
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
    //
    // 다 출력해서 고르는것
    public BookDTO bookSelect(Scanner sc,BookDTOList BDL, BookManageView BMV)
    {
        BMV.viewBookAll(BDL);
        int userInput;
        try
        {
            System.out.println("원하시는 책을 고르시오.");
            userInput = sc.nextInt();
            sc.nextLine();
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        return BDL.getDTOList().get(userInput-1);
    }
    // 여기는 검색해서 하는것
    public BookDTO bookSearch(Scanner sc, BookDTOList BDL, int manageValue,BookManageView BMV)
    {
        System.out.println("1. 이름 검색, 2. ISBN 검색");
        long answer;
        try
        {
            answer = sc.nextInt();
            sc.nextLine();//버퍼 비움
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        if (answer != 2 && answer != 1)
        {
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        String bookName = "";
        long bookISBN = 0;
        ArrayList<BookDTO> tmpBookDTOList = new ArrayList<>();

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
            return null;
        }
        try
        {
            for (BookDTO bookDTO : BDL.getDTOList())
            {
                if ((answer == 1 && bookDTO.getBookName().replaceAll("\\s","").equals(bookName.replaceAll("\\s",""))
                        || (answer == 2 && bookDTO.getISBN() == bookISBN)))
                {
                    tmpBookDTOList.add(bookDTO);
                }
            }
            if (tmpBookDTOList.size() > 1)
            {
                System.out.printf("같은 책이 %d권 있습니다. 원하시는 책의 ISBN을 입력해 주세요.\n", tmpBookDTOList.size());
                try
                {
                    answer = sc.nextLong();
                    sc.nextLine();
                    for(BookDTO bookDTO : tmpBookDTOList)
                    {
                        if (bookDTO.getISBN() == answer)
                        {
                            return bookDTO;
                        }
                    }
                }
                catch (InputMismatchException e)
                {
                    sc.nextLine();
                    System.out.println("잘못된 입력입니다.");
                    return null;
                }
                catch (IndexOutOfBoundsException e)
                {
                    sc.nextLine();
                    System.out.println("잘못된 접근입니다.");
                    return null;
                }
            }
            else if (tmpBookDTOList.size() == 1)
            {
                return tmpBookDTOList.get(0);
            }
            else if (tmpBookDTOList.isEmpty())
            {
                if (answer == 1) {
                    System.out.printf("도서정보시스템에는 책 이름이 %s 책은 없습니다.", bookName);
                    return null;
                } else if (answer == 2) {
                    System.out.printf("도서정보시스템에는 ISBN이 %d인 책은 없습니다.", bookISBN);
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        return null;
    }
}
