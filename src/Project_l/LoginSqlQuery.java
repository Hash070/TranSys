package Project_l;

import java.sql.*;

public class LoginSqlQuery {
    public static final String driverclass = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/Tran?useUnicode=true&characterEncoding=utf8&useSSL=true";
    public static final String user = "root";
    public static final String password = "123456";
    static {
        try {
            Class.forName(driverclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isEcho(String username){
        Connection conn=getConnection();
        Statement st=null;
        ResultSet rs=null;
        try {
            st=conn.createStatement();
            rs=st.executeQuery("select * from Account where username ='"+username+"'");
            if (rs.next())
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
                close(rs,st,conn);
        }
        return false;
    }
    public static boolean login(String username, String password) {
//        boolean status=false;
        Connection conn = getConnection();
//        Statement st = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        try {
            String sql ="select * from Account where username=? and password=?";
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            //select * from userinfo where username= '" + username + "' and password= '" + password + "'"
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                st.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void close(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        Connection conn =getConnection();
//        if (conn != null)
//            System.out.println("yes");
        System.out.println(isEcho("hello"));
    }
}
