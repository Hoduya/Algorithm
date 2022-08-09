package Class4.p2407_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dp;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(factorial(N));
    }

    static int factorial(int num) {
        if(num == 1) {
            return 1;
        }

        if(dp[num] != 0) {
            return dp[num];
        }

        return dp[num] = num * factorial(num - 1);
    }
}
