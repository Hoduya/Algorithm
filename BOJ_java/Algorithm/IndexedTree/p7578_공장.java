package Algorithm.IndexedTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p7578_공장 {
    static HashMap<Integer, Integer> map;
    static int N;
    static int leafStart;
    static int[] A, B;
    static long[] idt;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        // B열의 값 - 인덱스 맵
        map = new HashMap();
        for (int i = 0; i < N; i++) map.put(B[i], i);

        // 구간합 계산을 위한 인덱스 트리
        init();

        int idx; // B열 인덱스
        int end = N - 1;
        long count = 0;
        for(int i = 0; i < N; i++) {
            idx = map.get(A[i]);
            count += getSum(idx + 1, end);
            update(idx, 1);
        }

        System.out.println(count);
    }

    static void init() {
        int S = 1;
        while(N > (S <<= 1));
        S <<= 1;
        idt = new long[S];
        leafStart = S / 2;
    }

    static long getSum(int l, int r) {
        l += leafStart;
        r += leafStart;
        long sum = 0;

        while(l <= r) {
            if((l & 1) == 1) sum += idt[l++];
            if((r & 1) == 0) sum += idt[r--];
            l >>= 1;
            r >>= 1;
        }
        return sum;
    }

    static void update(int idx, int val) {
        idx += leafStart;
        idt[idx] = (long)val;
        while(idx > 1) {
            idx /= 2;
            idt[idx] = idt[idx << 1] + idt[(idx << 1) + 1];
        }
    }
}