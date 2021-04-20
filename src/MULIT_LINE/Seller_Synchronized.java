package MULIT_LINE;
class SyncSeller_ implements Runnable{
    private int num =10;
    Object o=new Object();
    @Override
    public synchronized void run(){//这样就能protect，防止产生线程安全.
        while(num>0)
        {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"售出了"+(11-num)+"号，还剩"+(--num)+"张");
        }
    }
    private synchronized void sell(){

    }
}
public class Seller_Synchronized {
    public static void main(String[] args) {
        SyncSeller_ x=new SyncSeller_();
        Thread a=new Thread(x,"window 1");
        Thread b=new Thread(x,"window 2");
        Thread c=new Thread(x,"window 3");
        a.start();//全都是Windows1 sell的，难道是我的电脑性能过剩了？（对应这样的程序而言）
        b.start();
        c.start();
    }
}
