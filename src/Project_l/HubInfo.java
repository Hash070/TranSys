/*
 * Created by JFormDesigner on Tue Apr 27 21:01:15 CST 2021
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
public class HubInfo extends JFrame {
    public HubInfo() {
        initComponents();
        initJtable();
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Hub a=new Hub();
        a.setVisible(true);
        a.setDefaultCloseOperation(3);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        back = new JButton();
        scrollPane1 = new JScrollPane();
        info = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u4ed3\u5e93\u5360\u7528\u60c5\u51b5");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(295, 10), label1.getPreferredSize()));

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(110, 40, 450, 295);

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
        panel1.setBounds(0, 0, 670, 385);

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
    private void initJtable() {
        String[] column = {"仓库名称","占用情况"};
        Object[][] rowData = new Object[100][2];
        String[][] temp = new String[100][2];
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String echo="";
        ResultSet rs1=null;
        try {
            Vector v1=new Vector();
            Vector v2=new Vector();//bug原因，Vector忘记创建😂
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM `Tran`.`StoreHouseAndSellingInfo` WHERE `Status` = 1";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            int s=0;
            for (int i = 0; rs.next(); i++) {
                if(echo.equals(rs.getString("ProductLoc")))
                {
                    rs1=rs;
                    for (int j = 0; rs1.next(); j++) {
                        if(echo.equals(rs.getString("ProductLoc")))
                            s++;
                        else
                            break;
                    }
                System.out.println(rs.getString("ProductLoc"));
                v1.add(rs.getString("ProductLoc"));
                v2.add(Integer.toString(s));
                }
                else
                echo=rs.getString("ProductLoc");
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JButton back;
    private JScrollPane scrollPane1;
    private JTable info;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
