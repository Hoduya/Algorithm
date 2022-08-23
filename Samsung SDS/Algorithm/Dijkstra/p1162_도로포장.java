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
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] adj;
    static int dp[][];
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
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        // dp[i][j] i번 노드까지 K번 포장해서 갈 수 있는 최소거리.
        dp = new int[N + 1][K + 1];

        dijkstra();

        System.out.println(dp[N][0]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) Arrays.fill(dp[i], INF);
        for(int i = 1; i <= K; i++) dp[1][i] = 0;

        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dp[cur.idx][0] < cur.w) continue;

            for(Node next : adj[cur.idx]) {
                if(dp[next.idx][0] > dp[cur.idx][0] + next.w) {
                    dp[next.idx][0] = dp[cur.idx][0] + next.w;
                    pq.add(new Node(next.idx, dp[next.idx][0]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int idx, w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
