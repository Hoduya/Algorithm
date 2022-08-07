package Algorithm.UnionFind;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976_여행가자 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                if(st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        int[] travleList = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            travleList[i] = Integer.parseInt(st.nextToken());
        }

        boolean isSame = true;
        for (int i = 0; i < M - 1; i++) {
            if(!isSameParents(travleList[i], travleList[i + 1])){
                isSame = false;
                break;
            }
        }
        System.out.println(isSame ? "YES" : "NO");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            parents[y] = x;
        }
    }

    static int find(int x) {
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static boolean isSameParents(int x, int y) {
        return find(x) == find(y);
    }
}
