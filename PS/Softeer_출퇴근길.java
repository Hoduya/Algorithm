import java.io.*;
import java.util.*;

public class Softeer_출퇴근길 {
    static int N, M, S, T;
    static ArrayList<Integer>[] adj;
    static boolean[] vst, tVst, sVst;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vst = new boolean[N + 1];
        sVst = new boolean[N + 1];
        tVst = new boolean[N + 1];

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dfs(S, T);
        sVst = vst.clone();
        Arrays.fill(vst, false);

        dfs(T, S);
        tVst = vst.clone();

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(i == S || i == T) continue;
            if(tVst[i] && sVst[i]) ans += 1;
        }

        System.out.println(ans);
    }

    static void dfs(int cur, int target) {
        vst[cur] = true;

        if(cur == target) {
            return;
        }

        for(int next: adj[cur]) {
            if(!vst[next]) {
                dfs(next, target);
            }
        }
    }
}
