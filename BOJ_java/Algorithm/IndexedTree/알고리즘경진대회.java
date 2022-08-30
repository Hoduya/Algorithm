package Algorithm.IndexedTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 알고리즘경진대회 {
    static HashMap<Integer, Integer> map;
    static int N;
    static int leafStart;
    static int[] A, A_asc;
    static long[] idt_sum, idt_gcd;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        A_asc = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        A_asc = A.clone();
        Arrays.sort(A_asc);

        // Map
        //  key: 배열 원소  val: 오름차순으로 정렬된 배열의 인덱스
        map = new HashMap();
        for (int i = 1; i <= N; i++) map.put(A_asc[i], i);

        // 1. 구간합 계산을 위한 인덱스 트리
        // 2. 구간 최대공약수 계산을 위한 인덱스 트리
        init();

        update(1, 2);
        update(2, 12);
        update(3, 18);

//        for(long a : idt_gcd) {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//
//        System.out.println(getGCD(1,3 ));

        int idx;
        long val;
        long result;
        int end = N ;
        long sum = 0;
        long gcd = 0;

        idx = map.get(A[1]);
        val = A[1];
        update(idx, val);
        result = A[1]; // 1 층은 개인팀

        System.out.println(result);

        for(int i = 2; i <= N; i++) {
            idx = map.get(A[i]);
            val = A[i];

            update(idx, val);

            sum = getSum(idx, end);
            gcd = getGCD(idx, end);

            if(idx == end) result = val;
            else result = sum / gcd;

            System.out.println(result);
        }

       // System.out.println(count);
    }

    static void init() {
        int S = 1;
        while(N > (S <<= 1));
        S <<= 1;
        idt_sum = new long[S];
        idt_gcd = new long[S];
        leafStart = S / 2;
    }

    static long getGCD(int l, int r) {
        l += leafStart - 1;
        r += leafStart - 1;
        long gcd = 0;

        while(l <= r) {
            if((l & 1) == 1) gcd = GCD(idt_gcd[l++], gcd);
            if((r & 1) == 0) gcd = GCD(idt_gcd[r--], gcd);
            l >>= 1;
            r >>= 1;
        }
        return gcd;
    }

    static long getSum(int l, int r) {
        l += leafStart - 1;
        r += leafStart - 1;
        long sum = 0;

        while(l <= r) {
            if((l & 1) == 1) sum += idt_sum[l++];
            if((r & 1) == 0) sum += idt_sum[r--];
            l >>= 1;
            r >>= 1;
        }
        return sum;
    }

    static void update(int idx, long val) {
        idx += leafStart - 1;

        idt_sum[idx] = val;
        idt_gcd[idx] = val;

        while(idx > 1) {
            idx /= 2;
            idt_sum[idx] = idt_sum[idx << 1] + idt_sum[(idx << 1) + 1];
            idt_gcd[idx] = GCD(idt_gcd[idx << 1], idt_gcd[(idx << 1) + 1]);
        }
    }

    static long GCD(long a, long b) {
        if(b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }
}
