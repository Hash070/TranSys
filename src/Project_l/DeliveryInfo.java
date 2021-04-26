/*
 * Created by JFormDesigner on Sun Apr 25 21:23:56 CST 2021
 */

package Project_l;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;

/**
 * @author a
 */
public class DeliveryInfo extends JFrame {
    private Vector v1;

    public static void main(String[] args) {
        DeliveryInfo d = new DeliveryInfo();
        d.setVisible(true);
        d.setDefaultCloseOperation(3);
    }
    public DeliveryInfo() {
        initComponents();
        initJtable();
//        info.getTableHeader().setReorderingAllowed(false);//列不能移动
        info.getTableHeader().setResizingAllowed(false);//不可拉动表格
//        info.setEnabled(false);//表格不可更改数据
        info.setSelectionMode(0);
    }
    private void initJtable() {
        String[] column = {"车牌号", "驾驶员", "产品名","购买者","当前位置","配送位置"};
        Object[][] rowData = new Object[100][6];
        String[][] temp = new String[100][6];
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT `Cno`,`Driver`,`Pname`,`Consumer`,`NowLoc`,`TarLoc` FROM `Tran`.`Deliver`";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            v1 = new Vector();
            Vector v2 = new Vector();
            Vector v3 = new Vector();
            Vector v4 = new Vector();
            Vector v5 = new Vector();
            Vector v6 = new Vector();
            for (int i = 0; rs.next(); i++) {
                v1.add(rs.getString("Cno"));
                v2.add(rs.getString("Driver"));
                v3.add(rs.getString("Pname"));
                v4.add(rs.getString("Consumer"));
                v5.add(rs.getString("NowLoc"));
                v6.add(rs.getString("TarLoc"));
            }
            for (int i = 0; i < v1.size(); i++) {
                temp[i][0] = (String) v1.get(i);
                temp[i][1] = (String) v2.get(i);
                temp[i][2] = (String) v3.get(i);
                temp[i][3] = (String) v4.get(i);
                temp[i][4] = (String) v5.get(i);
                temp[i][5] = (String) v6.get(i);
                rowData = temp;//麻了。。。。。。
            }
//??storehouse
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TableModel dataModel = new DefaultTableModel(rowData, column);
        info.setModel(dataModel);
    }
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        DeliveryInput m=new DeliveryInput();
        m.setVisible(true);
        m.setDefaultCloseOperation(3);
    }

    private void changeActionPerformed(ActionEvent e) {
        // TODO add your code here
        int i = info.getSelectedRow();
        if(i !=-1){
            err.setText("");
            ;
            System.out.println(v1.get(i));
            Object cno1=v1.get(i);
//            int a= (int) cno;
//            this.setVisible(false);
            int a=-1;
            try
            {
                a =Integer.parseInt(cno1.toString());//Object转换为Integer类一般是不可行的，除非Object里面只有数字。
            }//Integer（整数）类里面有个ParseInt方法，可以将字符串转换为integer
            catch (NumberFormatException e1)
            {
                e1.printStackTrace();
            }
            this.dispose();
            DeliveryInput d=new DeliveryInput();
            d.setVisible(true);
            d.setDefaultCloseOperation(3);
            Connection conn =null;
            PreparedStatement st =null;
            Statement del = null;
            ResultSet rs = null;
            try {
                conn=JdbcUtils.getConnection();
                del=conn.createStatement();
                String sql="select * from `Tran`.`Deliver` where `Cno`=?";
                st=conn.prepareStatement(sql);
                st.setInt(1, a);
                rs = st.executeQuery();
                rs.next();/*又解决一个bug。。。。。。
                这个bug也太nt了，如果我在尝试从rs读取一行数据时，即使只有一行
                也要先执行一下next方法。。。。
                通过仔细观察AccountManage类找到了解决方案。
                */
                d.t1.setText(rs.getString("Cno"));
                d.t2.setText(rs.getString("Driver"));
                d.t3.setText(rs.getString("Pname"));
                d.t4.setText(rs.getString("Consumer"));
                d.t5.setText(rs.getString("Price"));
                d.t6.setText(rs.getString("NowLoc"));
                d.t7.setText(rs.getString("TarLoc"));
                del.execute("DELETE FROM `Tran`.`Deliver` WHERE `Cno` = '"+a+"'");//找到bug了原来是因为我先把这个数据删了，所以下面查的时候就查不到。😂
            } catch (SQLException throwables) {
                err.setText("请选中有数值的行");
                err.setForeground(Color.red);
                throwables.printStackTrace();
            }finally{
                JdbcUtils.release(conn,st,rs);
            }
        }else{
            err.setText("请选中之后再进行操作");
            err.setForeground(Color.red);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        back = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        info = new JTable();
        change = new JButton();
        err = new JLabel();

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
            back.setBounds(new Rectangle(new Point(0, 0), back.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u914d\u9001\u8868");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(305, 15), label1.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(95, 50, 460, 325);

            //---- change ----
            change.setText("\u4fee\u6539");
            change.addActionListener(e -> changeActionPerformed(e));
            panel1.add(change);
            change.setBounds(new Rectangle(new Point(285, 385), change.getPreferredSize()));
            panel1.add(err);
            err.setBounds(380, 390, 210, 20);

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
        panel1.setBounds(0, 0, 650, 425);

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
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable info;
    private JButton change;
    private JLabel err;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
