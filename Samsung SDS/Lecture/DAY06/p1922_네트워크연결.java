package Lecture.DAY06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1922_네트워크연결 {
    static int[][] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        edges = new int[M + 1][3];

        parent = makeSet(N);

        // 노드1, 노드2, 비용
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int count = 0;
        int totalCost = 0;
        for (int i = 1; i <= M; i++) {
            if(count == N - 1){
                break;
            }

            if(find(edges[i][0]) != find(edges[i][1])){
                count++;
                union(edges[i][0], edges[i][1]);
                totalCost += edges[i][2];
                System.out.println(edges[i][0] + " " + edges[i][1] + " " + edges[i][2]);
            }
        }

        System.out.println(totalCost);
    }
    static int[] makeSet(int size){
        int[] arr = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static void union(int x, int y){
        x = parent[x];
        y = parent[y];

        if(x != y){
            parent[y] = x;
        }
    }

    static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
