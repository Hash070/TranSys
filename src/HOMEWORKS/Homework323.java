package HOMEWORKS;

import java.util.Scanner;

public class Homework323 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input[]=new char[105];
        char target[]=new char[105];
        String in=new String();
        String tar=new String();
        in=scanner.nextLine();
        tar=scanner.nextLine();
        input=in.toCharArray();
        target=tar.toCharArray();
        int n=in.length();
        int times=0;
        for (int i = 0;i<n-1; i++)
        {
            if (input[i]!=target[i])
            {
                if(input[i]=='*')
                    input[i]='o';
                else if(input[i]=='o')
                    input[i]='*';
                if(input[i+1]=='*')
                    input[i+1]='o';
                else if(input[i+1]=='o')
                    input[i+1]='*';
                times++;
            }
        }
        System.out.println(times);
    }
}
