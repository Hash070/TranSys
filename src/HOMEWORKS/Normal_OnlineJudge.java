package HOMEWORKS;

import java.util.Scanner;
public class Normal_OnlineJudge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int flag = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i + j + k == n && 3 * i + 2 * j + k == c) {
                        System.out.println(i + " " + j + " " + k);
                        flag = 1;
                    }
                }
            }
        }
        if (flag == 0) {
            System.out.println("No answer");
        }
    }


}
