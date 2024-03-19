package com.haowei.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    JButton jtb1=new JButton("点我啊");
    public MyJFrame2(){
        this.setSize(603,680);
        this.setTitle("拼图单机测试");
        //一直置顶,可有可不有
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置默认的关闭模式
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        jtb1.setBounds(0,0,100,50);
        //给按钮绑定鼠标事件
        jtb1.addMouseListener(this);
        this.getContentPane().add(jtb1);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
