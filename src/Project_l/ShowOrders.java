/*
 * Created by JFormDesigner on Tue Apr 27 19:01:36 CST 2021
 */

package Project_l;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * @author a
 */
public class ShowOrders extends JFrame {
    Vector v1;
    public ShowOrders() {
        initComponents();
        initJtable();
        info.getTableHeader().setReorderingAllowed(false);//列不能移动
        info.getTableHeader().setResizingAllowed(false);//不可拉动表格
        info.setEnabled(false);//表格不可更改数据
        info.setSelectionMode(0);
    }
    private void initJtable() {
        String[] column = {"产品名称","产品价格","产品数量","购买者","电话","配送地址"};
        Object[][] rowData = new Object[100][6];
        String[][] temp = new String[100][6];
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM `Tran`.`StoreHouseAndSellingInfo` WHERE `Status` = 1";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            v1 = new Vector();
            Vector v2 = new Vector();
            Vector v3 = new Vector();
            Vector v4 = new Vector();
            Vector v5 = new Vector();
            Vector v6 = new Vector();
            for (int i = 0; rs.next(); i++) {
                v1.add(rs.getString("ProductName"));
                v2.add(rs.getString("ProductPrice"));
                v3.add(rs.getString("ProductQuantity"));
                v4.add(rs.getString("Consumer"));
                v5.add(rs.getString("Tel"));
                v6.add(rs.getString("Address"));
            }
            for (int i = 0; i < v1.size(); i++) {
                temp[i][0] = (String) v1.get(i);
                temp[i][1] = (String) v2.get(i);
                temp[i][2] = (String) v3.get(i);
                temp[i][3] = (String) v4.get(i);
                temp[i][4] = (String) v5.get(i);
                temp[i][5] = (String) v6.get(i);
                rowData = temp;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TableModel dataModel = new DefaultTableModel(rowData, column);
        info.setModel(dataModel);
    }
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        SellManage s=new SellManage();
        s.setVisible(true);
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        scrollPane1 = new JScrollPane();
        info = new JTable();
        back = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- title ----
            title.setText("\u8ba2\u5355\u4fe1\u606f");
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(340, 15), title.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(135, 50, 460, 345);

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(10, 10), back.getPreferredSize()));

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
        panel1.setBounds(0, 0, 730, 445);

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
    private JScrollPane scrollPane1;
    private JTable info;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
