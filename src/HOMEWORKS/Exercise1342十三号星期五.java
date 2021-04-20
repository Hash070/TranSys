package HOMEWORKS;

import java.util.Scanner;

public class Exercise1342十三号星期五 {
    public static boolean year(long y){
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }
    public static long dayofmonth(long x,long y){
        if (x == 1) {
            return 31;
        } else if (x == 3) {
            return 31;
        } else if (x == 5) {
            return 31;
        } else if (x == 7) {
            return 31;
        } else if (x == 8) {
            return 31;
        } else if (x == 10) {
            return 31;
        } else if (x == 12) {
            return 31;
        } else if (x == 4) {
            return 30;
        } else if (x == 6) {
            return 30;
        } else if (x == 9) {
            return 30;
        } else if (x == 11) {
            return 30;
        } else if (x == 2) {
            if (year(y))
                return 29;
            else
                return 28;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long years,alldays=0;

        years= scanner.nextInt();
        for(int i=1900;i<years+1900;i++)
        {
            for(int j=1;j<=12;j++)
            alldays+=dayofmonth(j,i);
        }
        System.out.println(alldays);//分别是第几天？？？（每月的十三号)
        int[][] date=new int[146462][146462];
        for(int i=1900;i<years+1900;i++)
        {
            for(int j=1;j<=12;j++)
            {
                for(int k=1;k<=dayofmonth(j,i);k++)
                {
                    for(int l=0,m=0;;m++)
                    {
                        if(m==7)
                        {
                            m=0;
                            l++;
                        }
                        date[l][m]=k;
                    }
                }
            }
        }
        System.out.println(date[1][1]);
    }
}