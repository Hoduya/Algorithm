import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Softeer_지우는소수를좋아해 {
    static int N, M;
    static int minLevel;
    static ArrayList<Node>[] adj;
    static boolean[] vst;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vst = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, level));
            adj[v].add(new Node(u, level));
        }

//        System.out.println(minUpperPrimeNumber(2));;
        minLevel = Integer.MAX_VALUE;
        dfs(1, 0);

        System.out.println(minUpperPrimeNumber(minLevel));
    }

    static void dfs(int cur, int level) {
        vst[cur] = true;

        if(cur == N) {
            minLevel = Math.min(minLevel, level);
            return;
        }

        for(Node next : adj[cur]) {
            if (vst[next.idx] || next.level >= minLevel) {
                continue;
            }

            level = Math.max(level, next.level);

            dfs(next.idx, level);
            vst[next.idx] = false;
        }
    }

    static int minUpperPrimeNumber(int number) {
        while(!isPrime(number)) {
            number += 1;
        }
        return number;
    }

    static boolean isPrime(int number) {
        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    static class Node {
        int idx;
        int level;

        public Node(int idx, int level) {
            this.idx = idx;
            this.level = level;
        }
    }
}
