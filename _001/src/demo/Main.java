package demo;

import com.sun.source.util.SourcePositions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.TimerTask;


public class Main extends JFrame implements ActionListener {
    JButton jb=new JButton("点我");
    int num=0;
    int seconds = 0;
    JLabel jl=new JLabel("次数:"+num);
    JLabel jk=new JLabel("时间:"+seconds);
    public Main(){
        init();


        jb.addActionListener(this);
        this.getContentPane().add(jb);
        this.getContentPane().add(jl);
        this.getContentPane().add(jk);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                jk.setText("时间:"+seconds);

            }

        });
        timer.start();


        this.setVisible(true);
    }
    public void init(){
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setTitle("测试");
        this.setLayout(null);
        jb.setBounds(100,50,100,50);
        jl.setBounds(20,20,100,20);
        jk.setBounds(150,20,100,20);
    }

    public static boolean is_prime(int number){
        for(int i=2;i<=Math.sqrt(number);i++){
            if((number%i)==0)return false;
        }
        return true;
    }
    public void time(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb){
            Random r=new Random();
            int x = Math.max(r.nextInt(500), 0); // 限制 x 坐标在 0 到 500 之间
            int y = Math.max(r.nextInt(550), 50); // 限制 y 坐标在 0 到 500 之间
            jb.setBounds(x, y, 100, 50);
            num++;
            jl.setText("次数:"+num);
            this.repaint();
        };

    }


}
