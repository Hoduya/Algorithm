package Algorithm.BellmanFord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1219_오민식의고민 {
    static final long INF = Long.MAX_VALUE;
    static int N, S, E, M;
    static ArrayList<Node>[] adj;
    static long[] revenue, cost;
    static boolean isCycle = false;
    static boolean isGee = false;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        revenue = new long[N];
        cost = new long[N];
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        int u, v, c;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) revenue[i] = Integer.parseInt(st.nextToken());

        bellmanFord();
        if(isCycle && isGee) {
            System.out.println("Gee");
        }
        else if(cost[E] == INF) {
            System.out.println("gg");
        } else {
            System.out.println(-cost[E]);
        }
    }

    static void bellmanFord() {
        Arrays.fill(cost, INF);
        cost[S] = -revenue[S];
        for(int i = 0; i < N + 100; i++) {
            for(int j = 0; j < N; j++) {
                if(cost[j] == INF) continue;

                for(Node next : adj[j]) {
                    if(cost[next.idx] > cost[j] + next.cost - revenue[next.idx]) {
                        cost[next.idx] = cost[j] + next.cost - revenue[next.idx];
                        if(i > N - 1) {
                            isCycle = true;
                            if(next.idx == E)
                                isGee = true;
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}