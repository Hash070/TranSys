/*
 * Created by JFormDesigner on Sun Mar 28 10:41:55 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author a
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }
    private static boolean login(String name,String password)
    {
        return LoginSqlQuery.login(name,password);
    }
    private void loginActionPerformed(ActionEvent e) {
        // TODO add your code here
        String pw=new String(passwordField1.getPassword());
        if(login(textField1.getText(),pw))
        {
            this.dispose();
            mainMenu menu = new mainMenu();
            menu.setVisible(true);
            menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        else{
            warn.setText("用户名或密码错误");
        }
//        Reg reg=new Reg();
//        reg.setVisible(true);
//        reg.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void regActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Reg reg=new Reg();
        reg.setVisible(true);
        reg.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        name = new JLabel();
        pw = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        login = new JButton();
        reg = new JButton();
        warn = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u7269\u6d41\u7ba1\u7406");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
            label1.setBounds(120, 35, 160, 35);

            //---- name ----
            name.setText("\u7528\u6237\u540d");
            panel1.add(name);
            name.setBounds(new Rectangle(new Point(80, 110), name.getPreferredSize()));

            //---- pw ----
            pw.setText("\u5bc6\u7801");
            panel1.add(pw);
            pw.setBounds(new Rectangle(new Point(80, 150), pw.getPreferredSize()));
            panel1.add(textField1);
            textField1.setBounds(165, 105, 100, 25);
            panel1.add(passwordField1);
            passwordField1.setBounds(165, 140, 100, 25);

            //---- login ----
            login.setText("\u767b\u9646");
            login.addActionListener(e -> loginActionPerformed(e));
            panel1.add(login);
            login.setBounds(new Rectangle(new Point(120, 215), login.getPreferredSize()));

            //---- reg ----
            reg.setText("\u6ce8\u518c");
            reg.addActionListener(e -> regActionPerformed(e));
            panel1.add(reg);
            reg.setBounds(new Rectangle(new Point(235, 215), reg.getPreferredSize()));

            //---- warn ----
            warn.setHorizontalAlignment(SwingConstants.CENTER);//this class must be declared in a method
            warn.setForeground(Color.red);
            panel1.add(warn);
            warn.setBounds(140, 180, 145, 30);

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
        panel1.setBounds(0, 0, 400, 275);

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
    private JLabel name;
    private JLabel pw;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton login;
    private JButton reg;
    private JLabel warn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
