/*
 * Created by JFormDesigner on Sun Apr 25 16:47:21 CST 2021
 */

package Project_l;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author a
 */
public class PurchaseInfo extends JFrame {
    public PurchaseInfo() {
        initComponents();
        initJtable();
    }

    public static void main(String[] args) {
        new PurchaseInfo().setVisible(true);
    }
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        new PurchaseApply().setVisible(true);
    }
    private void initJtable(){
        String[] column={"产品名称","产品价格","产品数量"};
        Object[][] rowData=new Object[100][3];
//
        Connection conn =null;
        PreparedStatement st =null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
            String sql="SELECT `Pname`,`Pprice`,`Pnum` FROM `Tran`.`Purchase`";
            st=conn.prepareStatement(sql);
            rs = st.executeQuery();
            String[] v1=new String[100];
            String[] v2=new String[100];
            String[] v3=new String[100];
            for(int i=0;rs.next();i++){
                v1[0]=rs.getString("Pname");
                v2[0]=rs.getString("Pprice");
                v3[0]=rs.getString("Pnum");
            }
            for(int i=0;i<v1.length;i++){
                for(int j = 0;j<3;j++){
                    rowData[i][j]=v1[j];
                    rowData[i][j]=v2[j];
                    rowData[i][j]=v3[j];
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TableModel dataModel = new DefaultTableModel(rowData,column);
        info.setModel(dataModel);
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
            title.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(275, 15), title.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(110, 45, 380, 235);

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(10, 5), back.getPreferredSize()));

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
    private JLabel title;
    private JScrollPane scrollPane1;
    private JTable info;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
