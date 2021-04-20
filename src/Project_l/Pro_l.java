/*
 * Created by JFormDesigner on Sat Mar 27 14:59:59 CST 2021
 */
package Project_l;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Pro_l extends JFrame {
    public Pro_l() {
        initComponents();
    }
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println(textField1.getText());
        System.out.println(passwordField1.getPassword());
    }

    private void frame1WindowClosed(WindowEvent e) {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new Frame();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        passwordField1 = new JPasswordField();

        //======== frame1 ========
        {
            frame1.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    frame1WindowClosed(e);
                }
            });
            frame1.setLayout(null);

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //---- label1 ----
                label1.setText("\u7269\u6d41\u7ba1\u7406\u7cfb\u7edf");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 16));
                panel1.add(label1);
                label1.setBounds(220, 40, 160, 35);
                panel1.add(textField1);
                textField1.setBounds(225, 135, 160, 30);

                //---- label2 ----
                label2.setText("\u7528\u6237\u540d");
                panel1.add(label2);
                label2.setBounds(135, 135, label2.getPreferredSize().width, 30);

                //---- label3 ----
                label3.setText("\u5bc6\u7801");
                panel1.add(label3);
                label3.setBounds(135, 180, label3.getPreferredSize().width, 30);

                //---- button1 ----
                button1.setText("\u767b\u9646");
                button1.addActionListener(e -> button1ActionPerformed(e));
                panel1.add(button1);
                button1.setBounds(new Rectangle(new Point(200, 265), button1.getPreferredSize()));

                //---- button2 ----
                button2.setText("\u6ce8\u518c");
                panel1.add(button2);
                button2.setBounds(new Rectangle(new Point(325, 265), button2.getPreferredSize()));
                panel1.add(passwordField1);
                passwordField1.setBounds(225, 180, 160, 30);

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
            frame1.add(panel1);
            panel1.setBounds(0, 0, 600, 375);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < frame1.getComponentCount(); i++) {
                    Rectangle bounds = frame1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = frame1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                frame1.setMinimumSize(preferredSize);
                frame1.setPreferredSize(preferredSize);
            }
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private Frame frame1;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
