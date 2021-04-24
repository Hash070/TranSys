package Project_l;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class JtableTest2 extends JFrame {

    //从数据库中取出信息
    //rowData用来存放行数据
    //columnNames存放列名
    Vector rowData, columnNames;
    JTable jt = null;
    JScrollPane jsp = null;

    //定义数据库需要的全局变量
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;


    public static void main(String[] args) {

        JtableTest2 jtableTest2 = new JtableTest2();

    }

    //构造函数
    public JtableTest2() {

        columnNames = new Vector();
        //设置列名
        columnNames.add("学号");
        columnNames.add("名字");
        columnNames.add("性别");
        columnNames.add("年龄");
        columnNames.add("籍贯");
        columnNames.add("系别");

        rowData = new Vector();
        //rowData可以存放多行,开始从数据库里取

        try {
            //加载驱动
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            //得到连接
            ct = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=spdb1", "sa", "sa");

            ps = ct.prepareStatement("select * from stu");

            rs = ps.executeQuery();

            while (rs.next()) {
                //rowData可以存放多行
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getInt(4));
                hang.add(rs.getString(5));
                hang.add(rs.getString(6));

                //加入到rowData
                rowData.add(hang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ct != null) {
                    ct.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


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