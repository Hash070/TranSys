package Project_l;

import javax.swing.*;
import java.util.Vector;

public class JtableTest1 extends JFrame {

    //rowData用来存放行数据
    //columnNames存放列名
    Vector rowData, columnNames;
    JTable jt = null;
    JScrollPane jsp = null;

    public static void main(String[] args) {

        JtableTest1 jtableTest1 = new JtableTest1();

    }

    //构造函数
    public JtableTest1() {

        columnNames = new Vector();
        //设置列名
        columnNames.add("学号");
        columnNames.add("名字");
        columnNames.add("性别");
        columnNames.add("年龄");
        columnNames.add("籍贯");
        columnNames.add("系别");

        rowData = new Vector();
        //rowData行数据，可以存放多行
        Vector hang = new Vector();
        hang.add("1");
        hang.add("linweieran");
        hang.add("男");
        hang.add("25");
        hang.add("spy");
        hang.add("自创");

        //加入到rowData
        rowData.add(hang);

        //初始化Jtable
        jt = new JTable(rowData, columnNames);

        //初始化 jsp
        jsp = new JScrollPane(jt);

        //把jsp放入到jframe
        this.add(jsp);

        this.setSize(400, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
