/*
 * Created by JFormDesigner on Sun Mar 28 10:47:46 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author a
 */
public class Reg extends JFrame {
    public Reg() {
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Login login =new Login();
        login.setVisible(true);
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println(name.getText());
//        String pa;
//        pa=name.getText();
//        String pb=new String(p1.getPassword());
//        System.out.printf("%s",pb);
        String pa=new String(p1.getPassword());
        String pb=new String(p2.getPassword());
        if(pa.equals(pb)&&pa.length()!=0)//？？？？？？？
        {
            System.out.println("Checked");
            System.out.println(pa);
            try {
                new User_Reg(name.getText(),pa);
                err.setText("注册成功");
                err.setForeground(Color.green);
            } catch (AccountEcho accountEcho) {
                err.setText("用户名：\""+accountEcho.getAccount()+"\"已被注册");
                err.setForeground(Color.red);
            }
        }
        else
        {
            Error error=new Error();
//            error.setVisible(true);
//            error.setDefaultCloseOperation(EXIT_ON_CLOSE);
//            error.error_name.setText("您输入的密码有误");
            err.setText("您两次输入的密码不一致");
//            try {
//                sleep(1000);err.setText("");
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
//            Thread.currentThread().sleep(1000);
//            try{
//            TimeUnit.SECONDS.sleep(1);

//            }
//            catch(InterruptedException e1){
//                e1.printStackTrace();
//            }
        }


    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        name = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        label4 = new JLabel();
        button1 = new JButton();
        back = new JButton();
        err = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u6ce8\u518c");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
            label1.setBounds(160, 35, 75, 35);

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(80, 75), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u5bc6\u7801");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(85, 115), label3.getPreferredSize()));
            panel1.add(name);
            name.setBounds(130, 70, 150, 30);
            panel1.add(p1);
            p1.setBounds(130, 110, 150, 30);
            panel1.add(p2);
            p2.setBounds(130, 150, 150, 30);

            //---- label4 ----
            label4.setText("\u786e\u8ba4");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(85, 155), label4.getPreferredSize()));

            //---- button1 ----
            button1.setText("\u6ce8\u518c");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(165, 200), button1.getPreferredSize()));

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> button2ActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(0, 0), back.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            err.setForeground(Color.red);
            panel1.add(err);
            err.setBounds(115, 230, 180, 40);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 390, 295);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField name;
    private JPasswordField p1;
    private JPasswordField p2;
    private JLabel label4;
    private JButton button1;
    private JButton back;
    private JLabel err;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
