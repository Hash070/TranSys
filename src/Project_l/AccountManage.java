/*
 * Created by JFormDesigner on Mon Apr 05 10:03:04 CST 2021
 */

package Project_l;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author a
 */
/*
（5）用户管理：实现用户信息的管理，
例如用户名、密码、邮箱、联系电话、配送地址等，
可以实现用户的查删修改
实现客户的信息管理.
//对客户交易信息可以管理。
*/
public class AccountManage extends JFrame {
    String selectedUser;
    public AccountManage() {
        initComponents();
        initlizeJList();
//        err.setVisible(true);
    }
    private void initlizeJList(){
//        String[] accounts;
//        ArrayList<String> str=new ArrayList<String>();
        Vector<String> v = new Vector<String>();
        PreparedStatement st =null;
        ResultSet rs = null;
        Connection conn =null;
        AcList.setSelectionMode(0);
        try {
             conn =JdbcUtils.getConnection();
             String sql="select * from Account";
             st=conn.prepareStatement(sql);
             rs=st.executeQuery();
             for(int i=0;rs.next();i++){
                 v.add(rs.getString("username"));
             }
             AcList.setListData(v);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,st,rs);
        }
    }
    private void JListValueChanged(ListSelectionEvent e) {//该方法被执行了两次，原因是鼠标按下是一次，鼠标松开是一次。
        //解决方案：使用if语句判断一下。
        // TODO add your code here
        if(AcList.getValueIsAdjusting()){
        Object[] selected=AcList.getSelectedValues();
        System.out.println(selected[0]);
        selectedUser=selected[0].toString();
//        String AcName=selected[0].toString();//setString不兼容的解决方法
//        System.out.println(AcName);
        Connection conn=null;
        PreparedStatement st=null;//这里写null不是冗余的，而是为了避免finally中语法检查出错。
        ResultSet rs=null;
            try {
                conn=JdbcUtils.getConnection();
                String sql="select * from Account where `username`=?";
                st=conn.prepareStatement(sql);
                st.setString(1,selected[0].toString());
                rs = st.executeQuery();
                for(int i=0;rs.next();i++){
                    username.setText(rs.getString("username"));
                    password.setText(rs.getString("password"));
                    email.setText(rs.getString("mail"));
                    tel.setText(rs.getString("tel"));
                    address.setText(rs.getString("address"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                JdbcUtils.release(conn,st,rs);
            }
        }
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection conn=null;
        PreparedStatement st =null;
        String namein,passwordin,emailin,telin,addressin;
//        namein=username.getText();
//        passwordin=password.getText();
//        emailin=email.getText();
//        telin=tel.getText();
//        addressin=address.getText();
        try {
            conn=JdbcUtils.getConnection();
//            String sql="insert into `Tran`.`Account` (`username`,`password`,`mail`,`tel`,`adress`) values (?,?,?,?,?)";
            //插入语句不能用于更新数据库中已有的数据，只能用于新增数据。
            String sql="UPDATE `Tran`.`Account` SET `username` = ?, `password` = ?, `mail` = ?, `tel` = ?, `address` = ? WHERE `username` = ?";
            //变更数据应当使用UPDATE语句。
            st=conn.prepareStatement(sql);
            st.setString(1,username.getText());
            st.setString(2,password.getText());
            st.setString(3,email.getText());
            st.setString(4,tel.getText());
            st.setString(5,address.getText());
            st.setString(6,username.getText());
            st.execute();
            err.setText(username.getText()+"保存成功");
            err.setForeground(Color.BLACK);
        } catch (SQLException throwables) {
            err.setText(username.getText()+"保存失败");
            err.setForeground(Color.red);
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,st,null);
        }
        initlizeJList();
    }

    private void addUserActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection conn=null;
        PreparedStatement st = null;
        Boolean tig=LoginSqlQuery.isEcho(username.getText());
        if (!tig)
        try {
            conn=JdbcUtils.getConnection();
            String sql="INSERT INTO `Tran`.`Account`(`username`, `password`, `mail`, `tel`, `address`) VALUES (?,?,?,?,?)";
            st =conn.prepareStatement(sql);
            st.setString(1,username.getText());
            st.setString(2,password.getText());
            st.setString(3,email.getText());
            st.setString(4,tel.getText());
            st.setString(5,address.getText());
            st.executeUpdate();
            err.setText(username.getText()+"注册成功");
            err.setForeground(Color.black);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        else{
            err.setText(username.getText()+"已被注册");
            err.setForeground(Color.red);
//            err.setVisible(true);
        }
        initlizeJList();
    }

    private void delUserActionPerformed(ActionEvent e) {
        // TODO add your code here//DELETE FROM `Tran`.`Account` WHERE `username` = 'helloa'
//        JOptionPane.showMessageDialog(null,"只能选中一行数据来进行修改");
            Object[] selected=AcList.getSelectedValues();
            System.out.println(selected[0]);
            selectedUser=selected[0].toString();
            Connection conn =null;
            PreparedStatement st =null;
            try {
                conn=JdbcUtils.getConnection();
                String sql="DELETE FROM `Tran`.`Account` WHERE `username` = ?";
                st=conn.prepareStatement(sql);
                st.setString(1,selectedUser);
                st.executeUpdate();
                err.setText(selectedUser+"删除成功");
                err.setForeground(Color.black);
                initlizeJList();
            } catch (SQLException throwables) {
                err.setText(selectedUser+"删除失败");
                err.setForeground(Color.red);
                throwables.printStackTrace();
            }

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        AcList = new JList();
        nameText = new JLabel();
        label2 = new JLabel();
        username = new JTextField();
        password = new JTextField();
        emailText = new JLabel();
        telText = new JLabel();
        email = new JTextField();
        addressText = new JLabel();
        tel = new JTextField();
        address = new JTextField();
        saveButton = new JButton();
        addUser = new JButton();
        delUser = new JButton();
        err = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u7528\u6237\u7ba1\u7406");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
            label1.setBounds(140, 0, 245, 40);

            //======== scrollPane1 ========
            {

                //---- AcList ----
                AcList.addListSelectionListener(e -> JListValueChanged(e));
                scrollPane1.setViewportView(AcList);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(235, 35, 60, 125);

            //---- nameText ----
            nameText.setText("\u7528\u6237\u540d");
            nameText.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(nameText);
            nameText.setBounds(new Rectangle(new Point(145, 210), nameText.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u5bc6\u7801");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(150, 250), label2.getPreferredSize()));
            panel1.add(username);
            username.setBounds(250, 200, 150, 30);
            panel1.add(password);
            password.setBounds(250, 240, 150, 30);

            //---- emailText ----
            emailText.setText("\u90ae\u7bb1");
            panel1.add(emailText);
            emailText.setBounds(new Rectangle(new Point(150, 290), emailText.getPreferredSize()));

            //---- telText ----
            telText.setText("\u7535\u8bdd");
            panel1.add(telText);
            telText.setBounds(new Rectangle(new Point(150, 330), telText.getPreferredSize()));
            panel1.add(email);
            email.setBounds(250, 280, 150, 30);

            //---- addressText ----
            addressText.setText("\u914d\u9001\u5730\u5740");
            panel1.add(addressText);
            addressText.setBounds(new Rectangle(new Point(140, 365), addressText.getPreferredSize()));
            panel1.add(tel);
            tel.setBounds(250, 320, 150, 30);
            panel1.add(address);
            address.setBounds(250, 360, 150, 30);

            //---- saveButton ----
            saveButton.setText("\u4fdd\u5b58");
            saveButton.addActionListener(e -> saveButtonActionPerformed(e));
            panel1.add(saveButton);
            saveButton.setBounds(new Rectangle(new Point(165, 420), saveButton.getPreferredSize()));

            //---- addUser ----
            addUser.setText("\u6dfb\u52a0\u7528\u6237");
            addUser.addActionListener(e -> addUserActionPerformed(e));
            panel1.add(addUser);
            addUser.setBounds(new Rectangle(new Point(280, 420), addUser.getPreferredSize()));

            //---- delUser ----
            delUser.setText("\u5220\u9664\u7528\u6237");
            delUser.addActionListener(e -> delUserActionPerformed(e));
            panel1.add(delUser);
            delUser.setBounds(new Rectangle(new Point(225, 165), delUser.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(195, 460, 135, 35);

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
        panel1.setBounds(0, 0, 525, 530);

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
    private JScrollPane scrollPane1;
    private JList AcList;
    private JLabel nameText;
    private JLabel label2;
    private JTextField username;
    private JTextField password;
    private JLabel emailText;
    private JLabel telText;
    private JTextField email;
    private JLabel addressText;
    private JTextField tel;
    private JTextField address;
    private JButton saveButton;
    private JButton addUser;
    private JButton delUser;
    private JLabel err;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
