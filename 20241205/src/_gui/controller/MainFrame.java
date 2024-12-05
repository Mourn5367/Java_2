package _gui.controller;

import _gui.view.OrderInfoView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;
    public int frameX = 300;
    public int frameY = 150;
    MainFrame()
    {
        super("검색 프로그램");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.width/2-FRAME_WIDTH/2);
        System.out.println(screenSize.height/2-FRAME_HEIGHT/2);
        frameX = (int)((0.5)*(screenSize.width-FRAME_WIDTH));
        frameY = (int)((0.5)*(screenSize.height-FRAME_HEIGHT));
        setLocation(frameX,frameY );
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        OrderInfoView orderInfoView = new OrderInfoView();
        add(orderInfoView,"Center");

        setVisible(true);

    }

    public static void main(String[] args)
    {
        new MainFrame();
    }
}
