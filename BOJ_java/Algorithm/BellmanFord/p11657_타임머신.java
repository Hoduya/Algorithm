package Algorithm.BellmanFord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11657_타임머신 {
    static long INF = Long.MAX_VALUE;
    static int N, M;
    static ArrayList<Node>[] adj;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        dist = new long[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanFord()) {
            sb.append(-1);
        }
        else {
            for (int i = 2; i <= N; i++) {
                if(dist[i] == INF) sb.append(-1 + "\n");
                else sb.append(dist[i] + "\n");
            }
        }

        System.out.print(sb);
    }

    static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update;

        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
                if(dist[j] == INF)
                    continue;
                for(Node next : adj[j]) {
                    if(dist[next.idx] > dist[j] + next.w) {
                        dist[next.idx] = dist[j] + next.w;
                        update = true;
                    }
                }
            }
            if(!update) break;
        }

        for (int i = 1; i <= N; i++) {
            if(dist[i] == INF)
                continue;
            for(Node next : adj[i]) {
                if(dist[next.idx] > dist[i] + next.w) {
                    return true;
                }
            }
        }

        return false;
    }

    static class Node {
        int idx;
        long w;

        public Node(int idx, long w) {
            this.idx = idx;
            this.w = w;
        }
    }
}
