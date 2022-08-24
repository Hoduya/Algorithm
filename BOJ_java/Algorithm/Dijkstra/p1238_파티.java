package Algorithm.Dijkstra;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    도착점 X로 부터 다른 모든 정점까지의 최단경로는
    다익스트라 한번으로 구할 수 있다.
    모든 정점으로부터 도착점 X 까지의 최단경로는
    역방향 간선을 따로 입력받아 X로 부터 모든 정점까지의 최단경로를 구하면 된다.
    이렇게 다익스트라를 2번만 수행해서 해결 할 수 있다.
 */
public class p1238_파티 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        ArrayList<Node>[] adj = new ArrayList[N + 1];
        ArrayList<Node>[] r_adj = new ArrayList[N + 1];
        int[] dist = new int[N + 1];
        int[] r_dist = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            r_adj[i] = new ArrayList<>();
            adj[i] = new ArrayList<>();
        }

        int s, e, t;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, t));
            r_adj[e].add(new Node(s, t));
        }

        dijkstra(X, adj, dist);
        dijkstra(X, r_adj, r_dist);

        int maxTime = 0;
        for(int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime , dist[i] + r_dist[i]);
        }

        System.out.println(maxTime);
    }
    static void dijkstra(int start, ArrayList<Node>[] adj, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;

            for(Node next : adj[cur.idx]) {
                if(dist[next.idx] > dist[cur.idx] + next.time) {
                    dist[next.idx] = dist[cur.idx] + next.time;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }


    static class Node implements Comparable<Node>{
        int idx;
        int time;

        public Node(int next, int time) {
            this.idx = next;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}