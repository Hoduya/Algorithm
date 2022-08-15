package Class4.p2407_조합;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BigInteger[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new BigInteger[101][101];

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    dp[i][j] = new BigInteger("1");
                }
                else {
                    dp[i][j] = dp[i - 1][j].add(dp[i - 1][j - 1]);
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
