package EXPECTIONS;

public class Demo_Bank
{
    public static void main(String[] args)
    {
        try
        {
            Bank bank=new Bank(50);
            bank.cun(10);
            bank.qu(10);
            System.out.println("取钱成功");
        }catch (meiqianException e)
        {
            System.out.println(e.eMessage());
            System.out.println(e.toString());
        }
    }
}
class Bank
{
    double money;
    public Bank(double money){
        this.money = money;
    }
    public void cun(double in)
    {
        money+=in;
    }
    public void qu(double out) throws meiqianException
    {
        if(money<out)
            throw new meiqianException(this,out);

    }
}
class meiqianException extends Exception
{
    private Bank myBank;
    private double qian;
    meiqianException(Bank ba,double out)
    {
        myBank = ba;
        qian=out;

    }
    public String eMessage()
    {
        return "your qian lasts "+myBank.money;
    }
}
