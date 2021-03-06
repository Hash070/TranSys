package Project_l;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class JlistDemo3 {
    private static Vector<String> v = new Vector<String>();// 可实现自动增长对象数组
    private JFrame frame = new JFrame("JList例子");
    private Container cont = frame.getContentPane();
    private static JList jlist = null;
    private JPanel buttonJPanel = new JPanel(new FlowLayout());// new
    // BorderLayout()
    private JButton allSelectButton = new JButton("全选");
    private JButton noSelectButton = new JButton("全不选");
    private JButton reverseSelectButton = new JButton("反选");
    private JButton modifyButton = new JButton("修改");
    private JButton syncButton = new JButton("同步到文件");
    private JButton deleteButton = new JButton("删除");
    private JButton addButton = new JButton("添加");
    private JButton reNewButton = new JButton("初始化数据");
    public static void main(String[] args) {
        JlistDemo3 demo3 = new JlistDemo3();
        // 初始化数据按钮
        demo3.reNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.clear();
                v.add("hi");
                v.add("you");
                v.add("who");
                v.add("are");
                jlist.setListData(v);
            }
        });
        // 删除按钮事件
        demo3.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 如果vectorList有选中的，则通过vector删除，并重新显示到vectorList,否则提示未选中；
                if (jlist.getSelectedValues().length > 0) {
                    //jlist的
                    Object[] objArr = jlist.getSelectedValues();//这里划一条线的意思是类已经弃用类，不建议使用但是可以用。
                    System.out.println(jlist.getSelectedValues());
                    for (int i = 0; i < objArr.length; i++) {
                        v.remove(objArr[i]);
                        System.out.println(objArr[i]);
                    }
                    jlist.setListData(v);
                    // vectorList = null;
                    // vectorList = new JList(v);
                } else {
                    JOptionPane.showMessageDialog(null, "请至少选中一列");
                }
            }
        });
        // 添加按钮事件
        demo3.addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String addStr = JOptionPane.showInputDialog("请输入添加的数据！");
                v.add(addStr);
                jlist.setListData(v);
            }
        });
        // 添加修改按钮事件，双击JList列表时也会弹出修改框
        demo3.modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 如果没有选中一列或者选中多列都提示让其只能选择一列
                Object[] objArr = jlist.getSelectedValues();
                if (objArr.length < 0 || objArr.length > 1) {
                    JOptionPane.showMessageDialog(null, "只能选择一列");
                    return;
                } else {
                    v.remove(objArr[0]);
                    String modifyStr = JOptionPane.showInputDialog("请修改值",
                            objArr[0]);//这个放在这里的意义是让输入窗口的JTextField有初始值.
                    v.add(modifyStr);
                    jlist.setListData(v);
                }
            }
        });

        // 增加全选按钮事件，点击全选时，JLIst列表全部选中
        demo3.allSelectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                int[] allSelect = new int[v.size()];//获取JList的行数//即获取Vector对象所存储字符串的数目。
                //获得Vector对象中的行数之后再创建一个这么长的整形数组
                for (int i = 0; i < v.size(); i++) {
                    allSelect[i] = i;//初始化这个数组，使这个数组中的元素包含所有想要选中的下标
                }
                jlist.setSelectedIndices(allSelect);//将一个存储着待选中行号整型数组当作参数放到JList中的setSelectedIndices方法中去,即可实现选中功能
            }
        });

        // 增加全部选按钮时间，点击全不选时，JList都不选中；
        demo3.noSelectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int[] noSelectArr = new int[v.size()];//长度必须一一对应。
                for (int i = 0; i < noSelectArr.length; i++) {
                    noSelectArr[i] = -1;//设置全部不选时，数组中所有的值必须赋值为-1，不然默认为0，则会导致第一行被选中。
                }
                jlist.setSelectedIndices(noSelectArr);
            }
        });

        // 反选按钮
        demo3.reverseSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int[] allArr = new int[v.size()];//先创建一个全选的数组
                for (int i = 0; i < allArr.length; i++) {
                    allArr[i] = i;
                }
                int[] selectArr = jlist.getSelectedIndices();//然后再创建一个已选择的数组
                for (int i = 0; i < selectArr.length; i++) {
                    int value = selectArr[i];
                    for (int j = 0;j < allArr.length; j++) {//将已选择的东西设置为不选则就行
                        if (value == allArr[j]) {//逻辑就是如果这个被选中了，那么将全选的东西，勾掉就行。
                            allArr[j] = -1;
                        }
                    }
                }
                jlist.setSelectedIndices(allArr);

            }
        });

        demo3.initUI();
    }

    private void initUI() {

        this.frame.setLayout(new GridLayout(1, 2));

        // 初始化按钮
        buttonJPanel.add(allSelectButton);
        buttonJPanel.add(noSelectButton);
        buttonJPanel.add(reverseSelectButton);
        buttonJPanel.add(modifyButton);
        buttonJPanel.add(syncButton);
        buttonJPanel.add(deleteButton);
        buttonJPanel.add(addButton);
        buttonJPanel.add(reNewButton);

        // 初始化JList
        v.add("hi");
        v.add("you");
        v.add("who");
        v.add("are");
        // v.add("hello");
        // v.add("world");
        // v.add("good");
        // v.add("night");
        jlist = new JList(v);
        jlist.setBorder(BorderFactory.createTitledBorder("JList列表"));

        this.cont.add(buttonJPanel);
        this.cont.add(new JScrollPane(jlist));

        this.frame.setSize(400, 200);
        this.frame.setLocation(new Point(500, 200));
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}