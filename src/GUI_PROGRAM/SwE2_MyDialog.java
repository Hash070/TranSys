package GUI_PROGRAM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SwE2_MyDialog extends JFrame{
    public static void main(String[] args) {
        new SwE2_MyDialog();
    }
    SwE2_MyDialog(){
        JFrame jframe =new JFrame();
        jframe.setBounds(100,100,100,100);
        Container container = getContentPane();//
        container.setLayout(null);
        JLabel label = new JLabel("this is a new jlable window");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(label);
        JButton button = new JButton("this is a dialog");
        button.setBounds(10,10,50,20);
        button.addActionListener(e -> diaActionPerformed(e));
        container.add(button);
//        container.setBounds(100,100,100,100);
        jframe.add(container);
//        setVisible(true);
        jframe.setVisible(true);
        container.setVisible(true);
    }

    private void diaActionPerformed(ActionEvent e) {
        new MyDialog(SwE2_MyDialog.this).setVisible(true);
    }

}
class MyDialog extends JDialog {
    public MyDialog(SwE2_MyDialog f){
        super(f,"Myfirst Dialog frame",true);
        Container con=getContentPane();
        con.add(new JLabel("this is a dialog"));
        setBounds(100,100,100,100);
    }

}
