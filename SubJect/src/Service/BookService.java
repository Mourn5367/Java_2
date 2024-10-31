package Service;
import DTO.BookDTO;
import DTO.BookDTOList;
import View.BookManageView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookService
{
    // 도서 추가하기
    public void newBook(Scanner sc, BookDTOList bookDTOList)
    {
        // 추가 할 도서 임시로 만들기
        BookDTO tmpBookDTO = new BookDTO(0,"0","0","0",0);
        System.out.println("새로운 도서정보를 입력하시오: ");
        // 도서 속성만큼 뭘 할지 선택하게 반복함.
        for(int i = 0; i < tmpBookDTO.bookAttribute.length; i++)
        {   // 속성 출력 다음번에는 리스트 안에 함수로 해서 case 안써보기
            System.out.printf("- %s: ", tmpBookDTO.bookAttribute[i]);
            try {
                switch (i) {
                    case 0:
                    {
                        tmpBookDTO.setISBN(sc.nextLong());
                        sc.nextLine(); // 버퍼 비움
                        for (BookDTO book : bookDTOList.getBookDTOList())
                        {
                            if (book.getISBN() == tmpBookDTO.getISBN())
                            {
                                System.out.println("중복된 ISBN입니다.");
                                return;
                            }
                        }
                        break;
                    }
                    // .replaceAll("\\s+$","")) 뒤에 공백 다 제거해준다고 함.
                    case 1: tmpBookDTO.setBookName(sc.nextLine().replaceAll("\\s+$","")); break;
                    case 2: tmpBookDTO.setAuthor(sc.nextLine().replaceAll("\\s+$","")); break;
                    case 3: tmpBookDTO.setPublisher(sc.nextLine().replaceAll("\\s+$","")); break;
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
        // 오류 없다면 도서 추가
        bookDTOList.appendBookDTO(tmpBookDTO);
        System.out.println("도서추가가 완료되었습니다.");
    }

    // 삭제하기
    public void deleteBook(BookDTOList bookDTOList,BookDTO bookDTO)
    {
         boolean isDeleted;
         isDeleted = bookDTOList.getBookDTOList().remove(bookDTO);
         if (!isDeleted)
         {
             System.out.println("도서를 찾을 수 없어 삭제에 실패하였습니다.");
             return;
         }
        System.out.println("삭제를 완료했습니다.");
    }
    // 수정하기 (재귀가능)
    public void editBook(Scanner sc, BookDTO bookDTO,BookDTOList bookDTOList)
    {
        int userInput;
        System.out.println("수정할 목록을 선택하시오.");
        // 기존 내용 보관하고 에러없이 다 입력한다면 입력 받은 값으로 수정.
        long tmpISBN = bookDTO.getISBN();
        String tmpBookName = bookDTO.getBookName();
        String tmpAuthor = bookDTO.getAuthor();
        String tmpPublisher = bookDTO.getPublisher();
        int tmpPrice = bookDTO.getPrice();

        // 책 속성 출력해서 뭐 수정할지 정하게 하기
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
                if (userInput >= 0 && userInput < bookDTO.bookAttribute.length) {
                    System.out.printf("수정 할 %s으로 입력 해 주세요.", bookDTO.bookAttribute[userInput]);
                    userInput++;
                    switch (userInput) {
                        case 1:
                            tmpISBN = sc.nextLong();
                            sc.nextLine();
                            for (BookDTO book: bookDTOList.getBookDTOList())
                            {
                                if(book.getISBN() == tmpISBN && book != bookDTO)
                                {
                                    System.out.println("중복된 ISBN입니다. 메뉴로 이동합니다.");
                                    return;
                                }
                            }
                            if (bookDTO.getISBN() == tmpISBN)
                                System.out.println("기존과 같은 ISBN입니다.");
                            break;
                        case 2:
                            tmpBookName = sc.nextLine().replaceAll("\\s+$","");
                            if (bookDTO.getBookName().equals(tmpBookName))
                                System.out.println("기존과 같은 제목입니다.");
                            break;
                        case 3:
                            tmpAuthor = sc.nextLine().replaceAll("\\s+$","");
                            if (bookDTO.getAuthor().equals(tmpBookName))
                                System.out.println("기존과 같은 작가입니다.");
                            break;
                        case 4:
                            tmpPublisher = sc.nextLine().replaceAll("\\s+$","");
                            if (bookDTO.getPublisher().equals(tmpPublisher))
                                System.out.println("기존과 같은 출판사입니다.");
                            break;
                        case 5:
                            tmpPrice = sc.nextInt();
                            sc.nextLine();
                            if (bookDTO.getPrice() == tmpPrice)
                                System.out.println("기존과 같은 가격입니다.");
                            break;
                    }
                }
                else
                {
                    // 수정할 목록 외에 입력
                    System.out.println("잘못된 입력입니다.");
                    return;
                }
            }
            catch (InputMismatchException e)
            {
                // 숫자값이 비정상적으로 크거나 숫자 이외
                System.out.println("잘못된 입력입니다.");
                sc.nextLine();
                return;
            }

        bookDTO.setISBN(tmpISBN);
        bookDTO.setBookName(tmpBookName);
        bookDTO.setAuthor(tmpAuthor);
        bookDTO.setPublisher(tmpPublisher);
        bookDTO.setPrice(tmpPrice);
        System.out.println("수정이 완료되었습니다.");
        System.out.println("1. 수정 계속하기\t2. 중단");
        try {
            userInput = sc.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.");
        }
        // 재귀하는 부분
        if      (userInput == 1) editBook(sc,bookDTO,bookDTOList);
        else if (userInput == 2) System.out.println("메뉴로 이동합니다.");
        else    System.out.println("잘못된 입력입니다. 메뉴로 이동합니다.");
    }

    // 도서 이름/ISBN 검색 방법과 도서관리 시스템 전부다 출력해서 순번골라서 검색하는것 중 고르기.
    public BookDTO bookMenuSelect(Scanner sc,BookDTOList bookDTOList, BookManageView bookManageView)
    {
        System.out.println("1. 도서 이름/ISBN으로 검색하기\t2. 도서관리 시스템 도서 목록 전부 출력 한 후 검색하기");
        int userInput;
        try
        {
            userInput = sc.nextInt();
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
                return bookSearch(sc,bookDTOList,bookManageView);
            case 2:
                return bookViewAndSelect(sc, bookDTOList, bookManageView);
            default:
                System.out.println("잘못된 입력입니다.");
                return null;
        }
    }
    //
    // 다 출력해서 고르는것
    public BookDTO bookViewAndSelect(Scanner sc,BookDTOList bookDTOList, BookManageView bookManageView)
    {
        bookManageView.viewBookAll(bookDTOList.getBookDTOList());
        int userInput;
        try
        {
            System.out.println("원하시는 도서 순번을 고르시오.");
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
            return bookDTOList.getBookDTOList().get(userInput - 1);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("잘못된 접근입니다.");
            return null;
        }
    }
    // 여기는 검색해서 하는것
    public BookDTO bookSearch(Scanner sc, BookDTOList bookDTOList,BookManageView bookManageView)
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
                System.out.println("도서 이름을 입력해 주세요.");
                bookName = sc.nextLine();
            }
            else if (answer == 2)
            {
                System.out.println("도서 ISBN을 입력해 주세요.");
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
            for (BookDTO bookDTO : bookDTOList.getBookDTOList())
            {
                if ((answer == 1 && bookDTO.getBookName().replaceAll("\\s","").equals(bookName.replaceAll("\\s",""))
                        || (answer == 2 && bookDTO.getISBN() == bookISBN)))
                {
                    tmpBookDTOList.add(bookDTO);
                }
            }
            if (tmpBookDTOList.size() > 1)
            {
                System.out.printf("같은 도서가 %d권 있습니다.\n", tmpBookDTOList.size());
                bookManageView.viewBookAll(tmpBookDTOList);
                System.out.println("원하시는 도서의 순번을 입력해 주세요.");
                try
                {
                    answer = sc.nextInt();
                    sc.nextLine();
                    return tmpBookDTOList.get(answer-1);
                }
                catch (InputMismatchException e)
                {
                    sc.nextLine();
                    System.out.println("잘못된 입력입니다.");
                    return null;
                }
                catch (IndexOutOfBoundsException e)
                {
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
                    System.out.printf("도서정보시스템에는 도서 이름이 %s 도서는 없습니다.", bookName);
                    return null;
                } else if (answer == 2) {
                    System.out.printf("도서정보시스템에는 ISBN이 %d인 도서는 없습니다.", bookISBN);
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
