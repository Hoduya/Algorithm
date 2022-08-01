package C1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1003_피보나치함수 {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp = new int[40 + 1];

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());

            if(N == 0) {
                sb.append("1 0\n");
            }
            else{
                sb.append(fibo(N - 1) + " " + fibo(N) + "\n");
            }
        }

        System.out.println(sb);
    }

    public static int fibo(int n){
        if(dp[n] != 0){
            return dp[n];
        }

        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            dp[n] = fibo(n - 1) + fibo(n - 2);
            return dp[n];
        }
    }
}
