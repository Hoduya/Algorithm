package Algorithm.IndexedTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3653_영화수집 {
    static int N, M;
    static int[] idt;
    static int[] pos;
    static int LS, S;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            init();

            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            int movie, result;
            for(int i = 0; i < M; i++) {
                movie = Integer.parseInt(st.nextToken());
                result = getSum(1, pos[movie]) - 1; // 구간 합 계산
                update(pos[movie], 0);
                pos[movie] = M - i;
                update(pos[movie], 1);
                sb.append(result + " ");
            }
            System.out.println(sb);
        }
    }

    static void init() {
        LS = 1;
        while(N + M > (LS <<= 1));
        S = LS << 1;

        idt = new int[S];
        for(int i = LS + M; i < LS + M + N; i++) idt[i] = 1;
        for(int i = LS - 1; i >= 1; i--) idt[i] = idt[i * 2] + idt[(i * 2) + 1];

        pos = new int[N + 1];
        for(int i = 1; i <= N; i++) pos[i] = M + i;
    }

    static int getSum(int l, int r) {
        l += LS - 1;
        r += LS - 1;

        int sum = 0;
        while(l <= r) {
            if((l & 1) == 1) sum += idt[l++];
            if((r & 1) == 0) sum += idt[r--];
            l /= 2;
            r /= 2;
        }

        return sum;
    }

    static void update(int idx, int val) {
        idx += LS - 1;
        idt[idx] = val;

        while(idx > 1) {
            idx /= 2;
            idt[idx] = idt[idx * 2] + idt[(idx * 2) + 1];
        }
    }
}
