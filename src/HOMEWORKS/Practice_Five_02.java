package HOMEWORKS;

import javax.swing.*;
import java.awt.event.ActionEvent;

/*2. 为实验一的任务4设计图形界面：
编写一个简单的模拟抽奖程序（模拟抽奖3.0），
程序运行后会随机生成5个1~16幸运号码，
然后在图形界面提示“请您抽奖”，
等待用户输入5个1~16不重复的整数作为抽奖号码。
开始抽奖后，程序判断用户输入的号码与系统生成的幸运号码是否一致，
给出用户中奖结果。
抽奖规则：如果用户输入的号码中分别有5、4、3个号码与幸运号码一致，
则分别判定为一等奖、二等奖、三等奖，
否则判定为未中奖。
要求给出必要的提示信息，
如输入号码的数值范围限制；
提供关闭按钮或菜单项，
当用户希望结束抽奖时可以自主退出程序的运行。
*/
public class Practice_Five_02 extends JFrame {
    int times=0;
    int times_goal=0;
    int[] ins =new int[6];
    int[] tar = new int[6];
    public static void main(String[] args) {
        Practice_Five_02 a= new Practice_Five_02();
    }
    public Practice_Five_02(){
        init();
    }
    public void init(){
        jf = new JFrame();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(3);
        jf.setBounds(0,0,300,200);
        jp = new JPanel();
        jp.setBounds(0,0,300,200);
        jp.setLayout(null);
        jf.add(jp);
        message = new JLabel();
        message.setBounds(100,60,140,40);
        message.setHorizontalAlignment(0);
        act = new JButton();
        act.setBounds(130,150,40,20);
        act.setText("键入");
        act.addActionListener(e -> actPerform(e));
        input = new JTextField();
        input.setBounds(100,20,100,40);
        jp.add(input);
        jp.add(act);
        jp.add(message);
    }
    public void actPerform(ActionEvent e){

        int input1;
        input1=Integer.parseInt(input.getText());
        if((input1>=0&&input1<=16)&&times<5){
            for(int i=0;i<6;i++){
                if(ins[i]==input1) {
                    message.setText("输入数据重复");
                    return;
                }
            }
            ins[times]=input1;
            times++;
            message.setText("第"+(times)+"次数据输入成功");
            input.setText("");
        }else if(!(input1>=0&&input1<=16)&&times<=5){
            message.setText("输入数据错误");
        }
        if(times==5){
            for(int i=0;i<4;i++){
                if(ins[i]==input1) {
                    message.setText("输入数据重复");
                    return;
                }
            }
            ins[times]=input1;
            times++;
            message.setText("第"+(times+1)+"次数据输入成功");
            input.setText("");
            //开始进行随机数生成和比对
            times=0;//refresh times
            for(int i=0;i<6;i++){
                tar[i]=(int)(16*Math.random());
            }
            for(int i=0;i<6;i++){
                if(ins[i]==tar[i])
                    times_goal++;
            }
            if(times_goal>=5){
                message.setText("恭喜获得一等奖🎉");
            }else if(times_goal >=4){
                message.setText("恭喜获得二等奖🎉");
            }else if (times_goal>=3){
                message.setText("恭喜获得三等奖🎉");
            }else{
                message.setText("很遗憾，未中奖🐶");
            }
            times_goal=0;//refresh goal times record;
        }
    }
    public JFrame jf;
    public JPanel jp;
    public JTextField input;
    public JLabel message;
    public JLabel output;
    public JButton act;

}
