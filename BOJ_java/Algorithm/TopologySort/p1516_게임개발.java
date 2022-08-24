package Algorithm.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1516_게임개발 {
    static int N, M;
    static ArrayList<Integer> adj[];
    static int[] inDegree;
    static int[] times;
    static int[] buildTimes;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        times = new int[N + 1];
        buildTimes = new int[N + 1];
        inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            times[i] = t;
            while(true) {
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                adj[next].add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                buildTimes[i] = times[i];
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : adj[cur]) {
                if(buildTimes[next] < buildTimes[cur] + times[next]) {
                    buildTimes[next] = buildTimes[cur] + times[next];
                }

                if(--inDegree[next] <= 0) {
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(buildTimes[i] + "\n");
        }
        System.out.println(sb);
    }
}
