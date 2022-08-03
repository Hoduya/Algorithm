package Class4.p2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        String line;
        for (int i = 1; i <= N; i++) {
            line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0' == 1 ? true : false;
            }
        }

        int result = bfs();
        if (result == 0) System.out.println(-1);
        else System.out.println(result);
    }

    static int bfs() {
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(1, 1, 1, false));
        int tx, ty;

        while(!q.isEmpty()) {
            Dot cur = q.poll();
            if(cur.x == M && cur.y == N) {
                return cur.count;
            }

            for(int i = 0; i < 4; i++) {
                tx = cur.x + dx[i];
                ty = cur.y + dy[i];

                if(1 <= tx && tx <= M && 1 <= ty && ty <= N) {
                    // visited
                    // 0 -> 아무도 방문 안함.
                    // 1 -> 한번도 부순 적 없는 사람이 방문
                    // 2 -> 한번 부순 적 있는 사람이 방문
                    if(visited[ty][tx] == 1) continue;

                    // 다음 길 막힘
                    if(map[ty][tx] == true) {
                        if (cur.breaking == true) { // 이미 한번 뿌셨다면
                            continue;
                        }
                        else {
                            q.add(new Dot(tx, ty, cur.count + 1,true));
                            visited[ty][tx] = 2;
                        }
                    }
                    // 다음 길 뚫림
                    else{
                        if(visited[ty][tx] == 2 && cur.breaking == true) continue;
                        else {
                            q.add(new Dot(tx, ty, cur.count + 1, cur.breaking));
                            visited[ty][tx] = cur.breaking ? 2 : 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    static class Dot {
        int x;
        int y;
        int count;
        boolean breaking;

        public Dot(int x, int y, int count, boolean breaking) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.breaking = breaking;
        }
    }
}
