package Class4.p9251_스티커;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int[][] scores;

        while(tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            scores = new int[2][N];

            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    scores[i][j] = Integer.parseInt(st.nextToken());
                }
            }


        }
    }
}
