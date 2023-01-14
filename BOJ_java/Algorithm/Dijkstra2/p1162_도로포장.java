package Algorithm.Dijkstra2;

import java.io.*;
import java.util.*;

public class p1162_도로포장 {
    static int N, M, K;
    static ArrayList<Node>[] adj;
    static long dp[][];
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        dp = new long[N + 1][K + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dp[i], INF);
        }


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w, 0));
            adj[v].add(new Node(u, w, 0));
        }

        dijkstra();

        long min = INF;
        for(long dist: dp[N]) {
            min = Math.min(dist, min);
        }
        System.out.println(min);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dp[cur.idx][cur.count] < cur.w) continue;

            // 포장 하는 경우
            if(cur.count < K) {
                for(Node next: adj[cur.idx]) {
                    if(dp[next.idx][cur.count + 1] > dp[cur.idx][cur.count]) {
                        dp[next.idx][cur.count + 1] = dp[cur.idx][cur.count];
                        pq.add(new Node(next.idx, dp[next.idx][cur.count + 1], cur.count + 1));
                    }
                }
            }

            // 포장 안하는 경우
            for(Node next: adj[cur.idx]) {
                if(dp[next.idx][cur.count] > dp[cur.idx][cur.count] + next.w) {
                    dp[next.idx][cur.count] = dp[cur.idx][cur.count] + next.w;
                    pq.add(new Node(next.idx, dp[next.idx][cur.count] , cur.count));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx, count;
        long w;

        public Node(int idx, long w, int count) {
            this.idx = idx;
            this.w = w;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.w - o.w);
        }
    }
}


