package EXPECTIONS;

public class Ex {
    public static void main(String[] args) {
        Exp e=new Exp();
        try {
//            e.i[9]=10;
            e.dan();
            e.i[10]=0;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
class Exp {
    int[] i = new int[10];
    public void dan() throws Exception{


//    try{
//        throw new Exception();
//        }catch(Exception ex){
//        System.out.println("errors occurred");
//        }finally{
        System.out.println("finally");
//        }
//        if(true)
//            throw new Exception();
        }
}