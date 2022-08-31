import java.util.*;
import java.io.*;


public class Softeer_안전운전을도와줄차세대지능형교통시스템 {
    static int N, T;
    static int[][][] map;
    static boolean[][] vst;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<Integer>[] signal;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        signal = new ArrayList[13];
        for(int i = 1; i <= 12; i++) {
            signal[i] = new ArrayList<>();
        }
        // 0: 상, 1: 하, 2: 좌, 3: 우
        setSignal(1, 0, 1, 3);
        setSignal(2, 0, 2, 3);
        setSignal(3, 2, 0, 1);
        setSignal(4, 1, 2, 3);
        setSignal(5, 3, 0);
        setSignal(6, 0, 2);
        setSignal(7, 2, 1);
        setSignal(8, 1, 3);
        setSignal(9, 3, 1);
        setSignal(10, 0, 3);
        setSignal(11, 0, 2);
        setSignal(12, 1, 2);

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        vst = new boolean[N][N];
        map = new int[N][N][4];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[i][j][0] = Integer.parseInt(st.nextToken());
                map[i][j][1] = Integer.parseInt(st.nextToken());
                map[i][j][2] = Integer.parseInt(st.nextToken());
                map[i][j][3] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(vst[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        vst[0][0] = true;
        q.add(new Pos(0, 0, 0));

        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(cur.count == T) {
                continue;
            }

            int nowSignal = map[cur.y][cur.x][cur.count % 4];

            for(int dir : signal[nowSignal]) {
                System.out.print(nowSignal + " ");
                int tx = dx[dir] + cur.x;
                int ty = dy[dir] + cur.y;

                if(mapCheck(tx, ty) || vst[ty][tx]) continue;

                vst[ty][tx] = true;
                q.add(new Pos(tx, ty, cur.count + 1));
            }
            System.out.println();
        }
    }

    static boolean mapCheck(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    static void setSignal(int i, int a, int b, int c) {
        signal[i].add(a);
        signal[i].add(b);
        signal[i].add(c);
    }

    static void setSignal(int i, int a, int b) {
        signal[i].add(a);
        signal[i].add(b);
    }

    static class Pos {
        int x, y, count;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pos(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}