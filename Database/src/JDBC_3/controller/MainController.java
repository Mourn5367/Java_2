package JDBC_3.controller;
import JDBC_3.entity.Product;
import JDBC_3.repository.ProductRepository;
import JDBC_3.view.ProductView;
import java.util.ArrayList;

public class MainController {
    public static void main(String[] args)
    {
        ArrayList<Product> arrList = ProductRepository.getList();
        ProductView.printView(arrList);
    }
}
