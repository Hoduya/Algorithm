package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1162_도로포장 {
    static final long INF = Long.MAX_VALUE;
    static ArrayList<Node>[] adj;
    static long dp[][];
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w, 0));
            adj[v].add(new Node(u, w, 0));
        }

        // dp[i][j] i번 노드까지 K번 포장해서 갈 수 있는 최소거리.
        dp = new long[N + 1][K + 1];

        dijkstra();

        long min = INF;
        for(long a : dp[N]) min = Math.min(a, min);
        System.out.println(min);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) Arrays.fill(dp[i], INF);

        dp[1][0] = 0;
        pq.add(new Node(1, 0, 0));


        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dp[cur.idx][cur.count] < cur.w) continue;

            for(Node next : adj[cur.idx]) {

                // 도로를 포장하는 경우
                if(cur.count < K && dp[next.idx][cur.count + 1] > dp[cur.idx][cur.count]) {
                    dp[next.idx][cur.count + 1] = dp[cur.idx][cur.count];
                    pq.add(new Node(next.idx, dp[next.idx][cur.count + 1], cur.count + 1));
                }

                // 도로를 포장하지 않는 경우
                if(dp[next.idx][cur.count] > dp[cur.idx][cur.count] + next.w) {
                    dp[next.idx][cur.count] = dp[cur.idx][cur.count] + next.w;
                    pq.add(new Node(next.idx, dp[next.idx][cur.count], cur.count));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int idx, count;
        long w;

        public Node(int idx, long w, int count) {
            this.idx = idx;
            this.w = w;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.w - o.w);
        }
    }
}
