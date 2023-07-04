package Algorithm.Dijkstra;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int dist[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int s, e, t;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, t));
        }

        dijkstra(1, 2);

    }
    static int dijkstra(int start, int end) {
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

        return dist[end];
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