package _gui.repository;

import _gui.JDBCConnector;
import _gui.entity.OrderEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderRepository
{
    ArrayList<OrderEntity> orderList = new ArrayList<>();



    public ArrayList<OrderEntity> getOrderList(String searchWord)
    {
        Connection con = JDBCConnector.getConnection();

        String sql = "select 주문번호, 고객이름, 제품명, 수량, 배송지, 주문일자" +
                " from 주문 o, 고객 c, 제품 p" +
                " where o.주문고객 = c.고객아이디 and o.주문제품 = p.제품번호" +
                " and c.고객이름 like ?";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            // sql은 1 ? 에 해당하는건 pstmt.setString으로 설정함
            pstmt.setString(1, "%" + searchWord +"%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                OrderEntity order = new OrderEntity();
                order.setOrderNum(rs.getString("주문번호"));
                order.setCustomerName(rs.getString("고객이름"));
                order.setProductName(rs.getString("제품명"));
                order.setAmount(rs.getInt("수량"));
                order.setDestination(rs.getString("배송지"));
                order.setOrderDate(rs.getTimestamp("주문일자"));
                orderList.add(order);
            }
            con.close();
            rs.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return orderList;
    }
}
