package Algorithm.DynamicProgramming;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5573_산책 {
    // 위쪽이 짝수면 나는 바뀐다
    // 왼쪽이 홀수면 나는 바뀐다

    // if(x[i - 1][j] & 1 == 0 || x[i][j-1] & 1 == 1) x[i][j] ^= 1;
    // map[1][1] 은 n이 짝수면 자기 자신 홀수면 반대

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H, W, N;
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[H + 1][W + 1];

    }
}
