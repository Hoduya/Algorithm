package Lecture;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T_최소신장트리 {
    static int N, M, Q;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        edges = new Edge[M];

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        Arrays.sort(edges);

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        // 크루스칼
        int MAX_EDGE = N - 1; // 최소 간선
        int edgeCnt = 0;
        int[] weights = new int[MAX_EDGE];
        for (int i = 0; i < M; i++) {
            if(edgeCnt >= MAX_EDGE) break;

            if(!isSameParent(edges[i].u, edges[i].v)) {
                union(edges[i].u, edges[i].v);
                weights[edgeCnt] = edges[i].w;
                edgeCnt++;
            }
        }
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        arr[3] = 2;
        arr[4] = 2;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        getUpperIndex(arr, 2);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
        }
    }
    static void getUpperIndex(int[] arr, int n) {
        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        while(l < h) {
            mid = (l + h) / 2;
            if(arr[mid] >= n) h = mid;
            else l = mid + 1;
        }
        System.out.println(h);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y)
            parents[y] = x;
    }

    static int find(int x) {
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }
}
