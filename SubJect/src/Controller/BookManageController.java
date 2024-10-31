package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import DTO.BookDTOList;
import Service.BookService;
import DTO.BookDTO;
import View.BookManageView;

public class BookManageController
{
    public final String[] initMenu =
            {"도서정보추가","조회","수정/변경","삭제","출력","종료"};
    private enum MENU
    {
        ADD_BOOK,
        CHECK_BOOK,
        EDIT_BOOK,
        DELETE_BOOK,
        PRINT_BOOK,
        EXIT_MENU
    }
    private enum BMSState
    {
        SELECT_MENU,
        OUT,
    }
    public static void main(String[] args)
    {
        BookManageController bookManageController = new BookManageController();
        BookManageView bookManageView = new BookManageView();
        BookService bookService = new BookService();
        Scanner sc = new Scanner(System.in);
        BookDTOList bookDTOList = new BookDTOList();
        BMSState currentBMSState = BMSState.SELECT_MENU;
        MENU[] Menus = MENU.values();
        MENU currentMenu;
        BookDTO tmpBookDTO;
        System.out.println("===도서관리시스템에 접속하였습니다.===");


        while(true)
        {
            switch(currentBMSState)
            {
                case SELECT_MENU:
                    bookManageController.viewMenu();
                    System.out.print("원하시는 메뉴를 선택하여 주세요 !: ");
                    int temp;
                    try {
                        temp = sc.nextInt();
                        sc.nextLine();
                        currentMenu = Menus[temp - 1];
                    }
                    catch(InputMismatchException e)
                    {
                        sc.nextLine();
                        System.out.println("잘못된 입력입니다.");
                        continue;
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("잘못된 접근입니다.");
                        continue;
                    }
                    switch(currentMenu)
                    {
                        case ADD_BOOK: // 1 추가
                            bookService.newBook(sc,bookDTOList);
                        break;
                        case CHECK_BOOK : // 2 조회
                            if(bookDTOList.getBookDTOList().isEmpty())
                            {
                                System.out.println("도서가 없어 조회가 불가능합니다.");
                                break;
                            }
                            tmpBookDTO = bookService.bookMenuSelect(sc,bookDTOList,bookManageView);
                            if (tmpBookDTO != null) bookManageView.viewBookOne(tmpBookDTO);
                            else System.out.println("메뉴 선택으로 이동합니다.");
                            break;
                        case EDIT_BOOK: // 3 수정
                            if(bookDTOList.getBookDTOList().isEmpty())
                            {
                                System.out.println("도서가 없어 수정이 불가능합니다.");
                                break;
                            }
                            tmpBookDTO = bookService.bookMenuSelect(sc,bookDTOList,bookManageView);
                            if (tmpBookDTO != null) bookService.editBook(sc,tmpBookDTO,bookDTOList);
                            else System.out.println("메뉴 선택으로 이동합니다.");
                            break;
                        case DELETE_BOOK: // 4 삭제
                            if(bookDTOList.getBookDTOList().isEmpty())
                            {
                                System.out.println("도서가 없어 삭제가 불가능합니다.");
                                break;
                            }
                            tmpBookDTO = bookService.bookMenuSelect(sc,bookDTOList,bookManageView);
                            if (tmpBookDTO != null) bookService.deleteBook(bookDTOList,tmpBookDTO);
                            else System.out.println("메뉴 선택으로 이동합니다.");
                            break;
                        case PRINT_BOOK: // 5 출력
                            if(bookDTOList.getBookDTOList().isEmpty())
                            {
                                System.out.println("도서가 없어 출력이 불가능합니다.");
                                break;
                            }
                            bookManageView.viewBookAll(bookDTOList.getBookDTOList());
                            break;
                        case EXIT_MENU: // 6 종료
                            currentBMSState = BMSState.OUT;
                            break;
                        default:
                            System.out.println("잘못된 입력입니다.");
                    }
                    break;
                case OUT:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
            }
        }
    }

    private void viewMenu()
    {
        int count = 0;
        for(String menu : initMenu)
        {
            System.out.printf("%d. %s", ++count, menu);
            if (count != initMenu.length)
                System.out.print(", ");
            else
                System.out.println();
        }
    }

}
