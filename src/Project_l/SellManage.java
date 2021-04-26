/*
 * Created by JFormDesigner on Mon Apr 26 15:32:47 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author a
 */
public class SellManage extends JFrame {
    public SellManage() {
        initComponents();
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
            String sql="INSERT INTO `Tran`.`StoreHouseAndSellingInfo`(`ProductName`, `ProductLoc`, `ProductQuantity`, `ProductPrice`, `time`, `Consumer`, `Tel`, `Address`) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
            st=conn.prepareStatement(sql);
            st.setString(1,t1.getText());
            st.setString(2,t7.getText());
            st.setString(3,t2.getText());
            st.setString(4,t3.getText());
            st.setString(5,t4.getText());
            st.setString(6,t5.getText());
            st.setString(7,t6.getText());
            st.setString(8,t8.getText());//没对准，导致了数据被截断的bug。。。。。
            st.executeUpdate();
            err.setText("提交成功");
            err.setForeground(Color.black);
        } catch (SQLException throwables) {
            err.setText("提交失败,请检查输入的数据是否河里");
            err.setForeground(Color.red);
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }

    private void timeActionPerformed(ActionEvent e) {
        // TODO add your code here
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化Date格式的方法。
        long now = new Date().getTime();
        System.out.println(df.format(now));
        t4.setText(df.format(now));
    }

    private void doneActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection conn =null;
        PreparedStatement st =null;
        try {
            conn=JdbcUtils.getConnection();
            String sql="INSERT INTO `Tran`.`StoreHouseAndSellingInfo`(`ProductName`, `ProductLoc`, `ProductQuantity`, `ProductPrice`, `time`, `Consumer`, `Tel`, `Address`,`Status`) " +
                    "VALUES (?,?,?,?,?,?,?,?,0)";
            st=conn.prepareStatement(sql);
            st.setString(1,t1.getText());
            st.setString(2,t7.getText());
            st.setString(3,t2.getText());
            st.setString(4,t3.getText());
            st.setString(5,t4.getText());
            st.setString(6,t5.getText());
            st.setString(7,t6.getText());
            st.setString(8,t8.getText());//没对准，导致了数据被截断的bug。。。。。
            st.executeUpdate();
            err.setText("发票打印成功");
            err.setForeground(Color.black);
        } catch (SQLException throwables) {
            err.setText("发票打印失败,请检查输入的数据是否河里");
            err.setForeground(Color.red);
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        back = new JButton();
        title = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        enter = new JButton();
        info = new JButton();
        history = new JButton();
        err = new JLabel();
        time = new JButton();
        done = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- title ----
            title.setText("\u9500\u552e\u7ba1\u7406");
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(310, 20), title.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u4ea7\u54c1\u540d");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(200, 60), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u4ea7\u54c1\u6570\u91cf");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(200, 100), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u4ea7\u54c1\u4ef7\u683c");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(200, 140), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u65f6\u95f4");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(200, 180), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u8d2d\u4e70\u8005");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(200, 220), label5.getPreferredSize()));

            //---- label6 ----
            label6.setText("\u7535\u8bdd");
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(200, 260), label6.getPreferredSize()));

            //---- label7 ----
            label7.setText("\u5730\u5740");
            panel1.add(label7);
            label7.setBounds(new Rectangle(new Point(200, 300), label7.getPreferredSize()));

            //---- label8 ----
            label8.setText("\u4ed3\u5e93\u4f4d\u7f6e");
            panel1.add(label8);
            label8.setBounds(new Rectangle(new Point(200, 340), label8.getPreferredSize()));
            panel1.add(t1);
            t1.setBounds(300, 55, 180, t1.getPreferredSize().height);
            panel1.add(t2);
            t2.setBounds(300, 95, 180, t2.getPreferredSize().height);
            panel1.add(t3);
            t3.setBounds(300, 135, 180, t3.getPreferredSize().height);
            panel1.add(t4);
            t4.setBounds(300, 175, 180, t4.getPreferredSize().height);
            panel1.add(t5);
            t5.setBounds(300, 215, 180, t5.getPreferredSize().height);
            panel1.add(t6);
            t6.setBounds(300, 255, 180, t6.getPreferredSize().height);
            panel1.add(t7);
            t7.setBounds(300, 295, 180, t7.getPreferredSize().height);
            panel1.add(t8);
            t8.setBounds(300, 335, 180, t8.getPreferredSize().height);

            //---- enter ----
            enter.setText("\u914d\u9001\u8d27\u7269");
            enter.addActionListener(e -> enterActionPerformed(e));
            panel1.add(enter);
            enter.setBounds(new Rectangle(new Point(255, 380), enter.getPreferredSize()));

            //---- info ----
            info.setText("\u663e\u793a\u8ba2\u5355");
            panel1.add(info);
            info.setBounds(new Rectangle(new Point(575, 5), info.getPreferredSize()));

            //---- history ----
            history.setText("\u5386\u53f2\u8ba2\u5355");
            panel1.add(history);
            history.setBounds(new Rectangle(new Point(575, 45), history.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(265, 420, 210, 30);

            //---- time ----
            time.setText("\u5f53\u524d\u65f6\u95f4");
            time.addActionListener(e -> timeActionPerformed(e));
            panel1.add(time);
            time.setBounds(new Rectangle(new Point(490, 175), time.getPreferredSize()));

            //---- done ----
            done.setText("\u6253\u5370\u53d1\u7968");
            done.addActionListener(e -> doneActionPerformed(e));
            panel1.add(done);
            done.setBounds(new Rectangle(new Point(390, 380), done.getPreferredSize()));

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
        panel1.setBounds(0, 0, 675, 455);

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
    private JButton back;
    private JLabel title;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;
    private JButton enter;
    private JButton info;
    private JButton history;
    private JLabel err;
    private JButton time;
    private JButton done;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
