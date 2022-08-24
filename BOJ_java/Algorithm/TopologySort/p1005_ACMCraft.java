package Algorithm.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1005_ACMCraft {
    static int[] inDegree;
    static int[] times, buildTimes;
    static ArrayList<Integer>[] adj;
    static int N, K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            times = new int[N + 1];
            buildTimes = new int[N + 1];
            inDegree = new int[N + 1];
            for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            int u, v;
            for(int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                inDegree[v]++;
            }

            int w = Integer.parseInt(br.readLine());
            System.out.println(topologySort(w));
        }
    }

    static int topologySort(int w) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                buildTimes[i] = times[i];
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == w) break;

            for(int next : adj[cur]) {
                if(buildTimes[next] < buildTimes[cur] + times[next])
                    buildTimes[next] = buildTimes[cur] + times[next];

                if(--inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return buildTimes[w];
    }
}