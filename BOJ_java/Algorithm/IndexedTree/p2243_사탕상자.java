package Algorithm.IndexedTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2243_사탕상자 {
    static long[] idt;
    static int leafStart;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int s = 1;
        while(1000000 > (s <<= 1));
        leafStart = s;
        idt = new long[s << 1];

        StringTokenizer st;
        int command;
        long a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken().charAt(0);

            switch(command) {
                case '1' : // 사탕 꺼내기
                    a = Integer.parseInt(st.nextToken());
                    sb.append(poll(a) + "\n");

                    break;
                case '2' : // 사탕 넣기
                    a = Integer.parseInt(st.nextToken());
                    b = Long.parseLong(st.nextToken());
                    update((int)a - 1, b);
                    break;
            }
        }

        System.out.print(sb);
    }
    static long poll(long rank) {
        int idx = 1; // 루트 부터 리프 노드까지
        int left, right;

        while(idx < leafStart) {
            left = idx * 2;
            right = idx * 2 + 1;

            if(rank > idt[left]) { // 왼쪽 자식보다 크면 오른쪽 자식으로 이동
                rank -= idt[left];
                idx = right;
            }
            else { // 왼쪽 자식보다 작거나 같으면 왼쪽 자식으로 이동
                idx = left;
            }
        }
        update(idx - leafStart, -1); // 사탕 꺼내기
        return idx - leafStart + 1;
    }

    static void update(int idx, long num) {
        idx += leafStart;
        idt[idx] += num;

        while(idx > 1) {
            idx >>= 1;
            idt[idx] = idt[(idx << 1)] + idt[(idx << 1) + 1];
        }
    }
}
