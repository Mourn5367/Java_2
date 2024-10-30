package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import DTO.BookDTOList;
import Service.BookService;
import DTO.BookDTO;
import View.BookManageView;

public class BookManageController
{
    private final String[] initMenu =
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
        PROCESSING_MENU,
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
                        sc.nextLine();
                        System.out.println("잘못된 접근입니다.");
                        continue;
                    }
                    switch(currentMenu)
                    {
                        case ADD_BOOK:
                            bookService.newBook(sc,bookDTOList);
                        break;
                        case PRINT_BOOK:
//                            bookManageView.viewBookAll(bookDTOList);
//                            currentBMSState = BMSState.VIEW_MENU;
                            bookManageView.viewBookAll(bookDTOList);
                            break;
                        case EDIT_BOOK:
                            bookService.editBook(sc,bookDTOList);
                            break;
                        case EXIT_MENU:
                            currentBMSState = BMSState.OUT;
                            break;
                        case CHECK_BOOK :
                        case DELETE_BOOK:
//                            bookService.deleteBook(sc,bookDTOList);
//                            currentBMSState = BMSState.VIEW_MENU;
                            bookService.bookSearch(sc,bookDTOList,temp,bookManageView);
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

//        BookDTO tmp = bs.newBook(sc);
//        if (tmp == null)
//        {
//            System.out.println("asd");
//        }
//        else { bookDTOList.appendBookDTO(tmp);}

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
