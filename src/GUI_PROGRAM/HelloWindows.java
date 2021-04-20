package GUI_PROGRAM;

import javax.swing.*;

public class HelloWindows {
    private static void GUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame=new JFrame("hello swing");//设置窗口名字
        JLabel label=new JLabel("hello world");//add a tag //label 标签
        frame.getContentPane().add(label);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300,300);
    }

    public static void main(String[] args) {
        GUI();
    }
}
