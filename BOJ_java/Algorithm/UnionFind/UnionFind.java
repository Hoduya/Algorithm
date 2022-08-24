package Algorithm.UnionFind;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnionFind {
    static int parents[];
    static int N, M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int command, a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                sb.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }
        System.out.println(sb);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y)
            parents[y] = x;
    }

    static int find(int x) {
        if(parents[x] == x){
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}


