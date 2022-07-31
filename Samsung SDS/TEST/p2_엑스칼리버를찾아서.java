package TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int row;
    int col;
}

public class p2_엑스칼리버를찾아서 {
    static int[][] map;
    static int N, M;
    static int[] Gto_, _toS;

    static boolean[] visited_p;
    static int[] list;
    static int[] path;
    static int[][] distGraph; // ABC 인접행렬
    static int minDistance;

    public static void main(String[] args) throws IOException {
        Point G, A, B, C, S;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int testCnt = 0;

        G = new Point(); A = new Point(); B = new Point();
        C = new Point(); S = new Point();

        while(T-- > 0){

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int R = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            G.row = R - 1;
            G.col = K - 1;

            map = new int[N][M];
            // map (0:평지, 1:산)
            for(int row = 0; row < N; row++){
                String s = br.readLine();
                for(int col = 0; col < M; col++){
                    map[row][col] = 0;
                    if(s.charAt(col) == 'X') map[row][col] = 1;
                    if(s.charAt(col) == 'A') { A.row = row; A.col = col; }
                    if(s.charAt(col) == 'B') { B.row = row; B.col = col; }
                    if(s.charAt(col) == 'C') { C.row = row; C.col = col; }
                    if(s.charAt(col) == 'S') { S.row = row; S.col = col; }
                }
            }

            //bfs
            // 시작점으로 부터 A B C까지 최단 거리
            Point[] points = new Point[]{A, B, C};
            int[] resultArr = new int[3];
            resultArr = bfs(G,points);
            int GA = resultArr[0];
            int GB = resultArr[1];
            int GC = resultArr[2];
            Gto_ = new int[]{GA, GB, GC};
            // A부터 B C 까지 최단 거리
            points = new Point[]{B, C};
            resultArr = bfs(A,points);
            int AB = resultArr[0];
            int AC = resultArr[1];
            // B와 C 최단 거리
            points = new Point[]{C};
            resultArr = bfs(B,points);
            int BC = resultArr[0];

            // A B C 인접 행렬
            distGraph = new int[3][3];
            putEdge(0,1, AB);
            putEdge(0,2, AC);
            putEdge(1,2, BC);

            // A B C 부터 왕궁까지 거리
            int AS = Math.abs(S.row - A.row) + Math.abs(S.col - A.col);
            int BS = Math.abs(S.row - B.row) + Math.abs(S.col - B.col);
            int CS = Math.abs(S.row - C.row) + Math.abs(S.col - C.col);
            _toS = new int[]{AS, BS, CS};

            // A B C 순열
            list = new int[]{0, 1, 2};
            path = new int[list.length];
            visited_p = new boolean[list.length];

            minDistance = Integer.MAX_VALUE;
            permutation(0);

            sb.append("#" + (++testCnt) + " " + minDistance + "\n");
        }
        System.out.println(sb);
    }
    public static void putEdge(int x, int y, int dist){
        distGraph[x][y] = dist;
        distGraph[y][x] = dist;
    }

    public static void permutation(int idx){
        if(idx == list.length){
            int dist = 0;

            for(int i = 0; i < list.length - 1; i++){
                dist += distGraph[path[i]][path[i + 1]];
            }
            dist += Gto_[path[0]] + _toS[path[list.length - 1]];

            if(dist < minDistance){
                minDistance = dist;
            }
        }

        for(int i = 0; i < list.length; i++){
            if(visited_p[i] == true) continue;

            path[idx] = list[i];
            visited_p[i] = true;

            permutation(idx + 1);
            visited_p[i] = false;
        }
    }

    public static boolean[][] visited;
    public static int[] bfs(Point startPoint, Point[] points){
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];
        int N = points.length;
        int foundN = 0;
        int[] results = new int[N]; // 각 점 최단거리 저장

        queue.add(new int[]{startPoint.row, startPoint.col, 0}); // 시작점, 거리

        while(!queue.isEmpty()){
            int[] curr = queue.remove();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if(visited[r][c] == true) continue;
            visited[r][c] = true;

            // 시작 노드로부터 points까지의 최단 거리
            for(int i = 0; i < N; i++){
                if(r == points[i].row && c == points[i].col){ results[i] = dist; foundN++;}
            }
            if(foundN == N) break;

            // 상
            if(check(r - 1, c)) queue.add(new int[]{r - 1, c, dist + 1});
            // 하
            if(check(r + 1, c)) queue.add(new int[]{r + 1, c, dist + 1});
            // 좌
            if(check(r, c - 1)) queue.add(new int[]{r, c - 1, dist + 1});
            // 우
            if(check(r, c + 1)) queue.add(new int[]{r, c + 1, dist + 1});
        }

        return results;
    }

    public static boolean check(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= M) return false;
        if(map[row][col] == 1) return false;
        if(visited[row][col]) return false;
        return true;
    }
}





