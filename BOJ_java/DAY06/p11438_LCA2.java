package DAY06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11438_LCA2 {
    static int N, M;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2];
        for(int i = 1; i <= N; i++){

        }

    }
}
