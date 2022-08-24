package Algorithm.LCA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    Lowest Common Ancestor
    : 트리 구조에서 임의의 두 정점이 갖는 가장 가까운 조상 정점.

 */
public class LCA {
    static final int K = 17;
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[][] parents;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1][K];
        depth = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        // 1. 각 노드의 깊이 계산
        calcDepth(1,1);

        // 2. parents 배열 채우기 (DP)
        //   임의의 노드의 2^k 번째 조상은 2^k-1 조상의 2^k-1 조상.
        for (int i = 1; i < K; i++) {
            for(int j = 1; j <= N; j++) {
                parents[j][i] = parents[parents[j][i-1]][i - 1];
            }
        }

        // 3. 두 노드의 최소공통조상(LCA) 찾기
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int result = lca(x , y);
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    static int lca(int x, int y) {
        // depth가 큰 노드를 x로
        if(depth[x] < depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        // depth 맞추기
        for (int i = K - 1; i >= 0; i--) {
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                x = parents[x][i];
            }
        }

        if(x == y) return x;

        // 두 노드를 공통 조상 바로 아래까지 올린다.
        // 공통 조상 노드부터 그 위는 모두 같은 노드.
        for (int i = K - 1; i >= 0; i--) {
            if(parents[x][i] != parents[y][i]) {
                x = parents[x][i];
                y = parents[y][i];
            }
        }

        return parents[x][0];
    }

    static void calcDepth(int cur, int d) {
        depth[cur] = d;

        for(int next : adj[cur]) {
            if(depth[next] == 0) {
                calcDepth(next, d + 1);
                parents[next][0] = cur; // next 의 2^0 번째 조상은 cur
            }
        }
    }
}
