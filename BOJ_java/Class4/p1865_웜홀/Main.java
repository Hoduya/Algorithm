package Class4.p1865_웜홀;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
    벨만-포드 알고리즘
 */

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] adj;
    static int dist[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        int N, M, W, S, E, T;
        while (0 < TC--) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            init(N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                adj[S].add(new Node(E, T));
                adj[E].add(new Node(S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                adj[S].add(new Node(E, -T));
            }


        }
    }
    static void bellmanFord() {

    }

    static void init(int N) {
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        Arrays.fill(dist, INF);
    }

    static class Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}


