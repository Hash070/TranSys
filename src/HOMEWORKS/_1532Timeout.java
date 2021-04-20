package HOMEWORKS;

import java.util.Scanner;
import java.util.Arrays;
public class _1532Timeout
{
    public static void main(String[] args) {
        int n,m,flag=0;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        int[] c =new int[100010];
        for(int i=0;i<c.length;i++)
            c[i]=1010;
        for(int i=0;i<n;i++)
        {
            c[i]=in.nextInt();
        }
        Arrays.sort(c);
        for(int i=0;i<n&&c[i]<m;i++)
        {
            for(int j=0;j<=n&&c[j]<m;j++)
            {
                if((c[i]+c[j])==m&&(c[i]!=c[j])&&c[i]!=0)
                {
                flag=1;
                System.out.println(c[i]+" "+c[j]);
                }
                if(flag==1)
                    break;
            }
            if(flag==1)
                break;
        }
        if(flag==0)
            System.out.println("No Solution");
    }
}
