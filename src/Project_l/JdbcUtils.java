package Project_l;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;
    static{
        try {
            InputStream in= JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //新建一个输入流
            Properties properties= new Properties();//新建一个资源类，用于读取输入流
            properties.load(in);//资源流载入输入流
            driver = properties.getProperty("driver");//获得/读取相应的资源
            //用法就是变量名=properties.getProperty("键值")
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            //加载驱动
            Class.forName(driver);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
        }
    }
    //驱动加载好了，把获取连接和释放连接写一下
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //释放连接
}
