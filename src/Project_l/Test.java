/*
 * Created by JFormDesigner on Sun Mar 28 09:55:27 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author a
 */
public class Test extends JFrame {
    public Test()
    {
        initComponents();
        loginBtn.setBorderPainted(false);
        loginBtn.setContentAreaFilled(false);
    }
    private void loginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        loginBtn = new JButton();
        button2 = new JButton();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/Pictures/john-lee-oMneOBYhJxY-unsplash.jpg")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);
            //---- loginBtn ----
            loginBtn.setIcon(new ImageIcon(getClass().getResource("/Pictures/\u786e\u5b9a.png")));
            loginBtn.addActionListener(e -> loginBtnActionPerformed(e));
            panel1.add(loginBtn);
            loginBtn.setBounds(105, 215, 50, 50);
            //---- button2 ----
            button2.setText("text");
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(245, 210), button2.getPreferredSize()));
            {// compute preferred size
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
        panel1.setBounds(0, 0, 445, 305);

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
    private JButton loginBtn;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
