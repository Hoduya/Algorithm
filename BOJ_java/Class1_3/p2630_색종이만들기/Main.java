package Class1_3.p2630_색종이만들기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int total_white;
    static int total_blue;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        total_blue = 0;
        total_white = 0;

        divide(0, 0, N);

        System.out.println(total_white + "\n" + total_blue);
    }

    static void divide(int row, int col, int size){

        if (isSameColor(row, col, size)) {
            if (map[row][col] == 0) total_white++;
            else total_blue++;
        }

        else {
            size = size / 2;
            divide(row, col, size);             // 1 사분면
            divide(row + size, col, size); // 2 사분면
            divide(row, col + size, size);  // 3 사분면
            divide(row + size, col + size, size); // 4 사분면
        }
    }

    static boolean isSameColor(int row, int col, int size){

        int checkColor = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(map[i][j] != checkColor)
                    return false;
            }
        }
        return true;
    }
}
