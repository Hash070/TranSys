/*
 * Created by JFormDesigner on Thu Mar 25 08:51:20 CST 2021
 */

package GUI_PROGRAM;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author a
 */
public class AAA extends JFrame {
    public AAA() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1, "cell 2 5");
        contentPane.add(textField1, "cell 4 5");

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2, "cell 2 6");
        contentPane.add(textField2, "cell 4 6");

        //---- button1 ----
        button1.setText("text");
        contentPane.add(button1, "cell 4 11");

        //---- button2 ----
        button2.setText("text");
        contentPane.add(button2, "cell 6 11");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa.setVisible(true);
    }
}
