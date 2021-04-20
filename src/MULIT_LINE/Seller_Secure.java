package MULIT_LINE;
//line sync
//synchronized()
//only allowed one line in h
public class Seller_Secure
{
    public static void main(String[] args)
    {
        SyncSeller x=new SyncSeller();
        Thread a=new Thread(x,"window 1");
        Thread b=new Thread(x,"window 2");
        Thread c=new Thread(x,"window 3");
        a.start();
        b.start();
        c.start();
    }
}
class SyncSeller implements Runnable {
    private int a=10;
    Object obj =new Object();
    @Override
    public void run()
    {
        while(a>0)
        {
            synchronized(obj)
            {
                if(a>0) {
                    try{
                        Thread.sleep(10);
                    }
                        catch(InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"售出了"+(11-a)+"号，还剩"+(--a)+"张");
                }
            }
        }
    }
