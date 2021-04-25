/*
 * Created by JFormDesigner on Sun Apr 25 20:51:36 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 * @author a
 */
public class DeliveryInput extends JFrame {
    public DeliveryInput() {
        initComponents();
    }

    public static void main(String[] args) {
        DeliveryInput a = new DeliveryInput();
        a.setVisible(true);
        a.setDefaultCloseOperation(3);
    }
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        mainMenu menu = new mainMenu();
        menu.setVisible(true);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void enterActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection conn =null;
        PreparedStatement st =null;
        try {
            conn=JdbcUtils.getConnection();
            String sql="INSERT INTO `Tran`.`Deliver`(`Cno`, `Driver`, `Pname`, `Consumer`, `Price`, `NowLoc`, `TarLoc`)" +
                    " VALUES (?,?,?,?,?,?,?)";
            st=conn.prepareStatement(sql);
            st.setString(1,t1.getText());
            st.setString(2,t2.getText());
            st.setString(3,t3.getText());
            st.setString(4,t4.getText());
            st.setString(5,t5.getText());
            st.setString(6,t6.getText());
            st.setString(7,t7.getText());
            st.executeUpdate();
            err.setText("提交成功");
            err.setForeground(Color.black);
        } catch (SQLException throwables) {
            err.setText("提交失败,请检查输入的数据是否河里");
            err.setForeground(Color.red);
            throwables.printStackTrace();
        }

    }

    private void manageActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        DeliveryInfo a=new DeliveryInfo();
        a.setVisible(true);
        a.setDefaultCloseOperation(3);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        back = new JButton();
        manage = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        enter = new JButton();
        err = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- title ----
            title.setText("\u914d\u9001\u4fe1\u606f\u8f93\u5165");
            title.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(265, 15), title.getPreferredSize()));

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- manage ----
            manage.setText("\u4e1a\u52a1\u7ba1\u7406");
            manage.addActionListener(e -> manageActionPerformed(e));
            panel1.add(manage);
            manage.setBounds(new Rectangle(new Point(510, 5), manage.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u8f66\u724c\u53f7");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(210, 70), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u9a7e\u9a76\u5458");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(210, 110), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u4ea7\u54c1\u540d");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(210, 145), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u8d2d\u4e70\u8005");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(210, 185), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u4ef7\u683c");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(215, 225), label5.getPreferredSize()));

            //---- label6 ----
            label6.setText("\u5f53\u524d\u4f4d\u7f6e");
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(205, 265), label6.getPreferredSize()));

            //---- label7 ----
            label7.setText("\u914d\u9001\u4f4d\u7f6e");
            panel1.add(label7);
            label7.setBounds(new Rectangle(new Point(205, 305), label7.getPreferredSize()));
            panel1.add(t1);
            t1.setBounds(280, 60, 130, 30);
            panel1.add(t2);
            t2.setBounds(280, 100, 130, 30);
            panel1.add(t3);
            t3.setBounds(280, 140, 130, t3.getPreferredSize().height);
            panel1.add(t4);
            t4.setBounds(280, 180, 130, t4.getPreferredSize().height);
            panel1.add(t5);
            t5.setBounds(280, 220, 130, t5.getPreferredSize().height);
            panel1.add(t6);
            t6.setBounds(280, 260, 130, t6.getPreferredSize().height);
            panel1.add(t7);
            t7.setBounds(280, 300, 130, t7.getPreferredSize().height);

            //---- enter ----
            enter.setText("\u63d0\u4ea4");
            enter.addActionListener(e -> enterActionPerformed(e));
            panel1.add(enter);
            enter.setBounds(new Rectangle(new Point(285, 345), enter.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(165, 385, 315, 40);

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
        panel1.setBounds(0, 0, 605, 445);

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
    private JLabel title;
    private JButton back;
    private JButton manage;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    public JTextField t1;
    public JTextField t2;
    public JTextField t3;
    public JTextField t4;
    public JTextField t5;
    public JTextField t6;
    public JTextField t7;
    private JButton enter;
    public JLabel err;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
