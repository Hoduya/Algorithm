package DAY06;

import java.io.*;
import java.util.StringTokenizer;

public class p1717_집합의표현 {
    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                sb.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static int find(int x) {
        return parent[x] = (x == parent[x]) ? x :find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}

