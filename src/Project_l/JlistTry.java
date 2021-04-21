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
//      jText=new JTextField();
//      jText.setText("jfkdlsajfjdsafkdjsakjfldkjsakfjdklsajf");
//      jText.setBounds(600,300,100,100);
//      jText.setAutoscrolls(true);
//      jText.setEditable(false);
        //学习了JTextField的使用方法。
        /*总结，
        JTF只能显示单行，而JTA可以显示多行
        JTS要设置文字可以使用setText，大多数的控件内的文字都是这样的。
        JTS还可以设置只读，用setEditable方法来设置。
        * */
      jp.setLayout(null);
      jf=new JFrame();
      jl=new JList(v);//初始化的时候可以用这个构造方法构建list，初始化list内容
      jscrollpane=new JScrollPane(jl);//想要把东西放到滚动条里面，那么就要将滚动条创建时就放进去，直接add不知道为什么会显示不正常。
      jb=new JButton("init");
      jb.setBounds(10,10,50,20);
      v.add("hello");
      v.add("world");//idea中可以选中代码然后按tab向右缩进，也可以选中之后按shift+tab实现向左缩进。
//      jl.setBounds(100,100,200,200);
      jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      //设置竖直方向上的滚动条一直出现
      jscrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      jscrollpane.setBounds(100,100,500,200);
      //设置水平方向上的滚动条从不出现
      jf.add(jp);
      jf.setSize(900,800);
//      jp.add(jl);
      jp.add(jb);
//      jp.add(jText);
//      jscrollpane.add(jl);
      jp.add(jscrollpane);
      jf.setVisible(true);
      jb.addActionListener(e -> init(e));
//      jf.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置默认关闭操作可以直接在jf对象上设置。
        //有时候不知道为什么在外面设置不生效时可以直接在jf上设置.
//      jl.setListData(v);//可以加上按钮监听，实现刷新list内容的方法。
    }
    public void init(ActionEvent e){
        v.clear();
        v.add("first");
        v.add("second");
        v.add("second");
        v.add("second");
        v.add("second");v.add("second");
        v.add("second");v.add("second");v.add("second");v.add("second");v.add("second");v.add("second");

        jl.setListData(v);
    }
    public static void main(String[] args) {
        JlistTry j=new JlistTry();
//        j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
        j.jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//这样也是等价的，如果直接set没有用的话，
        //可以调用里面的对象来设置。

    }
    public JPanel jp;
    public JFrame jf;
    public JList jl;
//    public JTextField jText;
    public JButton jb;
    public JScrollPane jscrollpane;
}
