package Algorithm.BellmanFord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1738_골목길 {
    static int INF = -Integer.MAX_VALUE;
    static int S, E;
    static int N, M;
    static int[] cost, path;
    static ArrayList<Integer> cycleNodes;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = 1;
        E = N;
        cost = new int[N + 1];
        path = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int u, v, w;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        if(bellmanFord() || cost[E] == INF) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> s = new Stack<>();
            int node = E;
            s.push(E);
            while(node != S) {
                node = path[node];
                s.push(node);
            }
            while(!s.isEmpty()) {
                sb.append(s.pop() + " ");
            }
            System.out.println(sb);
        }
    }

    static boolean bellmanFord() {
        Arrays.fill(cost, INF);
        cycleNodes = new ArrayList<>();

        boolean isCycle = false;
        boolean update = false;
        cost[1] = 0;
        for(int i = 0; i < M; i++) {
            update = false;
            for(int j = 1; j <= N; j++) {
                if(cost[j] == INF) continue;

                for(Node next : adj[j]) {
                    if(cost[next.idx] < cost[j] + next.w) {
                        cost[next.idx] = cost[j] + next.w;
                        path[next.idx] = j;

                        if(i == M - 1) {
                            cycleNodes.add(next.idx);
                        }

                        update = true;
                    }
                }
            }
            if(!update) return false;
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] vst = new boolean[N + 1];
        q.add(new Node(cycleNodes.get(0), 0));
        vst[cycleNodes.get(0)] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(Node next : adj[cur.idx]) {
                if(vst[next.idx]) continue;

                vst[next.idx] = true;
                q.add(new Node(next.idx, 0));
            }
        }

        if(vst[E]) return true;
        else return false;
    }

    static class Node {
        int idx, w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

}