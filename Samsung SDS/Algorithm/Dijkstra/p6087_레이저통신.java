package Algorithm.Dijkstra;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p6087_레이저통신 {
    static final int INF = Integer.MAX_VALUE;

    static char[][] map;
    static int W, H;
    static Point S, E;
    static int counts[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        counts = new int[H][W];

        String line;
        ArrayList<Point> tmp = new ArrayList<>();
        for(int i = 0; i < H; i++) {
            line = br.readLine();
            for(int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'C') tmp.add(new Point(j, i, 0, 0));
            }
        }
        S = tmp.get(0);
        E = tmp.get(1);

        bfs();

        System.out.println(counts[E.y][E.x]);
    }
    static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < H; i++) Arrays.fill(counts[i], INF);

        pq.add(new Point(S.x, S.y, -1, -1));
        counts[S.y][S.x] = 0;

        while(!pq.isEmpty()) {
            Point cur = pq.poll();

            if(cur.count > counts[cur.y][cur.x]) continue;

            for(int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];

                if(check(tx, ty)) continue;

                // 방향을 꺾으면 count + 1
                int add = 0;
                if(i != cur.dir) add += 1;

                if(counts[ty][tx] >= cur.count + add) {
                    counts[ty][tx] = cur.count + add;
                    pq.add(new Point(tx, ty, counts[ty][tx], i));
                }
            }
        }
    }

    static boolean check(int x, int y) {
        return x < 0 || x >= W || y < 0 || y >= H || map[y][x] == '*';
    }

    static class Point implements Comparable<Point>{
        int x, y, count, dir;

        public Point(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }

        @Override
        public int compareTo(Point o) {
            return this.count - o.count;
        }
    }
}

