package com.haowei.yu;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data=new int[4][4];

    int[][] win={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    int x=0,y=0;
    int step=0;

    JMenuItem replayItem=new JMenuItem("重新游戏");
    JMenuItem reLoginItem=new JMenuItem("重新登录");
    JMenuItem closeItem=new JMenuItem("关闭游戏");
    JMenuItem girl=new JMenuItem("女孩");
    JMenuItem animal=new JMenuItem("动物");
    JMenuItem sports=new JMenuItem("运动");
    JMenuItem accountItem=new JMenuItem("打赏码");
    String path="image\\animal\\animal8\\";
    public GameJFrame(){
        init();

        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initImage();

        this.setVisible(true);
    }
    private void initData() {
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for(int i=0;i<tempArr.length;i++){
            int index=r.nextInt(tempArr.length);
            int t=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=t;
        }

        for(int i=0;i<tempArr.length;i++){
            if(tempArr[i]==0){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=tempArr[i];
        }
    }
    private void initImage() {
        //添加背景图片
        this.getContentPane().removeAll();

        if(victory()){
            JLabel winJLabel=new JLabel(new ImageIcon("image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }
        //管理步数(文字)
        JLabel stepCount=new JLabel("步数: "+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);


        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                StringBuilder sb=new StringBuilder(path);
                int k=(data[i-1][j-1]);
                sb.append(k+".jpg");
                String s=sb.toString();
                //创建一个图片ImageIcon对象
                ImageIcon icon1=new ImageIcon(s);
                //创建一个JLabel的对象(管理容器)
                JLabel jLabel1 =new JLabel(icon1);
                //指定图片位置
                jLabel1.setBounds((j-1)*105+83,(i-1)*105+134,105,105);
                //添加边框(0是凸起,1是凹下去)
                jLabel1.setBorder(new BevelBorder(1));

                //把管理容器添加到界面中
                //this.add(jLabel);
                this.getContentPane().add(jLabel1);
            }
        }

        //添加背景图片(先添加的在上方)
        JLabel background=new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }
    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar=new JMenuBar();
        //创建菜单上面的两个选项的对象(功能,关于我们)
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu =new JMenu("关于我们");
        JMenu changephoto =new JMenu("更换图片");
        //创建选项下面的条目对象(挪到成员变量里去了)

        //条目添加到选项里
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(changephoto);

        aboutJMenu.add(accountItem);

        changephoto.add(girl);
        changephoto.add(animal);
        changephoto.add(sports);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sports.addActionListener(this);
        //将菜单里面的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    private void init() {
        this.setSize(603,680);
        this.setTitle("拼图单机版 v1.0");
        //一直置顶,可有可不有
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置默认的关闭模式
        this.setDefaultCloseOperation(3);

        //取消默认的居中放置
        this.setLayout(null);
        this.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按下不松时会调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==65){
            //把界面中的所有图片全部删除
            this.getContentPane().removeAll();
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            JLabel background=new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(victory()){
            return;
        }

        int code=e.getKeyCode();
        if(code==37){
            System.out.println("left");
            if(y+1<4){
                data[x][y]=data[x][y+1];
                data[x][y+1]=0;
                y++;
                step++;
                initImage();
            }
        }else if(code==38){
            System.out.println("upper");
            if(x+1<4){
                data[x][y]=data[x+1][y];
                data[x+1][y]=0;
                x++;
                step++;
                initImage();
            }
        }else if(code==39){
            System.out.println("right");
            if(y-1>=0){
                data[x][y]=data[x][y-1];
                data[x][y-1]=0;
                y--;
                step++;
                initImage();
            }
        }else if(code==40){
            System.out.println("below");
            if(x-1>=0){
                data[x][y]=data[x-1][y];
                data[x-1][y]=0;
                x--;
                step++;
                initImage();
            }
        }else if(code==65){
            initImage();
        }else if(code==87){
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x=3;
            y=3;
            initImage();
        }
    }
    //判断是否胜利
    public boolean victory(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(data[i][j]!=win[i][j])return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目
        Object obj= e.getSource();
        if(obj==replayItem){
            System.out.println("重新游戏");
            step=0;
            initData();
            initImage();

        }else if(obj==reLoginItem){
            System.out.println("重新登录");
            this.setVisible(false);
            new LoginJFrame();
        }else if(obj==closeItem){
            System.out.println("关闭游戏");
            //关闭游戏并退出虚拟机
            System.exit(0);
        }else if(obj==accountItem){
            System.out.println("打赏码");
            //创建一个弹框对象
            JDialog jDialog=new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jlabel=new JLabel(new ImageIcon("image\\shang.jpg"));
            jlabel.setBounds(0,0,498,498);
            jDialog.getContentPane().add(jlabel);
            //设置大小
            jDialog.setSize(500,500);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        }else if(obj==girl){
            step=0;
            path="image\\girl\\girl1\\";
            initData();
            initImage();
        }else if(obj==animal){
            step=0;
            path="image\\animal\\animal8\\";
            initData();
            initImage();
        }else if(obj==sports){
            step=0;
            path="image\\sport\\sport2\\";
            initData();
            initImage();
        }
    }
}
