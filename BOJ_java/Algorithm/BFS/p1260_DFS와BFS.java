package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1260_DFS와BFS {
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] vst;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        vst = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        StringBuilder sb = new StringBuilder();
        dfs(V, sb);
        System.out.println(sb);

        sb = new StringBuilder();
        Arrays.fill(vst, false);
        bfs(V, sb);
        System.out.println(sb);
    }

    static void dfs(int cur, StringBuilder result) {
        vst[cur] = true;
        result.append(cur + " ");

        for(int node : adj[cur]) {
            if (vst[node]) continue;
            dfs(node, result);
        }
    }

    static void bfs(int v, StringBuilder result) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        vst[V] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result.append(cur + " ");

            for(int node : adj[cur]) {
                if (vst[node]) continue;
                vst[node] = true;
                queue.add(node);
            }
        }
    }
}
