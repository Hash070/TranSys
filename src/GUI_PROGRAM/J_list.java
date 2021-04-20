package GUI_PROGRAM;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
public class J_list {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(600,500);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp=new JPanel();
        JScrollPane jsp=new JScrollPane();
        jsp.setPreferredSize(new Dimension(200,100));
        String[] str={"aa","bb","cc","77","blizzard","safafads","dsafdsa","test11111","nbplus"};//sql查询过来一个字符串，然后列入表格
        JList jl=new JList(str);
        jl.addListSelectionListener(new ListSelectionListener() {//监听表格内容选择
            @Override
            public void valueChanged(ListSelectionEvent e) {//表格选择的值改变
                if(!jl.getValueIsAdjusting()){//可以判断选择的东西是否改变
                    System.out.println(jl.getSelectedValue());//getselectedvalue可以得到当前选择的值
                    //将表格选择的值进行sql查询
                    //返回内容
                    //更新按钮
                }
            }
        });
        jsp.setViewportView(jl);
        jp.add(jsp);
        jf.getContentPane().add(jp);
        jf.setVisible(true);
    }
}
