package GUI_PROGRAM;

import javax.swing.*;

public class SwE1 extends JFrame{
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        SwE1 a=new SwE1();
        a.test();
    }
    private void test(){
        panel2 = new JFrame();
        panel2.setVisible(true);
        panel2.setBounds(100,100,500,500);
        panel2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        bu=new JButton("hello");
        panel2.add(bu);
        panel2.remove(bu);
    }
    private JFrame panel2;
    private JButton bu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

