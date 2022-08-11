package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                a[i][j] = tmp.charAt(j - 1) - '0';
            }
        }

        int l, u, d, s;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(a[i][j] == 0) continue;

                l = a[i][j - 1];
                u = a[i - 1][j];
                d = a[i - 1][j - 1];

                if(l >= 1 && u >= 1 && d >= 1) {
                    s = Math.min(Math.min(l, u) ,d);
                    a[i][j] = s + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }

        System.out.println(max * max);
    }
}