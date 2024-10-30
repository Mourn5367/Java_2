package JDBC_3.view;

import JDBC_3.entity.Product;

import java.util.ArrayList;

public class ProductView
{
    public void printHeader()
    {
        System.out.println("****************");
        System.out.println("* Product List *");
        System.out.println("****************");
    }
    public void printFooter()
    {
        System.out.println("****************");
        System.out.println("* End    Print *");
        System.out.println("****************");
    }

    public void printProduct(ArrayList<Product> proList )
    {
        for(Product pro : proList)
        {
            System.out.println(" *\t제품번호:\t"+pro.getProductNum());
            System.out.println(" *\t제품명:\t\t"+pro.getProductName());
            System.out.println(" *\t재고량:\t\t"+pro.getProductStock());
            System.out.println(" *\t단가:\t\t"+pro.getProductPrice());
            System.out.println(" *\t제조업체:\t"+pro.getProduceName()+"\n");
        }
    }
    public static void printView(ArrayList<Product> arrList) {
        ProductView view = new ProductView();
        view.printHeader();
        view.printProduct(arrList);
        view.printFooter();
    }
}
