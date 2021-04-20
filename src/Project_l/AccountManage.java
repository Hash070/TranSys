/*
 * Created by JFormDesigner on Mon Apr 05 10:03:04 CST 2021
 */

package Project_l;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author a
 */
public class AccountManage extends JFrame {
    public AccountManage() {
        initComponents();
    }

    private void JListValueChanged(ListSelectionEvent e) {
        // TODO add your code here

    }

    private void refresh(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        refresh = new JButton();

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
            label1.setBounds(315, 0, 245, 40);

            //======== scrollPane1 ========
            {

                //---- list1 ----
                list1.addListSelectionListener(e -> JListValueChanged(e));
                scrollPane1.setViewportView(list1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(210, 40, 450, 145);

            //---- refresh ----
            refresh.setText("\u5237\u65b0");
            refresh.addActionListener(e -> refresh(e));
            panel1.add(refresh);
            refresh.setBounds(new Rectangle(new Point(585, 190), refresh.getPreferredSize()));

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
        panel1.setBounds(0, 0, 880, 530);

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
    private JList list1;
    private JButton refresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
