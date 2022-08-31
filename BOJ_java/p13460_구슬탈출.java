import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p13460_구슬탈출 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] vst;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int rX = 0, rY = 0, bX = 0, bY = 0;
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'R') {
                    rX = j;
                    rY = i;
                }

                if(map[i][j] == 'B') {
                    bX = j;
                    bY = i;
                }
            }
        }

        int result = bfs(rX, rY, bX, bY);

        System.out.println(result);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<Ball> q = new LinkedList<>();
        vst = new boolean[N][M][N][M];
        vst[ry][rx][by][bx] = true;
        q.add(new Ball(rx, ry, bx, by, 0));

        int rtx, rty, btx, bty;
        while(!q.isEmpty()) {
            Ball cur = q.poll();
            if(cur.count >= 10) break;

            // 상 하 좌 우 굴리기.
            for(int i = 0; i < 4; i++) {
                rtx = cur.rx;
                rty = cur.ry;
                btx = cur.bx;
                bty = cur.by;
                boolean isRedFin = false;
                boolean isBlueFin = false;

                // 빨간구슬 굴리기
                while(map[rty + dy[i]][rtx + dx[i]] != '#') {
                    rtx += dx[i];
                    rty += dy[i];

                    if(map[rty][rtx] == 'O') {
                        isRedFin = true;
                        break;
                    }
                }

                // 파란구슬 굴리기
                while(map[bty + dy[i]][btx + dx[i]] != '#') {
                    btx += dx[i];
                    bty += dy[i];

                    if(map[bty][btx] == 'O') {
                        isBlueFin = true;
                        break;
                    }
                }
                // 파란 구슬이 구멍을 빠져나오는 경로는 pass
                if(isBlueFin) continue;
                // 빨간 구슬만 구멍을 빠져나오게 되면 탐색 종료. (최단 경로임)
                if(isRedFin) {
                    return cur.count + 1;
                }

                // 구슬의 위치가 같은 경우
                // 굴렸던 방향을 기준으로 빨간, 파란 구슬의 굴리기 전 위치를 이용해
                // 어떤 구슬이 뒤에 있어야 하는지 정한다.
                if(rtx == btx && rty == bty) {
                    if(i == 0) { // 상
                        if(cur.by > cur.ry) bty += 1;
                        else rty += 1;
                    } else if (i == 1) { // 하
                        if(cur.by < cur.ry) bty -= 1;
                        else rty -= 1;
                    } else if (i == 2) { // 좌
                        if(cur.bx > cur.rx) btx += 1;
                        else rtx += 1;
                    } else { // 우
                        if(cur.bx < cur.rx) btx -= 1;
                        else rtx -= 1;
                    }
                }


                if(!vst[rty][rtx][bty][btx]) {
                    vst[rty][rtx][bty][btx] = true;
                    q.add(new Ball(rtx, rty, btx, bty, cur.count + 1));
                }
            }
        }
        return -1;
    }

    static class Ball {
        int rx, ry;
        int bx, by;
        int count;

        public Ball(int rX, int rY, int bX, int bY, int count) {
            this.rx = rX;
            this.ry = rY;
            this.bx = bX;
            this.by = bY;
            this.count = count;
        }
    }
}