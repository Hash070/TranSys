/*
 * Created by JFormDesigner on Tue Apr 27 20:32:56 CST 2021
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
public class Hub extends JFrame {
    public Hub() {
        initComponents();
        initJtable();
    }
    private void initJtable() {
        String[] column = {"产品名称","仓库位置"};
        Object[][] rowData = new Object[100][2];
        String[][] temp = new String[100][2];
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String echo="";
        try {
            Vector v1=new Vector();
            Vector v2=new Vector();//bug原因，Vector忘记创建😂
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM `Tran`.`StoreHouseAndSellingInfo` WHERE `Status` = 1";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            for (int i = 0; rs.next(); i++) {
//                if(!echo.equals(rs.getString("ProductName")))
//                {
//                    System.out.println(rs.getString("ProductName"));
                    v1.add(rs.getString("ProductName"));
                    v2.add(rs.getString("ProductLoc"));
//                }
//                echo=rs.getString("ProductLoc");
            }
            for (int i = 0; i < v1.size(); i++) {
                temp[i][0] = (String) v1.get(i);
                temp[i][1] = (String) v2.get(i);
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
        mainMenu menu = new mainMenu();
        menu.setVisible(true);
        menu.setDefaultCloseOperation(3);
    }

    private void moreActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        HubInfo a=new HubInfo();
        a.setVisible(true);
        a.setDefaultCloseOperation(3);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        back = new JButton();
        title = new JLabel();
        scrollPane1 = new JScrollPane();
        info = new JTable();
        more = new JButton();

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
            title.setText("\u4ed3\u5e93\u4fe1\u606f");
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(270, 15), title.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(70, 40, 455, 275);

            //---- more ----
            more.setText("\u4ed3\u5e93\u5360\u7528\u60c5\u51b5");
            more.addActionListener(e -> moreActionPerformed(e));
            panel1.add(more);
            more.setBounds(new Rectangle(new Point(480, 5), more.getPreferredSize()));

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
        panel1.setBounds(0, 0, 600, 375);

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
    private JScrollPane scrollPane1;
    private JTable info;
    private JButton more;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
