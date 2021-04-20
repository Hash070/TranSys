package GUI_PROGRAM;

import javax.swing.*;

public class Ic0n extends JFrame {
    public Ic0n(){
        JLabel jl=new JLabel("this is a lable");
    JPanel jp=new JPanel();
    jp.setLayout(null);
    JFrame jf=new JFrame();
    jf.setLayout(null);
    jf.add(jp);
    jf.setBounds(100,100,100,100);
    jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jf.setVisible(true);
    jl.setBounds(100,100,100,100);
    jp.add(jl);
//    URL url=Ic0n.class.getResource("yes.png");
//    Icon icon=new ImageIcon(url);
    jl.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
//    jl.setIcon(icon);//设置标签
//    jl.setOpaque(true);//不透明
}

    public static void main(String[] args) {
        new Ic0n();
    }
}
