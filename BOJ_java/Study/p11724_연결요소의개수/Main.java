package Study.p11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] vst;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vst = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList();
        }

        int a, b;
        while(0 < M--) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(vst[i] == true) continue;
            dfs(i);
            cnt++;
        }

        System.out.println(cnt);
    }
    static void dfs(int cur){
        vst[cur] = true;

        for(int next : adj[cur]) {
            if(!vst[next]) {
                dfs(next);
            }
        }
    }
}