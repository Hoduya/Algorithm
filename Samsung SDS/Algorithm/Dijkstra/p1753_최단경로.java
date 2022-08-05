package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1753_최단경로 {
    static ArrayList<Node>[] edges;
    static int V, E;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

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

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        int S = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Node(v,w));
        }

        Arrays.fill(dist, INF);

        dijkstra(S);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 출발 노드 설정
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()){
            // 방문하지 않은 노드 중 최소비용 노드에 방문
            Node cur = pq.poll();

            // 최신화된 비용보다 크면 가볼 필요가 없음
            if(dist[cur.idx] < cur.w){
                continue;
            }

            // 인접 노드를 탐색
            for(Node adj : edges[cur.idx]){
                // 현재 노ㅁ드를 거쳤을 때 거리가 더 작다면, 갱신
                if(dist[adj.idx] > dist[cur.idx] + adj.w){
                    dist[adj.idx] = dist[cur.idx] + adj.w;
                    pq.add(new Node(adj.idx, dist[adj.idx]));
                }
            }
        }
    }
}
