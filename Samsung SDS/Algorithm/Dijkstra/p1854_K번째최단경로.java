package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1854_K번째최단경로 {
    static PriorityQueue<Integer> dist[];
    static int N, M, K;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new PriorityQueue[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        find();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(dist[i].size() == K) {
                sb. append(dist[i].peek() +"\n");
            } else {
                sb.append("-1\n");
            }
        }

        System.out.println(sb);
    }

    // 다익스트라
    // 최단경로를 여러번 찾아야 하기 때문에 방문 체크는 하지 않는다.
    // 비용갱신 배열은 우선순위큐(내림차순) 배열을 이용한다.
    static void find() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1].add(0);

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(Node next : adj[cur.idx]) {
                if(dist[next.idx].size() < K) {
                    dist[next.idx].add(cur.w + next.w);
                    pq.add(new Node(next.idx, cur.w + next.w));
                }
                else if (dist[next.idx].peek() > cur.w + next.w) {
                    dist[next.idx].poll();
                    dist[next.idx].add(cur.w + next.w);

                    pq.add(new Node(next.idx, cur.w + next.w));
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