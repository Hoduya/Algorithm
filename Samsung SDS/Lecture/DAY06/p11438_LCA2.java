package Lecture.DAY06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p11438_LCA2 {
    static final int K = 17;
    static int N;
    static int[] depth;
    static boolean[] vst;
    static int[][] parents;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a, b;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        depth = new int[N + 1];
        vst = new boolean[N + 1];
        // 2^k 번째 조상을 담고있는 배열
        parents = new int[N + 1][K];

        // 1. 노드의 깊이 구하기
        calcDepth(1, 1);

        // 2. Parents(조상) 배열 채우기
        fillParents();

        // 3. LCA
        StringBuilder sb =  new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int lca = lca(a, b);
            sb.append(lca + "\n");
        }
        System.out.println(sb);
    }

    // dfs
    static void calcDepth(int cur, int count){
        vst[cur] = true;

        for(int next : adj[cur]){
            if(!vst[next]){
                depth[next] = count;
                // 부모 노드를 먼저 채운다.
                parents[next][0] = cur;
                calcDepth(next, count + 1);
            }
        }
    }

    static void fillParents(){
        for(int i = 1; i < K; i++){
            for(int j = 1; j <= N; j++){
                // j 노드의 i 번째 조상은 j 노드의 i - 1 번째 조상의 i - 1 번째 조상과 같다.
                // ex) 2번 노드의 2^2번째 조상은 2^1번째 조상의 2^1번째 조상.
                //      2^0 번째 조상을 이용해 다음 식으로 배열을 채워나감.
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }
    }

    static int lca(int a, int b){
        if(depth[a] < depth[b]){ // depth 큰 노드를 a로 설정
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 1. 두 노드의 depth 맞추기
        for(int i = K - 1; i >= 0; i--){
            if(Math.pow(2, i) <= depth[a] - depth[b]){
                a = parents[a][i];
            }
        }
        // 2. lca인지 확인
        if(a == b) return a;

        // 3. 공통 부모의 바로 아래까지 2승씩 올라감
        for(int i = K - 1; i >= 0; i--){
            // 공통 부모 부터 그 위는 항상 같은 노드
            // 부모 노드가 다르면 둘은 아직 도달하지 못한 것
            if(parents[a][i] != parents[b][i]){
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }
}
