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
      add =new JButton("添加");
      del=new JButton("删除");
      change=new JButton("修改");
      sAll=new JButton("全选");
      nsAll=new JButton("全不选");
      reverseSelectButton =new JButton("反选");
      add.setBounds(10,40,50,20);
      del.setBounds(10,70,50,20);
      change.setBounds(10,100,50,20);
      sAll.setBounds(10,130,50,20);
      nsAll.setBounds(10,160,50,20);
      reverseSelectButton.setBounds(10,190,50,20);
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
//    jl.setBounds(100,100,200,200);
      jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      //设置竖直方向上的滚动条一直出现
      jscrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      jscrollpane.setBounds(100,100,500,200);
      //设置水平方向上的滚动条从不出现
      jf.add(jp);
      jf.setSize(900,800);
//      jp.add(jl);
      jp.add(jb);
      jp.add(add);
      jp.add(del);
      jp.add(change);
      jp.add(sAll);
      jp.add(nsAll);
      jp.add(reverseSelectButton);
//      jp.add(jText);
//      jscrollpane.add(jl);
      jp.add(jscrollpane);
      jf.setVisible(true);
      jb.addActionListener(e -> init(e));
      add.addActionListener(e -> addThings(e));
      del.addActionListener(e-> delThings(e));
      change.addActionListener(e ->changeThings(e));
      sAll.addActionListener(e ->sAll(e));
      nsAll.addActionListener(e ->nsAll(e));
      reverseSelectButton.addActionListener(e ->reverseSelectButton(e));
//      jf.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置默认关闭操作可以直接在jf对象上设置。
        //有时候不知道为什么在外面设置不生效时可以直接在jf上设置.
//      jl.setListData(v);//可以加上按钮监听，实现刷新list内容的方法。
    }
    public void addThings(ActionEvent e)
    {
        String inputStr=JOptionPane.showInputDialog("请输入要添加的内容");
        //这个JOptionPane好像挺有意思的，还能这么玩。
        v.add(inputStr);
        jl.setListData(v);
    }
    public void delThings(ActionEvent e){
        if(jl.getSelectedValues().length>0){
            Object[] objArr=jl.getSelectedValues();
            for(int i = 0; objArr.length>i;i++){
                v.remove(objArr[i]);
            }
            jl.setListData(v);
        }else JOptionPane.showMessageDialog(null,"没有选中内容");
    }
    public void changeThings(ActionEvent e){
        if(jl.getSelectedValues().length==1){
            int indexS=jl.getSelectedIndex();
            Object[] objArr=jl.getSelectedValues();//这里必须使用数组吗？？
            //这里只能使用对象数组来进行接收，不然会出现问题。
            String inputStr = JOptionPane.showInputDialog("请输入要修改的内容",objArr[0]);
            v.remove(objArr[0]);
            v.add(indexS,inputStr);
            jl.setListData(v);
        }else{
            JOptionPane.showMessageDialog(null,"只能选中一行数据来进行修改");
        }
    }
    public void init(ActionEvent e){
        v.clear();
        v.add("first");
        v.add("secaaaond");
        v.add("secaaaond");
        v.add("secoaaaaaand");
        v.add("secoaaaaaand");v.add("second");
        v.add("second");v.add("second");v.add("second");v.add("second");v.add("second");v.add("second");
        jl.setListData(v);
    }
    public void sAll(ActionEvent e){
        jl.setSelectionMode(2);
        int[] select=new int[v.size()];
        for(int i=0;i<v.size();i++){
            select[i]=i;
        }
        jl.setSelectedIndices(select);
    }
    public void nsAll(ActionEvent e){
        jl.setSelectionMode(2);
        int[] s=new int[v.size()];
        for(int i=0;i<s.length;i++){
            s[i]=-1;
        }
        jl.setSelectedIndices(s);
    }
    public void reverseSelectButton(ActionEvent e){
        int[] all=new int[v.size()];
        for(int i=0;i<all.length;i++){
            all[i] = i;
        }//创建全选数组
        int[] sel=jl.getSelectedIndices();//获得已选择的数组
        for(int i=0;i<sel.length;i++){//根据已选择的数组的下标来反选全选数组即可
            int temp=sel[i];
            for (int j=0;j<all.length;j++){//细心。。。这里写错了导致bug
                if(temp==all[j]){
                    all[j]=-1;
                }
            }
        }//最后别忘记了set。。。
        jl.setSelectedIndices(all);
    }
    public static void main(String[] args) {
        JlistTry j=new JlistTry();
//      j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
        j.jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//这样也是等价的，如果直接set没有用的话，
        //可以调用里面的对象来设置。
    }
    public JPanel jp;
    public JFrame jf;
    public JList jl;
//  public JTextField jText;
    public JButton jb;
    public JButton add;
    public JButton del;
    public JButton change;
    public JButton sAll;
    public JButton nsAll;
    public JButton reverseSelectButton;
    public JScrollPane jscrollpane;
}
