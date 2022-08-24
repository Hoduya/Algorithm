package Algorithm.TopologySort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    위상정렬
    : "순서가 정해져있는 작업"을 차례로 수행해야 할 때 그 순서를 결정해주기 위한 알고리즘
    - 사이클이 발생하는 그래프에서는 위상정렬을 사용할 수 없음
    - 진입차수가 0인 노드를 큐에 넣는다 -> 큐에서 노드를 꺼내 방문하고 인접노드의 진입차수를 --
 */

public class TopologySort {
    static int[] inDegree;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        for (int i = 1; i < N + 1; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            inDegree[b] += 1;
            adj[a].add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : adj[cur]) {
                if(--inDegree[next] == 0) {
                    q.add(next);
                }
            }
            sb.append(cur + " ");
        }

        System.out.println(sb);
    }
}
