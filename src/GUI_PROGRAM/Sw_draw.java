package GUI_PROGRAM;
import javax.swing.*;
import java.awt.*;
public class Sw_draw implements Icon {
    private int d;
    private int l;
    public int getIconHeight() {
        return this.d;
    }
    public int getIconWidth() {
        return this.l;
    }
    public Sw_draw(int d,int l){
        this.d = d;
        this.l = l;
    }
    public void paintIcon(Component arg0,Graphics arg1,int x,int y){
        arg1.fillOval(x,y,d,l);
    }

    public static void main(String[] args) {
        Sw_draw sw=new Sw_draw(20,20);
        JLabel jl=new JLabel("test",sw,SwingConstants.CENTER);
        JFrame jf=new JFrame();
//        Container c=jf.getContentPane();
        jf.add(jl);
        jf.setBounds(100,100,100,100);
//        c.add(jl);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
