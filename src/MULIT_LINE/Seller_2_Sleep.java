package MULIT_LINE;
class Sse implements Runnable {
    private int num = 10;
    @Override
    public void run() {
        while (num>0)
        {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"售出了"+(11-num)+"号，还剩"+(--num)+"张");
        }
    }
}
public class Seller_2_Sleep {
    public static void main(String[] args) {
        Sse se=new Sse();
        Thread a=new Thread(se,"Window 1");
        Thread b=new Thread(se,"Window 2");
        Thread c=new Thread(se,"Window 3");
        a.start();
        b.start();
        c.start();
    }
}
