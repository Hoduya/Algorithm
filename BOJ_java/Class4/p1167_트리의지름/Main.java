package Class4.p1167_트리의지름;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    트리의 지름
    : 임의의 한 정점에서 가장 먼 정점 x 일 때
      x로 부터 가장 먼 정점이 y 라면, x - y 가 트리의 지름이다.
 */
public class Main {
    static int N;
    static ArrayList<Node>[] adj;
    static boolean[] vst;
    static int maxDist, maxIDX;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        vst = new boolean[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int s, e, d;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            while(true) {
                e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                d = Integer.parseInt(st.nextToken());
                adj[s].add(new Node(e,d));
            }
        }

        maxDist = 0;
        maxIDX = 0;
        dfs(1, 0);

        Arrays.fill(vst, false);
        maxDist = 0;
        dfs(maxIDX, 0);
        System.out.println(maxDist);
    }

    static void dfs(int cur, int dist){
        vst[cur] = true;
        if (maxDist < dist) {
            maxDist = dist;
            maxIDX = cur;
        }
        for(Node next : adj[cur]) {
            if(!vst[next.idx]) {
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