package JDBC_3.controller;
import JDBC_3.entity.Product;
import JDBC_3.repository.ProductRepository;
import JDBC_3.service.ProductService;
import JDBC_3.service.ProductServiceImpl;
import JDBC_3.view.MenuView;
import JDBC_3.view.ProductView;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args)
    {
        Scanner sci = new Scanner(System.in);
        Scanner scw = new Scanner(System.in);

        int menu = MenuView.printMenu(sci);

        ProductService productService = new ProductServiceImpl();

        switch (menu) {
            case 1:
                productService.search(sci,scw);
                break;
            case 2:
                break;
            case 3:
                break;
        }

        scw.close();
        sci.close();
    }
}
