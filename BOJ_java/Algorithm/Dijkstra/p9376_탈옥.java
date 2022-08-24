package Algorithm.Dijkstra;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    BFS
    상근, 죄수1, 죄수2 각각 BFS를 돌려
    각 지점 별 최소 문 개방 횟수 저장.
    3개의 배열의 각 원소를 더한것 중 최소값이 정답
    만약, 그 위치에 문이 있었다면 -2 해준다.
 */
public class p9376_탈옥 {
    static char[][] map;
    static int H, W;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Point[] startPoints;

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H + 2][W + 2];

            int[][] dist1 = new int[H + 2][W + 2];
            int[][] dist2 = new int[H + 2][W + 2];
            int[][] dist3 = new int[H + 2][W + 2];

            startPoints = new Point[3];
            int k = 0;
            String line;
            for (int i = 1; i <= H; i++) {
                line = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = line.charAt(j - 1);
                    if(map[i][j] == '$') startPoints[k++] = new Point(j, i, 0);
                }
            }
            startPoints[2] = new Point(0, 0, 0);

            // 0 : 시작점 죄수1
            // 1 : 시작점 죄수2
            // 2 : 시작점 상근
            bfs(startPoints[0], dist1);
            bfs(startPoints[1], dist2);
            bfs(startPoints[2], dist3);

            System.out.println(getMin(dist1, dist2, dist3));
        }

    }

    static int getMin(int[][] dist1, int[][] dist2, int[][] dist3) {
        int minSum = Integer.MAX_VALUE;
        int sum;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if(map[i][j] == '*') continue;

                sum = dist1[i][j] + dist2[i][j] + dist3[i][j];
                if(map[i][j] == '#') {
                    sum -= 2;
                }
                minSum = Math.min(minSum, sum);
            }
        }
        return minSum;
    }

    static void bfs(Point start, int[][] dist) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] vst = new boolean[H + 2][W + 2];

        pq.add(start);
        int tx, ty;

        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            dist[cur.y][cur.x] = cur.cost;

            for(int i = 0; i < 4; i++) {
                tx = cur.x + dx[i];
                ty = cur.y + dy[i];

                if(check(tx, ty) || map[ty][tx] == '*' || vst[ty][tx]) continue;
                {
                    vst[cur.y][cur.x] = true;
                    pq.add(new Point(tx, ty, map[ty][tx] == '#' ? cur.cost + 1 : cur.cost));
                }
            }
        }
    }

    static boolean check(int x, int y) {
        return 0 > x || x > (W + 1) || 0 > y || y > (H + 1);
    }

    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
