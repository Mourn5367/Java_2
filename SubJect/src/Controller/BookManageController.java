package Controller;

import java.util.Scanner;

import DTO.BookDTOList;
import Service.BookService;
import DTO.BookDTO;
import View.BookManageView;

public class BookManageController
{
    private final String[] initMenu =
            {"도서정보추가","조회","수정/변경","삭제","출력"};
    private enum MENU
    {
        ADD_BOOK,
        CHECK_BOOK,
        EDIT_BOOK,
        DELETE_BOOK,
        PRINT_BOOK,
    }
    private enum BMSState
    {
        VIEW_MENU,
        SELECT_MENU,
        PROCESSING_MENU,
        ESCAPE,
        OUT,
    }
    public static void main(String[] args)
    {
        BookManageController bookManageController = new BookManageController();
        BookManageView bookManageView = new BookManageView();
        BookService bookService = new BookService();
        Scanner sc = new Scanner(System.in);
        BookDTOList bookDTOList = new BookDTOList();
        BMSState currentBMSState = BMSState.VIEW_MENU;
        MENU[] Menus = MENU.values();
        MENU currentMenu;
        System.out.println("===도서관리시스템에 접속하였습니다.===");
        while(true)
        {
            switch(currentBMSState)
            {
                case VIEW_MENU:
                    bookManageController.viewMenu();
                    currentBMSState = BMSState.SELECT_MENU;
                    break;
                case SELECT_MENU:
                    System.out.print("원하시는 메뉴를 선택하여 주세요!: ");
                    int tem = sc.nextInt();
                    currentMenu = Menus[tem-1];
                    switch(currentMenu)
                    {
                        case ADD_BOOK:
                            bookService.newBook(sc,bookDTOList);
                            currentBMSState = BMSState.VIEW_MENU;
                        break;

                        case CHECK_BOOK:
                        break;

                        case EDIT_BOOK:
                        break;

                        case DELETE_BOOK:
                        break;

                        case PRINT_BOOK:
                            bookManageView.viewBookAll(bookDTOList);
                            currentBMSState = BMSState.VIEW_MENU;
                        break;
                    }
                    break;
                case OUT:
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
    private void newBook()
    {

    }

}
