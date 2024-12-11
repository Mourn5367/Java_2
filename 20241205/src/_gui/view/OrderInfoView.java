package _gui.view;

import _gui.entity.OrderEntity;
import _gui.repository.OrderRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class OrderInfoView extends JPanel
{

    static final String TITLE = "검색 프로그램";

    JPanel panN = new JPanel(new GridLayout(2,1));
    JPanel panC = new JPanel(new BorderLayout(5, 20));

    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();

    JTextField tfSearch = new JTextField(20);
    DefaultTableModel tableModel;
    JTable table;


    String[] header = {"주문번호","주문고객","주문제품","수량","배송지","주문일자"};
    
    public OrderInfoView()
    {
        // FlowLayout => BorderLayout으로 설정함.
        setLayout(new BorderLayout(5,20));

        panN.add(pan1);
        panN.add(pan2);

        this.add(panN, "North");
        this.add(panC, "Center");

        addPan1();
        addPan2();
        addTable();

        initList("");
    }

    public void addPan1()
    {
        JLabel labelTitle = new JLabel(TITLE);
        pan1.add(labelTitle);
    }
    public void addPan2()
    {
        JLabel labelSearch = new JLabel("검색어: ");
        JButton btnSearch = new JButton("검색");
        btnSearch.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                initList(tfSearch.getText());
            }
        });

        pan2.add(labelSearch);
        pan2.add(tfSearch);
        pan2.add(btnSearch);
    }
    public void addTable()
    {
        tableModel = new DefaultTableModel(header,15)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        table = new JTable(tableModel);

        TableColumnModel columnModel = table.getColumnModel();

        int interval[] = {70,100,180,50,200,100};
        for (int i = 0; i < interval.length; i++)
        {
            columnModel.getColumn(i).setPreferredWidth(interval[i]);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        panC.add(scrollPane);
    }

    public void initList(String searchWord)
    {
        OrderRepository orderRepository = new OrderRepository();
        ArrayList<OrderEntity> orderList = orderRepository.getOrderList(searchWord);
        tableModel.setRowCount(orderList.size());
        int row = 0;
        for(OrderEntity order : orderList)
        {
            tableModel.setValueAt(order.getOrderNum(),row,0);
            tableModel.setValueAt(order.getCustomerName(),row,1);
            tableModel.setValueAt(order.getProductName(),row,2);
            tableModel.setValueAt(order.getAmount(),row,3);
            tableModel.setValueAt(order.getDestination(),row,4);
            tableModel.setValueAt(order.getOrderDate(),row,5);

            row++;
        }
    }

}
