package Project_l;

import javax.swing.*;
import java.util.Vector;

public class JlistTry extends JFrame{
    public JlistTry(){
        init();
    }
    public void init(){
      JList jlist;
      Vector<String> v =new Vector<String>();
      jp=new JPanel();
      jf=new JFrame();
      jl=new JList(v);
      jf.add(jp);
      jf.setSize(100,100);
      jp.add(jl);
      jf.setVisible(true);
      v.add("hello");
      v.add("world");
      jl.setListData(v);
    }

    public static void main(String[] args) {
        JlistTry j=new JlistTry();
    }
    public JPanel jp;
    public JFrame jf;
    public JList jl;
}
