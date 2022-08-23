package Algorithm.Dijkstra;

import com.sun.javaws.IconUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p10473_인간대포 {
    static Point[] canons;
    static ArrayList<Node>[] adj;
    static double[] dist;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double x, y;

        st = new StringTokenizer(br.readLine(), " ");
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        Point s = new Point(x, y);

        st = new StringTokenizer(br.readLine(), " ");
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        Point e = new Point(x, y);

        int canon_N = Integer.parseInt(br.readLine());
        canons = new Point[canon_N];
        for (int i = 0; i < canon_N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            canons[i] = new Point(x, y);
        }

        int N = canon_N + 2;
        dist = new double[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        // 그래프 생성 : 출발점 1, 도착점 N
        // 시간 = 거리 / 속도
        // 1) 시작 지점(s)에서 모든 대포와 도착점으로 걸어가는 경로
        for (int i = 0; i < canon_N; i++) { // 시작점 - 모든 대포
            double w = getDist(s, canons[i]) / 5;
            adj[1].add(new Node(i + 2, w));
        }
        adj[1].add(new Node(N, getDist(s, e) / 5)); // 시작점 - 도착점

        // 2) 모든 대포에서 모든 대포와 도착점으로 가는 경로
        for (int i = 0; i < canon_N - 1; i++) { // 모든 대포 - 모든 대포
            for (int j = i + 1; j < canon_N; j++) {
                double d = getDist(canons[i], canons[j]);
                double w = Math.min(Math.abs(d - 50), d) / 5 + 2;
                adj[i + 2].add(new Node(j + 2, w));
                adj[j + 2].add(new Node(i + 2, w));
            }
        }
        for (int i = 0; i < canon_N; i++) { // 모든 대포 - 도착점
            double d = getDist(canons[i], e);
            double w = Math.min(Math.abs(d - 50), d) / 5 + 2;
            adj[i + 2].add(new Node(N, w));
        }

        dijkstra();

        System.out.println(dist[N]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Double.MAX_VALUE);

        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.w > dist[cur.idx]) continue;

            for(Node next : adj[cur.idx]) {
                if(dist[next.idx] > dist[cur.idx] + next.w) {
                    dist[next.idx] = dist[cur.idx] + next.w;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }

    static double getDist(Point a, Point b) {
        double tmp1 = Math.pow((a.x - b.x), 2);
        double tmp2 = Math.pow((a.y - b.y), 2);
        return Math.sqrt(tmp1 + tmp2);
    }

    static class Node implements Comparable<Node>{
        int idx;
        double w;

        public Node(int idx, double w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.w - o.w);
        }
    }

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}