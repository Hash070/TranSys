package HOMEWORKS;

import java.util.Scanner;

public class PTA71 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char[] ini=new char[3];
        String a;
        a=in.nextLine();
        ini=a.toCharArray();
        for(int i=2;i>=0;i--)
        {
            if(ini[i]!='0')
            System.out.print(ini[i]);
        }
    }
}
