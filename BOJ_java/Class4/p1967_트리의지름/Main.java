package Class4.p1967_트리의지름;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static int max_dist, max_idx;
    static boolean[] vst;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        vst = new boolean[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int s, e, d;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, d));
            adj[e].add(new Node(s, d));
        }

        max_dist = 0;
        max_idx = 1;
        dfs(1, 0);

        Arrays.fill(vst, false);
        max_dist = 0;
        dfs(max_idx, 0);
        System.out.println(max_dist);
    }

    static void dfs (int cur, int dist) {
        vst[cur] = true;

        if (max_dist < dist) {
            max_dist = dist;
            max_idx = cur;
        }

        for(Node next : adj[cur]) {
            if(!vst[next.idx]){
                dist += next.dist;
                dfs(next.idx, dist);
                dist -= next.dist;
            }
        }
    }

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
