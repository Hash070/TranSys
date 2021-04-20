package MULIT_LINE;

public class Seller_1 {
    public static void main(String[] args) {
        SellRunnable se=new SellRunnable();
        Thread a=new Thread(se,"一号窗口");
        Thread b=new Thread(se,"二号窗口");
        Thread c=new Thread(se,"三号窗口");
        a.start();
        b.start();
        c.start();
    }
}
class SellRunnable implements Runnable {
    private int t=10;
    @Override
    public void run()
    {
        while(t>0)
        {
            System.out.println(Thread.currentThread().getName()+"售出了"+(11-t)+"号，还剩"+(--t)+"张");
        }
    }
}
