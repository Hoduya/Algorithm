package Algorithm.BFS;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p13913_숨바꼭질4 {
    static final int MAX = 100000;
    static int[] counts;
    static int[] path;


    public static void main(String[] args) throws IOException {
        Queue<Integer>[] a;
        a = new Queue[1];
        a[0] = new LinkedList<>();
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // [i][0] : i까지 최소 이동 횟수 & 방문 체크
        // [i][1] : i 방문 전 위치
        counts = new int[MAX + 1];
        path = new int[MAX + 1];

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k)
            System.out.println(0 + "\n" + n);
        else{
            bfs(n, k);
            Stack<Integer> stack = new Stack<>();
            int idx = k;
            while(idx != n) {
                stack.push(idx);
                idx = path[idx];
            }
            stack.push(idx);

            StringBuilder sb = new StringBuilder();
            sb.append(counts[k] + "\n");
            while(!stack.isEmpty()) sb.append(stack.pop() + " ");

            System.out.println(sb);
        }

    }

    static void bfs(int n, int k) {
        Queue<Dot> q = new LinkedList<>();

        q.add(new Dot(n, 0));

        int tx;
        while(!q.isEmpty()) {
            Dot cur = q.poll();

            for(int i = 0; i < 3; i++) {
                if(i == 1) tx = cur.x + 1; // x + 1 이동
                else if(i == 2) tx = cur.x - 1; // x - 1 이동
                else tx = 2 * cur.x; //2 * X 이동

                if(tx < 0 || tx > MAX || counts[tx] != 0) continue;

                q.add(new Dot(tx, cur.count + 1));
                counts[tx] = cur.count + 1;
                path[tx] = cur.x;

                if(tx == k) return;
            }
        }
    }

    static class Dot {
        int x, count;

        public Dot(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}