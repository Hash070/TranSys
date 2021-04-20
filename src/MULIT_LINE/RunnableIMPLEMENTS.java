package MULIT_LINE;

public class RunnableIMPLEMENTS {
    public static void main(String[] args) {
        Test t=new Test();
        Thread th =new Thread(t);
        th.start();
        for (int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+"      "+i);
        }
    }
}
class Test implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <100;i++)
        {
            System.out.println(Thread.currentThread().getName()+"      i="+i);
        }
    }
}