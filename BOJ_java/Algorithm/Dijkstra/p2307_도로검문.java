package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2307_도로검문 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<Node>[] adj;
    static ArrayList<Integer>[] trace;
    static int[] dist;
    static int min_cost, max_cost;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        trace = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            trace[i] = new ArrayList<>();
        }

        int u, v, w;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        dijkstra();
        min_cost = dist[N];
        max_cost = 0;
        backtracking(N);

        if(max_cost == INF) {
            System.out.println(-1);
        } else {
            System.out.println(max_cost - min_cost);
        }
    }

    static void backtracking(int node) {
        if(node == 1) {
            return;
        }

        for(int next : trace[node]) {
            sol(next, node);
            max_cost = Math.max(max_cost, dist[N]);
            backtracking(next);
        }
    }

    // 최소 경로에 포함된 도로 하나 지우고 다익스트라 수행
    // 위 과정을 반복해보며 최대 지연시간을 찾는다.
    static void sol(int ru, int rv) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);

        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.idx] < cur.w) continue;

            for(Node next : adj[cur.idx]){
                if(next.idx == ru && cur.idx ==rv) continue;
                if(next.idx == rv && cur.idx ==ru) continue;

                if(dist[next.idx] > dist[cur.idx] + next.w) {
                    dist[next.idx] = dist[cur.idx] + next.w;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);

        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.idx] < cur.w) continue;

            for(Node next : adj[cur.idx]){

                if(dist[next.idx] > dist[cur.idx] + next.w) {
                    dist[next.idx] = dist[cur.idx] + next.w;
                    pq.add(new Node(next.idx, dist[next.idx]));

                    // 경로 갱신 시 저장
                    trace[next.idx].clear();
                    trace[next.idx].add(cur.idx);
                }

                else if(dist[next.idx] == dist[cur.idx] + next.w) {
                    // 최단 경로가 여러개 일 경우
                    trace[next.idx].add(cur.idx);
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
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
