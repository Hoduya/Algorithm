package Algorithm.IndexedTree;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class p2517_달리기 {
    static HashMap<Integer, Integer> map;
    static int rank[];
    static int N;
    static long idt[];
    static int leafStart;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        rank = new int[N + 1];
        for(int i = 1; i <= N; i++) rank[i] = Integer.parseInt(br.readLine());

        // 경로 압축
        int [] temp = rank.clone();
        map = new HashMap<>();
        Arrays.sort(temp);
        for(int i = 1; i <= N; i++) map.put(temp[i], i);
        for(int i = 1; i <= N; i++) rank[i] = map.get(rank[i]);

        // 구간합 계산을 위한 인덱스 트리
        init();
        long count; // 못 앞지르는 사람 수
        long bestRank;
        for (int i = 1; i <= N; i++) {
            count = getSum(rank[i] + 1, N);

            if(count == 0) bestRank = 1;
            else bestRank = count + 1;

            update(rank[i], 1);

            sb.append(bestRank + "\n");
        }
        System.out.println(sb);
    }
    static void init() {
        int S = 1;
        while(N > (S <<= 1));
        S <<= 1;// 트리 사이즈
        leafStart = S / 2;

        idt = new long[S];
    }

    static long getSum(int l, int r) {
        l += leafStart - 1;
        r += leafStart - 1;
        long sum = 0;

        while(l <= r) {
            if ((l & 1) == 1) sum += idt[l++];
            if ((r & 1) == 0) sum += idt[r--];
            l >>= 1;
            r >>= 1;
        }

        return sum;
    }

    static void update(int idx, long val) {
        idx += leafStart - 1;
        idt[idx] = val;

        while(idx > 1) {
            idx >>= 1;
            idt[idx] = idt[idx << 1] + idt[(idx << 1) + 1];
        }
    }
}