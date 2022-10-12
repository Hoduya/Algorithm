package 배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
    }
}

class Solution {
    int dist[];
    ArrayList<Node>[] adj;

    public int solution(int N, int[][] road, int k) {
        dist = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        dijkstra();
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= k) result++;
        }

        return result;
    }

    void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > dist[cur.idx]) continue;

            for(Node next : adj[cur.idx]) {
                if (dist[next.idx] > dist[cur.idx] + next.w) {
                    dist[next.idx] = dist[cur.idx] + next.w;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int idx;
    int w;

    public Node(int idx, int w) {
        this.idx = idx;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}
