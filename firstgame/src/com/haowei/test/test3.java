package com.haowei.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test3 {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setSize(603,680);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setLayout(null);

        //创建一个按钮对象
        JButton jtb=new JButton("点我啊");
        jtb.setBounds(0,0,100,50);
        //jtb:组件对象,表示你要给哪个组件添加对象
        //addActionListener;监听的事件(动作监听左键点击,空格)
        //add是interface,MyActionListener是implement,
        //会触发MyActionListener当中的actionperfromed
        //jtb.addActionListener(new MyActionListener());
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("快点我");
            }
        });
        //将按钮添加到界面当中
        jFrame.getContentPane().add(jtb);
        jFrame.setVisible(true);
    }
}
