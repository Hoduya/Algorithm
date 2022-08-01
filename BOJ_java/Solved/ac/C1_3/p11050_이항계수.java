package Solved.ac.C1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 이항계수
  : nCr = n! / r!(n - r)!
 조합의 성질
  : n+1Cr+1 = nCr + nCr+1 -> 이것을 이용
  : nC0 = nCn = 1
 Dynamic Programming
  : 중복되는 작은 문제를 메모이제이션.
 */

public class p11050_이항계수 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
//        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
        System.out.println(BC(N,K));
    }

//    public static int factorial(int N) {
//        if(N == 0){
//            return 1;
//        }
//        else{
//            return N * factorial(N - 1);
//        }
//    }

    public static int BC(int n, int k){
        if(dp[n][k] > 0){
            return dp[n][k];
        }

        if(n == k || k == 0){
            return dp[n][k] = 1;
        }

        return dp[n][k] = BC(n - 1, k - 1) + BC(n - 1, k);
    }
}
