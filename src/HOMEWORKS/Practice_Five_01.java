package HOMEWORKS;

import javax.swing.*;
import java.awt.event.ActionEvent;

/*
* 1.为实验一的任务3设计图形界面：某商场为了促销，采用了打折的优惠活动。
* 每位顾客一次购物达到500元以上，给予95%的优惠；
* 达到1000元以上，给予90%的优惠；
* 达到1500元以上，给予85%的优惠；
* 达到2500元以上，给予80%的优惠。
* 程序运行后，用户在图形界面输入购物金额，
* 程序计算经过优惠后顾客应付的实际金额，
* 结果保留两位小数，
* 并告知用户。*/
public class Practice_Five_01 extends JFrame {
    public static void main(String[] args) {
        new Practice_Five_01();
    }
    public Practice_Five_01(){
        init();
    }
    public void init(){
        start =new JButton();
        start.setText("确认");
        start.setBounds(170,30,40,20);
        jf = new JFrame();
        jf.setTitle("打折计算程序");
        jf.setLayout(null);
        jf.setBounds(100,100,300,150);
        jp = new JPanel();
        input = new JTextField();
        output = new JLabel();
        output.setBounds(80,60,80,20);
        jp.setLayout(null);
        jp.add(start);
        start.addActionListener(e -> startButton(e));
        jp.setBounds(0,0,300,150);
        input.setBounds(80,30,80,20);
        jp.add(input);
        jp.add(output);
        jf.add(jp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(3);

    }
    public void startButton(ActionEvent e){
        String in;
        in=input.getText();
        int in_;
        double sum;
        in_ = Integer.parseInt(in);
        System.out.println(in_);
        if(in_>2500){
            sum=in_ * 0.8;
            in=String.format("%.2f",sum);
            output.setText(in);
        }else if(in_>1500){
            sum=in_ * 0.85;
            in=String.format("%.2f",sum);
            output.setText(in);
        }else if(in_>1000){
            sum=in_ * 0.90;
            in=String.format("%.2f",sum);
            output.setText(in);
        }else if(in_>500){
            sum=in_ * 0.95;
            in=String.format("%.2f",sum);
            output.setText(in);
        }else if(in_>=0){
            in = String.format("%.2f",(double)in_);
            output.setText(in);
        }

    }
    public JFrame jf;
    public JPanel jp;
    public JTextField input;
    public JLabel output;
    public JButton start;
}
