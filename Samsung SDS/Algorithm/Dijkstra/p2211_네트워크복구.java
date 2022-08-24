package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2211_네트워크복구 {
    static ArrayList<Node>[] adj;
    static int N, M;
    static int[] dist;
    static int[] trace;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        trace = new int[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        sol();

        StringBuilder sb = new StringBuilder();

        sb.append(N - 1 + "\n");
        for (int i = 2; i < N + 1; i++) sb.append(i + " " + trace[i] + "\n");
        System.out.print(sb);
    }
    static void sol() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(Node next : adj[cur.idx]) {
                if(dist[next.idx] > dist[cur.idx] + next.w) {
                    dist[next.idx] = dist[cur.idx] + next.w;

                    trace[next.idx] = cur.idx;

                    pq.add(new Node(next.idx, dist[next.idx]));
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