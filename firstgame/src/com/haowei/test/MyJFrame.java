package com.haowei.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jtb1=new JButton("点我啊");
    JButton jtb2=new JButton("点我啊");
    boolean i=false;
    public MyJFrame(){
        this.setSize(488,500);
        this.setTitle("拼图单机测试");
        //一直置顶,可有可不有
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置默认的关闭模式
        this.setDefaultCloseOperation(3);
        this.setLayout(null);


        jtb1.setBounds(0,0,100,50);

        jtb2.setBounds(100,0,100,50);

        jtb1.addActionListener(this);
        jtb2.addActionListener(this);
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source =e.getSource();
        if(source==jtb1){
            jtb1.setSize((i?200:50),(i?200:50));
            if(i)i=false;
            else i=true;
        }else if(source==jtb2){
            Random r=new Random();
            jtb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
