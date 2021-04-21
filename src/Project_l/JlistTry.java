package Project_l;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class JlistTry extends JFrame{
    Vector<String> v =new Vector<String>();
    public JlistTry(){
        init();
    }
    public void init(){
      JList jlist;
      jp=new JPanel();
      jf=new JFrame();
      jb=new JButton("init");
      jb.setBounds(10,10,10,10);
      v.add("hello");
      v.add("world");//idea中可以选中代码然后按tab向右缩进，也可以选中之后按shift+tab实现向左缩进。
      jl=new JList(v);//初始化的时候可以用这个构造方法构建list，初始化list内容
      jf.add(jp);
      jf.setSize(100,100);
      jp.add(jl);
      jp.add(jb);
      jf.setVisible(true);
      jb.addActionListener(e -> init(e));

//      jl.setListData(v);//可以加上按钮监听，实现刷新list内容的方法。
    }
    public void init(ActionEvent e){
        v.clear();
        v.add("first");
        v.add("second");
        jl.setListData(v);
    }
    public static void main(String[] args) {
        JlistTry j=new JlistTry();
    }
    public JPanel jp;
    public JFrame jf;
    public JList jl;
    public JButton jb;
}
