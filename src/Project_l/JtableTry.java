package Project_l;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JtableTry extends JFrame {

    public JtableTry(){
        String[] column={"aaa","bbb","ccc"};
        Object[][] list={{"aaaa","dsafd","dafdsaf"},{"adfas","dsafdsafd","fdsafdasf"}};
        jf=new JFrame();
        jf.setBounds(10,10,500,500);
        jp=new JPanel();
        jp.setLayout(null);
        jf.add(jp);
        jt=new JTable(list,column);
        jsp=new JScrollPane(jt);
        jtf0=new JTextField();
        jtf1=new JTextField();
        jtf2=new JTextField();
        jb=new JButton("add");
        jtf0.setBounds(0,300,180,40);
        jtf1.setBounds(0,340,180,40);
        jtf2.setBounds(0,380,180,40);
        jp.add(jtf0);
        jp.add(jtf1);
        jp.add(jtf2);
        jp.add(jb);
        jb.addActionListener(e -> addF(e));
        jsp.setBounds(0,0,300,300);
        jp.add(jsp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jt.setSelectionMode(0);
    }
    public void addF(ActionEvent e){
        Object[] insert ={jtf0.getText(),jtf1.getText(),jtf2.getText()};
        ;
    }
    public static void main(String[] args) {
        new JtableTry();
    }
    public JFrame jf;
    public JPanel jp;
    public JTable jt;
    public JScrollPane jsp;
    public JTextField jtf0;
    public JTextField jtf1;
    public JTextField jtf2;
    public JButton jb;
}
