package Algorithm.LCA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3830_교수님은기다리지않는다 {
    static int[] p;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N, M ,a, b, w;
        String command;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 || M == 0) break;

            p = new int[N + 1];
            dist = new int[N + 1];
            Arrays.fill(p , -1);
            Arrays.fill(dist , 0);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                command = st.nextToken();

                if(command.equals("!")) {
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    w = Integer.parseInt(st.nextToken());

                    union(a, b, w);
                }

                else {
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());

                    if(find(a) != find(b)) {
                        sb.append("UNKNOWN" + "\n");
                    } else {
                        sb.append(dist[b] - dist[a] + "\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static void union(int x, int y, int w) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return;

        dist[rootY] = dist[x] - dist[y] + w;
        p[rootY] = rootX;

        return;
    }

    static int find(int x) {
        if(p[x] == -1) return x;

        int parent = find(p[x]);
        dist[x] += dist[p[x]];
        return p[x] = parent;
    }
}
