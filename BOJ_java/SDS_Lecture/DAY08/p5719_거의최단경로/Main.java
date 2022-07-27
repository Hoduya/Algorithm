package SDS_Lecture.DAY08.p5719_거의최단경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int S, D;
    static int[] dist;
    static boolean[][] removed;
    static ArrayList<Node>[] adj;
    static ArrayList<Integer>[] trace;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 || M == 0) break;

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            dist = new int[N];
            removed = new boolean[N][N];

            trace = new ArrayList[N];
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                trace[i] = new ArrayList<>();
            }

            int u, v, p;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                adj[u].add(new Node(v, p));
            }

            dijkstra(S);
            backTracking(D);
            dijkstra(S);

            if(dist[D] == INF) System.out.println(-1);
            else System.out.println(dist[D]);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.idx] < cur.w) continue;

            // 최단 경로 역추적을 위한 trace 배열
            // 경로가 a -> b 일 경우 trace[b].add(a)
            // 다음 노드 인덱스에 현재 노드를 추가하는 방식.
            for(Node next : adj[cur.idx]){
                // 지워진 경로라면 생략
                if(removed[cur.idx][next.idx]) continue;

                if(dist[next.idx] > dist[cur.idx] + next.w){
                    dist[next.idx] = dist[cur.idx] + next.w;

                    // 최단 경로 업데이트 시 trace 초기화 후, 새로운 역경로 추가
                    trace[next.idx].clear();
                    trace[next.idx].add(cur.idx);

                    pq.add(new Node(next.idx, dist[next.idx]));
                }
                // next 노드로 가는 최단 경로가 여러개일 수 있다.
                else if(dist[next.idx] == dist[cur.idx] + next.w){
                    trace[next.idx].add(cur.idx);
                }
                else{
                    continue;
                }
            }
        }
    }

    // 최단 경로의 역 경로를 담은 trace 배열을 탐색하면서 경로 지우기
    static void backTracking(int node){
        if(node == S){
            return;
        }

        for(int next : trace[node]){
            // 원래 경로는 trace 배열의 반대
            if(!removed[next][node]){
                removed[next][node] = true;
                backTracking(next);
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
