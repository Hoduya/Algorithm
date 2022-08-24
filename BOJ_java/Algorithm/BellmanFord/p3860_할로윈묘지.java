package Algorithm.BellmanFord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p3860_할로윈묘지 {
    static final Long INF = Long.MAX_VALUE;
    static int W, H, N;
    static long[][] dist;
    static int[][] map;
    static ArrayList<Edge> edges;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 || H == 0) break;

            dist = new long[H][W];
            map = new int[H][W];
            edges = new ArrayList<>();

            // 묘비 위치에 -1
            int G = Integer.parseInt(br.readLine());
            for(int i = 0; i < G; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = -1;
            }

            // 포탈 설정
            int E = Integer.parseInt(br.readLine());
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int fromX = Integer.parseInt(st.nextToken());
                int fromY = Integer.parseInt(st.nextToken());
                int toX = Integer.parseInt(st.nextToken());
                int toY = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                map[fromY][fromX] = 1;
                edges.add(new Edge(new Point(fromX, fromY), new Point(toX, toY), w));
            }

            // 간선 리스트 생성
            int tx, ty;
            for(int y = 0; y < H; y++) {
                for(int x = 0; x < W; x++) {

                    if(map[y][x] != 0) continue;
                    if(x == W - 1 && y == H - 1) continue;

                    for(int i = 0; i < 4; i++) {
                        tx = dx[i] + x;
                        ty = dy[i] + y;

                        if(check(tx, ty) && map[ty][tx] != -1) {
                            edges.add(new Edge(new Point(x, y), new Point(tx, ty), 1));
                        }
                    }
                }
            }

            if(bellmanFord()) {
                sb.append("Never" + "\n");
            } else {
                if(dist[H - 1][W - 1] == INF) sb.append("Impossible" + "\n");
                else sb.append(dist[H - 1][W - 1] + "\n");
            }
        }
        System.out.println(sb);
    }

    static boolean bellmanFord() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                dist[i][j] = INF;
            }
        }

        // 출발 노드
        dist[0][0] = 0;
        N = W * H;
        boolean update;

        for (int i = 0; i < N - 1; i++) {
            update = false;

            for(Edge edge : edges) {
                Point s = edge.s;
                Point e = edge.e;

                if(dist[s.y][s.x] == INF) continue;

                if(dist[e.y][e.x] > dist[s.y][s.x] + edge.w)
                    dist[e.y][e.x] = dist[s.y][s.x] + edge.w;
                    update = true;
            }

            if(!update) break;
        }

        for(Edge edge : edges) {
            int sx = edge.s.x;
            int sy = edge.s.y;
            int ex = edge.e.x;
            int ey = edge.e.y;

            if(dist[sy][sx] == INF) continue;

            if(dist[ey][ex] > dist[sy][sx] + edge.w)
                return true;
        }

        return false;
    }
    static boolean check(int x, int y) {
        return 0 <= x && x < W && 0 <= y && y < H;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        Point s, e;
        int w;

        public Edge(Point s, Point e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}