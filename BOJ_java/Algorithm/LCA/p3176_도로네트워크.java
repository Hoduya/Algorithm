package Algorithm.LCA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p3176_도로네트워크 {
    static final int K = 17;
    static int N, M;
    static ArrayList<Node>[] adj;
    static int[][] parents;
    static int[][] maxDist;
    static int[][] minDist;
    static int[] depth;
    static int max, min;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1][K];
        maxDist = new int[N + 1][K];
        minDist = new int[N + 1][K];
        depth = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        dfs(1, 1);

        fillParents();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            lca(x, y);
            sb.append(min + " " + max + "\n");
        }

        System.out.println(sb);
    }

    static void lca(int x, int y) {
        max = 0;
        min = Integer.MAX_VALUE;

        if(depth[x] < depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        for(int i = K - 1; i >= 0; i--) {
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                max = Math.max(max, maxDist[x][i]);
                min = Math.min(min, minDist[x][i]);

                x = parents[x][i];
            }
        }

        if(x == y) {
            return;
        }

        for(int i = K - 1; i >= 0;i--) {
            if(parents[x][i] != parents[y][i]) {
                min = Math.min(Math.min(min, minDist[x][i]), minDist[y][i]);
                max = Math.max(Math.max(max, maxDist[x][i]), maxDist[y][i]);

                x = parents[x][i];
                y = parents[y][i];
            }
        }

        min = Math.min(Math.min(min, minDist[x][0]), minDist[y][0]);
        max = Math.max(Math.max(max, maxDist[x][0]), maxDist[y][0]);
    }

    // depth 계산
    static void dfs(int cur, int d) {
        depth[cur] = d;

        for(Node next : adj[cur]) {
            if(depth[next.idx] == 0) {
                dfs(next.idx, d + 1);
                parents[next.idx][0] = cur;
                minDist[next.idx][0] = next.w;
                maxDist[next.idx][0] = next.w;
            }
        }
    }

    static void fillParents() {
        for(int i = 1; i < K; i++) {
            for(int j = 1; j <= N; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];

                minDist[j][i] = Math.min(minDist[j][i - 1], minDist[parents[j][i - 1]][i - 1]);
                maxDist[j][i] = Math.max(maxDist[j][i - 1], maxDist[parents[j][i - 1]][i - 1]);
            }
        }
    }

    static class Node {
        int idx, w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }
}
