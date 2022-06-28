package SDSTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4_지하철환승 {
    static final int STATION = 10001;
    static final int LINE = 1001;
    static final int INF = 1987654321;
    static int N, M, S, E;
    static int[] cntPerLine;
    static ArrayList<Integer> line[]; // 노선별로 지하철 번호 저장
    static ArrayList<Integer> station[]; // 지하철별로 노선 저장
    static int[] transferCount;
    static boolean[] visited;

    static void init(){
        station = new ArrayList[STATION];
        transferCount = new int[STATION];
        line = new ArrayList[LINE];
        visited = new boolean[LINE];

        for(int i = 0; i < STATION; i++){
            station[i] = new ArrayList<>();
            transferCount[i] = INF;
        }
        for(int i = 0; i < LINE; i++){
            line[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t < T + 1; t++){
            init();

            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            cntPerLine = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++){
                cntPerLine[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < cntPerLine[i]; j++){
                    int stationNumber = Integer.parseInt(st.nextToken());
                    line[i].add(stationNumber);
                    station[stationNumber].add(i);
                }
            }

            bfs();

            if(transferCount[E] == INF) sb.append("#" + t + " " + "-1\n");
            else sb.append("#" + t + " " + transferCount[E] + "\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        transferCount[S] = -1;
        while(!q.isEmpty()){
            int cur = q.remove();

            for(int adjLine : station[cur]){
                if(visited[adjLine]) continue;
                visited[adjLine] = true;

                for(int adjStation : line[adjLine]){
                    if(transferCount[adjStation] == INF){
                        transferCount[adjStation] = transferCount[cur] + 1;
                        q.add(adjStation);
                    }
                }
            }
        }
    }
}

