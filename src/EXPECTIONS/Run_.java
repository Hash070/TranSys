package EXPECTIONS;

public class Run_ {
    public static void main(String[] args) {
        Ebank nm=new Ebank(199);
        nm.deposit(100);
        try {
        nm.withdraw(120);}catch(withdrawmeiqian e){
            System.out.println("meiqianle!"+"还差"+e.getAmount()+"块钱");
            e.printStackTrace();
        }
    }
}
