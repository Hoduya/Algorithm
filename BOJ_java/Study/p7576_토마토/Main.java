package Study.p7576_토마토;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[][] box;
    static boolean[][] vst;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int minDay = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][W];
        vst = new boolean[H][W];
        ArrayList<Dot> ones = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    ones.add(new Dot(j, i));
                }
            }
        }
        bfs(ones);
    }

    static void bfs(ArrayList<Dot> ones) {
        Queue<Dot> q = new LinkedList<>();
        for (Dot one : ones) {
            q.add(one);
        }

        while(!q.isEmpty()) {
            Dot cur = q.poll();

            for(int i = 0; i < 4; i++) {

                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];

                if (0 <= tx && tx < W && 0 <= ty && ty < H) {
                    if (box[ty][tx] == 0) {
                        q.add(new Dot(tx, ty));
                        box[ty][tx] = box[cur.y][cur.x] + 1;
                    }
                }
            }
        }

        if(checkAll()) {
            System.out.println(minDay - 1);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkAll(){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(box[i][j] == 0)
                    return false;
                minDay = Math.max(minDay, box[i][j]);
            }
        }
        return true;
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
