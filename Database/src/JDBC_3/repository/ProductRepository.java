package JDBC_3.repository;

import JDBC_1.JDBCConnector;
import JDBC_3.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {

    public static ArrayList<Product> getList(String type, String searchWord)
    {
        ArrayList<Product> arrList = new ArrayList<>();
        Connection con = JDBCConnector.getConnection();
        String sql = "select * from 제품 where " + type + " like ?";

        try
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.setProductNum(rs.getString("제품번호"));
                product.setProductName(rs.getString("제품명"));
                product.setProductStock(rs.getInt("재고량"));
                product.setProductPrice(rs.getInt("단가"));
                product.setProduceName(rs.getString("제조업체"));
                arrList.add(product);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return arrList;
    }
    public static ArrayList<Product> getList()
    {
        ArrayList<Product> arrList = new ArrayList<>();
        Connection con = JDBCConnector.getConnection();
        String sql = "select * from 제품";

        try
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.setProductNum(rs.getString("제품번호"));
                product.setProductName(rs.getString("제품명"));
                product.setProductStock(rs.getInt("재고량"));
                product.setProductPrice(rs.getInt("단가"));
                product.setProduceName(rs.getString("제조업체"));
                arrList.add(product);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return arrList;
    }
}
