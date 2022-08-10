package Algorithm.BellmanFord;
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

public class p1865_웜홀 {
    static final int INF = 987654321;
    static ArrayList<Node>[] adj;
    static int dist[];
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        int M, W, S, E, T;
        while (0 < TC--) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            adj = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());

                if (i < M) {
                    adj[S].add(new Node(E, T));
                    adj[E].add(new Node(S, T));
                } else {
                    adj[S].add(new Node(E, -T));
                }
            }

            if(bellmanFord()) sb.append("Yes" + "\n");
            else sb.append("No" + "\n");
        }
        System.out.println(sb);
    }

    static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean isUpdate = false;

        for (int i = 0; i < N; i++) {
            isUpdate = false;

            for (int cur = 1; cur <= N; cur++) {
                for (Node next : adj[cur]) {
                    if(dist[next.idx] > next.time + dist[cur]) {
                        dist[next.idx] = next.time + dist[cur];
                        isUpdate = true;
                    }
                }
            }
        }
        return isUpdate;
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


