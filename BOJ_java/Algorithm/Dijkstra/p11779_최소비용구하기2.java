package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11779_최소비용구하기2 {
    static final int MAX = Integer.MAX_VALUE;
    static int N, M, S, A;
    static ArrayList<Node>[] adj;
    static int[] prev;
    static int[] dist;

    public static <ArryaList> void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        prev = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for(int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine(), " ");
             u = Integer.parseInt(st.nextToken());
             v = Integer.parseInt(st.nextToken());
             w = Integer.parseInt(st.nextToken());

             adj[u].add(new Node(v, w, 0));
        }

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        dijkstra();
        ArrayList<Integer> results = new ArrayList<>();
        int e = A;
        while(e != 0) {
            results.add(e);
            e = prev[e];
        }

        System.out.println(dist[A]);
        System.out.println(results.size());

        StringBuilder sb = new StringBuilder();
        for (int i = results.size() - 1; i >= 0 ; i--) {
            sb.append(results.get(i) + " ");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, MAX);

        pq.add(new Node(S, 0, 0));
        dist[S] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.w > dist[cur.idx]) continue;

            prev[cur.idx] = cur.prev;

            for(Node next : adj[cur.idx]) {
                if(dist[next.idx] > dist[cur.idx] + next.w) {
                    dist[next.idx] = dist[cur.idx] + next.w;
                    pq.add(new Node(next.idx, dist[next.idx], cur.idx));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int idx, w, prev;

        public Node(int idx, int w, int prev) {
            this.idx = idx;
            this.w = w;
            this.prev = prev;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}