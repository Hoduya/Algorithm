package Algorithm.IndexedTree;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IndexedTree {
    static BufferedReader br;
    static int N, M, K, B, T, S;
    static long IDT[], nums[];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        init();

        System.out.println(getSum(1, 2));

    }

    static void init() {
        S = 1;
        while( N > (S <<= 1) ); // N 보다 큰 최소 2제곱수

        S <<= 1; // 트리 사이즈
        B = S / 2; // 리프노드의 시작점

        IDT = new long[S];

        // 리프노드 채우기
        for(int i = 0; i < N; i++) {
            IDT[B + i] = nums[i];
        }

        // NON-Leaf Node 채우기
        for(int i = B - 1; i >= 1; i--) {
            IDT[i] = IDT[i * 2] + IDT[i * 2 + 1];
        }
    }

    static long getSum(int l, int r) { // l ~ r 구간 합 구하기
        l += B - 1;
        r += B - 1;
        long sum = 0;
        while(l <= r) {
            if((l & 1) == 1) sum += IDT[l++]; // l 이 홀수면 부모 노드의 값을 포함하면 안된다.
            if((r & 1) == 0) sum += IDT[r--]; // r 이 짝수면 부모 노드의 값을 포함하면 안된다.
            l /= 2; // 부모 노드로 올라감
            r /= 2;
        }

        return sum;
    }

    // 맥스트리 만들어줘야함
    static long getMax(int l, int r) {
        l += B - 1;
        r += B - 1;
        long max = 0;

        while(l <= r) {
            if((l & 1) == 1)  max = Math.max(max, IDT[l++]);
            if((r & 1) == 0)  max = Math.max(max, IDT[r--]);
            l /= 2;
            r /= 2;
        }

        return max;
    }

    static void update(int idx, long num) {
        idx += B - 1;
        IDT[idx] = num;
        while(idx > 1) {
            idx /= 2;
            IDT[idx] = IDT[idx * 2] + IDT[idx * 2 +1];
        }
        return;
    }
}

