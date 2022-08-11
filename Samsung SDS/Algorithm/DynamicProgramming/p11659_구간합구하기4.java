package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        int l, r;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[r] - prefixSum[l - 1] + "\n");
        }

        System.out.println(sb);
    }
}