package Algorithm.IndexedTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2042_구간합구하기 {
    static int N, M, K, B, T, S;
    static long IDT[];
    static long nums[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        init();

        T = M + K;
        int command, a;
        long b;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Long.parseLong(st.nextToken());

            switch(command) {
                case 1 :
                    update(a, b);
                    break;
                case 2 :
                    sb.append(getSum(a, (int)b) + "\n");
            }
        }
        System.out.println(sb);
    }
    static void init() {
        S = 1;
        while(N > (S <<= 1));
        S <<= 1;
        B = S / 2;

        IDT = new long[S];

        for (int i = 0; i < N; i++) {
                IDT[B + i] = nums[i];
        }

        for (int i = B - 1; i >= 1; i--) {
            IDT[i] = IDT[i * 2] + IDT[i * 2 + 1];
        }

    }

    static long getSum(int l, int r) {
        l += B - 1;
        r += B - 1;
        long sum = 0;

        while(l <= r) {
            if((l & 1) == 1) sum += IDT[l++];
            if((r & 1) == 0) sum += IDT[r--];
            l /= 2;
            r /= 2;
        }

        return sum;
    }

    static void update(int idx, long num) {
        idx += B - 1;
        IDT[idx] = num;

        while(idx > 1) {
            idx /= 2;
            IDT[idx] = IDT[idx * 2] + IDT[idx * 2 + 1];
        }
    }
}
