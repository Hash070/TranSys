package GUI_PROGRAM;

import java.awt.event.*;
import javax.swing.*;
public class Listening implements ActionListener {
    JButton button;
    public int a=0;
    public static void main(String[] args) {
        Listening l=new Listening();
        l.go();
    }
    public void go()
    {
        JFrame frame=new JFrame();
        button=new JButton();
        button.addActionListener(this);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        button.setText("This is a button");
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event)
    {
        button.setText("I've been clicked");
        a++;
        System.out.println("the button has been operated "+a+" times");
        if(a%2==0)
            button.setText("This is a button");
    }
}
