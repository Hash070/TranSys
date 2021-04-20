package GUI_PROGRAM;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: abin
 * Date: 2021-03-21
 * Description:
 */
public class Login extends JFrame {

    public void loadFrame(){
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        JPanel panel = new JPanel();

        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("账号:");
        label.setBounds(50,50,30,30);
        panel.add(label);

        JLabel label1 = new JLabel("密码:");
        label1.setBounds(50,100,30,30);
        panel.add(label1);

        JTextField idText = new JTextField();
        idText.setBounds(90,50,120,25);
        panel.add(idText);

        JPasswordField pwdText = new JPasswordField();
        pwdText.setBounds(90,100,120,25);
        panel.add(pwdText);

        JButton loginBtn = new JButton("登录");
        loginBtn.setBounds(70,150,60,30);
        panel.add(loginBtn);

        JButton registerBtn = new JButton("注册");
        registerBtn.setBounds(150,150,60,30);
        panel.add(registerBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了登录按钮");
                String id = idText.getText();
                String password = new String(pwdText.getPassword());

                System.out.println("账号："+id);
                System.out.println("密码："+password);

                frame.dispose();    //登录界面消失
//                Login mainFrame = new Login();
//                mainFrame.setVisible(true);
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        new Login().loadFrame();
    }
}