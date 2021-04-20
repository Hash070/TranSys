package HOMEWORKS;

import java.util.*;
public class _1532Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner in=new Scanner(System.in);
        Boolean flag=false;
        int n=in.nextInt(),m=in.nextInt();
        int[] values=new int[n];
        for(int i=0;i<n;i++)
            values[i]=in.nextInt();
        Arrays.sort(values);
        for(int i=0,j=values.length-1;i<values.length;i++)//然后将前面的下标向后移动
        {
            while(j>=0 && values[j]+values[i]>m) j--;//将末尾数值调整到符合条件的临界值
            if(j!=-1 && j != i && values[j]+values[i]==m)
            {
                flag=true;
                System.out.printf("%d %d",values[i],values[j]);
                break;
            }
        }
        if(!flag) System.out.printf("No Solution");
    }
}