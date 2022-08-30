package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N ; i++) {
            for(int j = 1; j <= K; j++) {
                if(j >= w[i]) { // i 번째 물품을 j 용량 가방에 넣을 수 있으면

                    // i 번째 물품까지 봤을 때
                    //  1) 1 ~ i - 1 번째 물품 중 j 용량 가방에 넣을 수 있는 최대 가치
                    //  2) 1 ~ i - 1 번째 물품 중 j - w[i] 용량 가방에 i 물품을 넣었을 때 가치
                    //  1, 2 중 최대값을 저장
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}