import java.util.*;
import java.io.*;


public class Softeer_조립라인 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        int[] AtoB = new int[N];
        int[] BtoA = new int[N];

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            AtoB[i] = Integer.parseInt(st.nextToken());
            BtoA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        A[N] = Integer.parseInt(st.nextToken());
        B[N] = Integer.parseInt(st.nextToken());

        int dp[][] = new int[2][N + 1];
        for(int i = 1; i<= N; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + BtoA[i - 1]) + A[i];
            dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1] + AtoB[i - 1]) + B[i];
        }
        System.out.println(Math.min(dp[0][N], dp[1][N]));
    }
}