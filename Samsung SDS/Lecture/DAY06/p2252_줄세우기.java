package Lecture.DAY06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2252_줄세우기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= N; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 앞학생의 인접리스트에 뒤학생 추가 -> 순서 규정
            adjList[from].add(to);

            // 뒤에 서야하는 학생 진입차수 + 1
            inDegree[to]++;
        }

        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int pollNode = queue.poll();
            for(int adjNode : adjList[pollNode]){
                if(--inDegree[adjNode] == 0)
                    queue.add(adjNode);
            }
            sb.append(pollNode + " ");
        }
        System.out.println(sb);
    }
}
