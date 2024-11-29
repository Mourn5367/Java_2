package JDBC_3.service;

import JDBC_1.JDBCConnector;
import JDBC_3.entity.Product;
import JDBC_3.repository.ProductRepository;
import JDBC_3.view.ProductView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService
{

    @Override
    public void search(Scanner sci, Scanner scw)
    {
        System.out.println("* 검색 종류를 선택하시오.\n" +
                "* 1. 제품명\t2. 제조업체");
        int searchType = sci.nextInt();

        String type = "제품명";

        switch (searchType)
        {
            case 1:
                type = "제품명";
                break;
            case 2:
                type = "제조업체";
                break;
        }

        System.out.println("* 검색어를 입력하시오.");

        String searchWord = scw.nextLine();
        ArrayList<Product> arrList = ProductRepository.getList(type,searchWord);
        ProductView.printView(arrList);
    }
}
