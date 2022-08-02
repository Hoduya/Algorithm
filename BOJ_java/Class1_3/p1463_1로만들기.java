package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463_1로만들기 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        div(N);
        System.out.println(dp[N]);
    }

    static void div(int n) {
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
    }
}
