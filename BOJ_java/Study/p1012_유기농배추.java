package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// dfs, bfs

public class p1012_유기농배추 {

    static int m, n, k;
    static int[][] field;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[m][n];
            visited = new boolean[m][n];
            count = 0;

            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            for(int x = 0; x < m; x++){
                for (int y = 0; y < n; y++){
                    if(field[x][y] == 1 && visited[x][y] == false){
                        dfs(x,y);
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx< m && cy < n){
                if(field[cx][cy] == 1 && visited[cx][cy] == false){
                    dfs(cx,cy);
                }
            }
        }
    }
}
