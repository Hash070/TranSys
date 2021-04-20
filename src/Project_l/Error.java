/*
 * Created by JFormDesigner on Sun Apr 04 08:55:25 CST 2021
 */

package Project_l;

import javax.swing.*;
import java.awt.*;

/**
 * @author a
 */
public class Error extends JFrame {
    public Error() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        error_name = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- error_name ----
        error_name.setText("null");
        error_name.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(error_name);
        error_name.setBounds(0, 0, 200, 95);

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
    public JLabel error_name;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
