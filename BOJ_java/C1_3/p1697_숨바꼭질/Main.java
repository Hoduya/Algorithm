package C1_3.p1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    BFS 와 DP로 풀 수 있음
    BFS의 경우 최단 경로를 보장해주기 때문에
    해당 위치로 도달되었을때 count가 최소 이동 횟수가 된다.
 */
public class Main {
    static final int POS_MAX = 100000;
    static final int POS_MIN = 0;
    static int N, K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result;
        if (N == K) {
            result = 0;
        } else {
            result = bfs();
        }
        System.out.println(result);
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        int[] counts = new int[POS_MAX + 1]; // 최소이동거리 & 방문체크
        int[] tx = new int[3]; // 움직일 좌표 3개
        q.add(N);
        counts[N] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            tx[0] = cur + 1;
            tx[1] = cur - 1;
            tx[2] = cur * 2;

            for (int i = 0; i < 3; i++) {
                if (POS_MIN <= tx[i] && tx[i] <= POS_MAX) {

                    if (counts[tx[i]] != 0) continue;

                    counts[tx[i]] = counts[cur] + 1;

                    if(tx[i] == K){
                        return counts[tx[i]];
                    }

                    q.add(tx[i]);
                }
            }
        }
        return -1;
    }
}