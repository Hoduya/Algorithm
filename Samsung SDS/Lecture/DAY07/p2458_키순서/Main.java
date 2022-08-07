package Lecture.DAY07.p2458_키순서;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean isConnected[][];
    static boolean[] vst;
    static int N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isConnected = new boolean[N + 1][N + 1];
        vst = new boolean[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        ArrayList<Integer>[] r_adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            r_adj[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            r_adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i, adj);
            bfs(i, r_adj);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            count += 1;
            for (int j = 1; j <= N; j++) {
                if(isConnected[i][j] == false) {
                    count -= 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(int s, ArrayList<Integer>[] adj) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(vst, false);
        q.add(s);

        while(!q.isEmpty()) {
            int cur = q.poll();
            isConnected[s][cur] = true;

            for(int next : adj[cur]) {
                if(!vst[next]) {
                    vst[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
