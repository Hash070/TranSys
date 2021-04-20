package JDBC_Program;

//import com.mysql.jdbc.Connection;
import java.sql.*;

public class My_First_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //load driver
        Class.forName("com.mysql.jdbc.Driver");
        //set login info
        String url="jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=true";//连接哪个数据库
        String password="123456";
        String username="root";
        Connection connection =DriverManager.getConnection(url,username,password);
        //Connection 类可以执行数据库级别的事务，例如备份回滚等
        //run sql
        Statement statement=connection.createStatement();
        //执行sql的对象
        /*excuteQuery()//查询操作，返回result
        excute()//执行任何sql
        excuteUpdate()//执行增删改；返回受影响的行数
        * */
//        ResultSet in=statement.executeQuery("use sys");
        String sql="SELECT *FROM sys_config";
        ResultSet rs = statement.executeQuery(sql);
        //result有多个实用方法
        //beforeFirst移动到最前面
        //afterLast移动到最后面
        while(rs.next())
        {
         System.out.println("value="+rs.getObject("value"));
         System.out.println("set_time="+rs.getObject("set_time"));
        }
        rs.close();//接收结果的对象关闭
        statement.close();//执行sql的对象关闭
        connection.close();
    }
}
