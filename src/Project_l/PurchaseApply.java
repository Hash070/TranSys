/*
 * Created by JFormDesigner on Sun Apr 25 15:52:29 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author a
 */
public class PurchaseApply extends JFrame {
    public PurchaseApply() {
        initComponents();
    }

    public static void main(String[] args) {
        new PurchaseApply().setVisible(true);
    }
    private void enterActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection conn =null;
        PreparedStatement st =null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="INSERT INTO Tran.Purchase (Pname, Pnum, Pprice, Consumer, time, Address)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            st = conn.prepareStatement(sql);
            st.setString(1,name.getText());
            st.setString(2,num.getText());
            st.setString(3,price.getText());
            st.setString(4,con.getText());
            st.setString(5,buytime.getText());
            st.setString(6,address.getText());
            st.execute();
            errinfo.setText("保存成功");
            errinfo.setForeground(Color.black);
        } catch (SQLException throwables) {
            errinfo.setText("输入的数据有误，保存失败");
            errinfo.setForeground(Color.red);
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,st,null);
        }
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        mainMenu menu = new mainMenu();
        menu.setVisible(true);
    }

    private void showActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        new PurchaseInfo().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        name = new JTextField();
        num = new JTextField();
        price = new JTextField();
        con = new JTextField();
        buytime = new JTextField();
        address = new JTextField();
        pname = new JLabel();
        pnum = new JLabel();
        pprice = new JLabel();
        consumer = new JLabel();
        time = new JLabel();
        the_address = new JLabel();
        enter = new JButton();
        back = new JButton();
        show = new JButton();
        errinfo = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- title ----
            title.setText("\u91c7\u8d2d\u7533\u8bf7");
            title.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(260, 15), title.getPreferredSize()));
            panel1.add(name);
            name.setBounds(255, 65, 150, 30);
            panel1.add(num);
            num.setBounds(255, 105, 150, 30);
            panel1.add(price);
            price.setBounds(255, 145, 150, 30);
            panel1.add(con);
            con.setBounds(255, 190, 150, 30);
            panel1.add(buytime);
            buytime.setBounds(255, 235, 150, 30);
            panel1.add(address);
            address.setBounds(255, 280, 150, 30);

            //---- pname ----
            pname.setText("\u4ea7\u54c1\u540d");
            panel1.add(pname);
            pname.setBounds(new Rectangle(new Point(180, 70), pname.getPreferredSize()));

            //---- pnum ----
            pnum.setText("\u4ea7\u54c1\u6570\u91cf");
            panel1.add(pnum);
            pnum.setBounds(175, 115, pnum.getPreferredSize().width, 15);

            //---- pprice ----
            pprice.setText("\u4ea7\u54c1\u4ef7\u683c");
            panel1.add(pprice);
            pprice.setBounds(new Rectangle(new Point(175, 155), pprice.getPreferredSize()));

            //---- consumer ----
            consumer.setText("\u8d2d\u4e70\u4eba");
            panel1.add(consumer);
            consumer.setBounds(new Rectangle(new Point(180, 195), consumer.getPreferredSize()));

            //---- time ----
            time.setText("\u8d2d\u4e70\u65f6\u95f4");
            panel1.add(time);
            time.setBounds(new Rectangle(new Point(175, 240), time.getPreferredSize()));

            //---- the_address ----
            the_address.setText("\u8d2d\u4e70\u4f4d\u7f6e");
            panel1.add(the_address);
            the_address.setBounds(new Rectangle(new Point(175, 285), the_address.getPreferredSize()));

            //---- enter ----
            enter.setText("\u63d0\u4ea4");
            enter.addActionListener(e -> enterActionPerformed(e));
            panel1.add(enter);
            enter.setBounds(new Rectangle(new Point(260, 325), enter.getPreferredSize()));

            //---- back ----
            back.setText("back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- show ----
            show.setText("\u663e\u793a\u8ba2\u5355");
            show.addActionListener(e -> showActionPerformed(e));
            panel1.add(show);
            show.setBounds(new Rectangle(new Point(480, 5), show.getPreferredSize()));

            //---- errinfo ----
            errinfo.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(errinfo);
            errinfo.setBounds(205, 360, 195, 30);

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
        panel1.setBounds(0, 0, 575, 405);

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
    private JTextField name;
    private JTextField num;
    private JTextField price;
    private JTextField con;
    private JTextField buytime;
    private JTextField address;
    private JLabel pname;
    private JLabel pnum;
    private JLabel pprice;
    private JLabel consumer;
    private JLabel time;
    private JLabel the_address;
    private JButton enter;
    private JButton back;
    private JButton show;
    private JLabel errinfo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
