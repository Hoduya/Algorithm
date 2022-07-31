package Lecture.DAY01.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3055_탈출 {
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, 1, -1};

    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;

    static class Point{
        int row, col;
        char type;

        public Point(int row, int col, char type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/DAY01/DFS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<Point>();

        Point start = null;
        // 맵 , 시작점, 도착지점 저장
        for(int row = 0; row < R; row++){
            String str = br.readLine();
            for(int col = 0; col < C; col++){
                map[row][col] = str.charAt(col);
                if( map[row][col] == '*'){
                    queue.add(new Point(row, col, '*'));
                } else if( map[row][col] == 'S'){
                    start = new Point(row, col, 'S');
                }
            }
        }
        queue.add(start);

        bfs();

        // countMap[dY][dX] 출력
    }

    // 매 분 마다 맵 업데이트
    static void mapUpdate(){
        // . 지역 상하좌우 -> *로
    }

    static void bfs(){
        // 1. 큐에서 꺼내옴 -> *, S, ., D
        // 2. 목적지인가? -> D
        // 3. 연결된 곳을 순회 -> 상하좌우
        // 4. 갈 수 있는가? (공통) : 맵안인지
        // 4. 갈 수 있는가? (고슴도치) : . or D, 방문하지 않은곳
        // 4. 갈 수 있는가? (물) : .
        // 5. 체크인 ( 고슴도치 ) : dp[][] = 이동거리
        // 5. 체크인 ( 물 ) : map[][] = *
        // 6. 큐에 넣음

    }
}
