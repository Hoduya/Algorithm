package Class4.p9251_LCS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int N = str1.length();
        int M = str2.length();

        int[][] lcs = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char c = str1.charAt(i - 1);
            for (int j = 1; j <= M; j++) {
                if(c == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        System.out.println(lcs[N][M]);
    }
}
