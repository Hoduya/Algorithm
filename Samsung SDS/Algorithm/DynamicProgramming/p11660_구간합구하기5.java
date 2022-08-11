package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N + 1][N + 1];
        int[][] prefixSum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = nums[i][j] + prefixSum[i][j - 1] + prefixSum[i - 1][j];
                prefixSum[i][j] -= prefixSum[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int x1, y1, x2, y2;
        int result;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1];
            result += prefixSum[x1 - 1][y1 - 1];
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
