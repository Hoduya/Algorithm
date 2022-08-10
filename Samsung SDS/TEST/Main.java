package TEST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] vst;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        dist = new int[V + 1];
        vst = new boolean[V + 1];
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }
        dijkstra(S);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(dist[i] == INF) sb.append("INF" + "\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.print(sb);
    }
    static void dijkstra(int s) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            vst[cur.idx] = true;

            for(Node next : adj[cur.idx]) {
                if(!vst[next.idx]) {
                    if(dist[next.idx] > dist[cur.idx] + next.w) {
                        dist[next.idx] = dist[cur.idx] + next.w;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
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