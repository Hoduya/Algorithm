package Algorithm.KruskalAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    크루스칼 알고리즘
    그래프 내의 모든 정점들을 가장 적은 비용으로 연결하는 최소신장트리(MST)를 찾기 위한 알고리즘
    간선을 가중치를 기준으로 정렬하고, 유니온 파인드를 이용하여 사이클이 발생하지 않도록
    정점들을 연결한다.
 */

public class KruskalAlgorithm {
    static int N, M;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        edges = new Edge[M];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        Arrays.sort(edges);

        int x, y;
        int minCost = 0;
        for(int i = 0; i < M; i++) {
            x = edges[i].u;
            y = edges[i].v;

            if(!(find(x) == find(y))) {
                union(x, y);
                minCost += edges[i].w;
            }
        }
        System.out.println(minCost);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) parents[y] = x;
    }

    static int find(int x) {
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static class Edge implements Comparable<Edge>{
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
