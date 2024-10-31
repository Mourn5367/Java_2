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
            try {
                switch (i) {
                    case 0:
                    {
                        tmpBookDTO.setISBN(sc.nextLong());
                        sc.nextLine(); // 버퍼 비움
                        for (BookDTO book : BDL.getDTOList())
                        {
                            if (book.getISBN() == tmpBookDTO.getISBN())
                            {
                                System.out.println("중복된 ISBN입니다.");
                                return;
                            }
                        }
                    }
                    case 1: tmpBookDTO.setBookName(sc.nextLine()); break;
                    case 2: tmpBookDTO.setAuthor(sc.nextLine()); break;
                    case 3: tmpBookDTO.setPublisher(sc.nextLine()); break;
                    case 4:
                    {
                        tmpBookDTO.setPrice(sc.nextInt());
                        sc.nextLine(); // 버퍼 비움
                        break;
                    }
                }
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
        System.out.println("추가가 완료되었습니다.");
    }

    public void deleteBook(Scanner sc, BookDTOList BDL,BookDTO bookDTO)
    {
        boolean isDeleted = false;
         isDeleted = BDL.getDTOList().remove(bookDTO);
         if (!isDeleted)
         {
             System.out.println("책을 찾을 수 없어 삭제에 실패하였습니다.");
         }
    }
    public void editBook(Scanner sc, BookDTO bookDTO)
    {
        int userInput;
        System.out.println("수정할 목록을 선택하시오.");
        for(int j = 0; j < bookDTO.bookAttribute.length; j++)
        {
            System.out.printf("%d. %s\t\t", j+1, bookDTO.bookAttribute[j]);
        }
        System.out.println();
        try {
            userInput = sc.nextInt();
            sc.nextLine();
            userInput--;
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();//버퍼 비움
            System.out.println("잘못된 입력입니다.");
            return;
        }

        try {
            if (userInput >= 0 && userInput <= bookDTO.bookAttribute.length) {
                System.out.printf("수정 할 %s으로 입력 해 주세요.", bookDTO.bookAttribute[userInput]);
                userInput++;
                switch (userInput) {
                    case 1:
                        bookDTO.setISBN(sc.nextLong());
                        sc.nextLine();
                        break;
                    case 2:
                        bookDTO.setBookName(sc.nextLine());
                        break;
                    case 3:
                        bookDTO.setAuthor(sc.nextLine());
                        break;
                    case 4:
                        bookDTO.setPublisher(sc.nextLine());
                        break;
                    case 5:
                        bookDTO.setPrice(sc.nextInt());
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
        catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.");
            sc.nextLine();
        }
        System.out.println("수정이 완료되었습니다.");
    }
    public BookDTO bookMenuSelect(Scanner sc,BookDTOList BDL, BookManageView BMV)
    {
        System.out.println("1. 책 이름/ISBN으로 검색하기\t2. 도서관리 시스템 책 목록 전부 출력 한 후 검색하기");
        int userInput;
        try
        { userInput = sc.nextInt();
        sc.nextLine();
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        switch (userInput)
        {
            case 1:
                return bookSearch(sc,BDL,BMV);
            case 2:
                return bookSelect(sc, BDL, BMV);
            default:
                System.out.println("잘못된 입력입니다.");
                return null;
        }
    }
    //
    // 다 출력해서 고르는것
    public BookDTO bookSelect(Scanner sc,BookDTOList BDL, BookManageView BMV)
    {
        BMV.viewBookAll(BDL.getDTOList());
        int userInput;
        try
        {
            System.out.println("원하시는 책 번호를 고르시오.");
            userInput = sc.nextInt();
            sc.nextLine();
        }
        catch (InputMismatchException e)
        {
            sc.nextLine();
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        try {
            return BDL.getDTOList().get(userInput - 1);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("잘못된 접근입니다.");
            return null;
        }
    }
    // 여기는 검색해서 하는것
    public BookDTO bookSearch(Scanner sc, BookDTOList BDL,BookManageView BMV)
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
                System.out.printf("같은 책이 %d권 있습니다.\n", tmpBookDTOList.size());
                BMV.viewBookAll(tmpBookDTOList);
                System.out.println("원하시는 책의 ISBN을 입력해 주세요.");
                try
                {
                    answer = sc.nextLong();
                    sc.nextLine();
                    for(BookDTO bookDTO : tmpBookDTOList)
                        if (bookDTO.getISBN() == answer) return bookDTO;

                    System.out.println("잘못된 ISBN입니다.");
                    return null;
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
