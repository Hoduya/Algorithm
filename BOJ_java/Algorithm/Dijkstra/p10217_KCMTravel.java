package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p10217_KCMTravel {
    static int INF = Integer.MAX_VALUE;
    static int N, M, K;
    static ArrayList<Node>[] adj;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int result = INF;

        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][10001]; // [i][j] , i 공항까지 j 비용으로 가는 최소시간 저장
            adj = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) Arrays.fill(dp[i], INF);
            for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

            int u, v, c, d;
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                adj[u].add(new Node(v, c, d));
            }

            sol();

            int min = INF;
            for (int i = 1; i <= M; i++) {
                if(min > dp[N][i]) {
                    min = dp[N][i];
                }
            }

            if(min == INF) {
                sb.append("Poor KCM" + "\n");
            } else {
                sb.append(min + "\n");
            }
        }
        System.out.println(sb);
    }

    static void sol() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(Node next : adj[cur.idx]) {
                int cost = next.cost + cur.cost;

                if(cost > M) continue;

                if(dp[next.idx][cost] > cur.time + next.time) {
                    dp[next.idx][cost] = cur.time + next.time;
                    q.add(new Node(next.idx, cost, dp[next.idx][cost]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int idx, cost, time;

        public Node(int idx, int cost, int time) {
            this.idx = idx;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}
