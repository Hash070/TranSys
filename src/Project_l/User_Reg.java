package Project_l;
import java.sql.*;

import static Project_l.LoginSqlQuery.isEcho;

public class User_Reg {
    public User_Reg(String username_in, String password_in) throws AccountEcho  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/Tran?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String password="123456";
        String username="root";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(isEcho(username_in))
            throw new AccountEcho(username_in);
        try {
        Statement statement =connection.createStatement();
        String sql="INSERT INTO `Tran`.`Account`(`username`, `password`) VALUES ('"+username_in+"','"+password_in+"')";
        statement.execute(sql);
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
//        PreparedStatement printStackTrace = null;
//
//        try {
//            printStackTrace= (PreparedStatement) connection.createStatement();
//            printStackTrace.setString(1,username_in);
//            printStackTrace.setString(2,password_in);
//            System.out.println(sql);
//            printStackTrace = connection.prepareStatement(sql);
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        boolean rs ;
//        try {
//            rs = printStackTrace.execute(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            printStackTrace.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
class AccountEcho extends Exception{
//    System.out.println("账号重复");
    String echoaccount;
    public AccountEcho(String acc){
        echoaccount = acc;
    }
    public String getAccount(){
        return echoaccount;
    }

}

