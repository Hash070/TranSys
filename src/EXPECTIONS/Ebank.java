package EXPECTIONS;

public class Ebank {
    private double balance;
    private int number;
    public Ebank(int number){
        this.number=number;
    }
    public void deposit(double amount){
        balance +=amount;
    }
    public void withdraw(double amount) throws withdrawmeiqian{
        if (amount<=balance){
            balance-=amount;
        }
        else{
            double needs=amount -balance;
            throw new withdrawmeiqian(needs);
        }
    }
    public double getBalance()
    {
        return balance;
    }
    //方法：返回卡号
    public int getNumber()
    {
        return number;
    }
}
class withdrawmeiqian extends Exception{
    private double amount;
    public withdrawmeiqian(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}