package MULIT_LINE;
//new and Thread class creat a line object ,
//while obj used start() ,the line will enter runnable mode
//at first ,we need to use Thread to creat line
public class Demo1
{
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        mt.start();
        MyThread mt1=new MyThread("my first mutiply");
        mt1.start();
    }
}
class MyThread extends Thread{
    public MyThread(){};
    public MyThread(String str){
        super(str);
    }
    @Override
    public void run(){
        while(true)
        System.out.println(getName());
    }
}
