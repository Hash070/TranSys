/*
 * Created by JFormDesigner on Sun Mar 28 11:30:15 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author a
 */
public class mainMenu extends JFrame {
    public mainMenu() {
        initComponents();
        button6.setBorderPainted(false);
        button6.setContentAreaFilled(false);
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Login login =new Login();
        login.setVisible(true);
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void buyActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void manageActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        AccountManage ac =new AccountManage();
        ac.setVisible(true);
        ac.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        buy = new JButton();
        sell = new JButton();
        storage = new JButton();
        transport = new JButton();
        manage = new JButton();
        button6 = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- buy ----
            buy.setText("\u91c7\u8d2d\u7ba1\u7406");
            buy.addActionListener(e -> buyActionPerformed(e));
            panel1.add(buy);
            buy.setBounds(new Rectangle(new Point(95, 80), buy.getPreferredSize()));

            //---- sell ----
            sell.setText("\u9500\u552e\u7ba1\u7406");
            panel1.add(sell);
            sell.setBounds(new Rectangle(new Point(95, 125), sell.getPreferredSize()));

            //---- storage ----
            storage.setText("\u4ed3\u5e93\u7ba1\u7406");
            panel1.add(storage);
            storage.setBounds(new Rectangle(new Point(95, 170), storage.getPreferredSize()));

            //---- transport ----
            transport.setText("\u914d\u9001\u7ba1\u7406");
            panel1.add(transport);
            transport.setBounds(new Rectangle(new Point(95, 215), transport.getPreferredSize()));

            //---- manage ----
            manage.setText("\u7528\u6237\u7ba1\u7406");
            manage.addActionListener(e -> manageActionPerformed(e));
            panel1.add(manage);
            manage.setBounds(new Rectangle(new Point(95, 260), manage.getPreferredSize()));

            //---- button6 ----
            button6.setIcon(new ImageIcon(getClass().getResource("/Pictures/\u767b\u51fa.png")));
            button6.addActionListener(e -> button6ActionPerformed(e));
            panel1.add(button6);
            button6.setBounds(110, 370, 55, 55);

            //---- label1 ----
            label1.setText("\u767b\u51fa");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(120, 430), label1.getPreferredSize()));

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
        panel1.setBounds(0, 0, 275, 505);

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
    private JButton buy;
    private JButton sell;
    private JButton storage;
    private JButton transport;
    private JButton manage;
    private JButton button6;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
