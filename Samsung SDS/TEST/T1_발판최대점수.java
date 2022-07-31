package TEST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T1_발판최대점수 {
    static int N, M;
    static ArrayList<Node>[] adj;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        scores = new int[N];
        adj = new ArrayList[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList();
        }

        int s, e, type;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            type = Integer.parseInt(st.nextToken());
            if (type == 1)
                adj[s].add(new Node(e, scores[e], false));
            else {
                adj[s].add(new Node(e, scores[e], true));
                adj[e].add(new Node(s, scores[s], true));
            }
        }
    }

    static void dfs(){

    }

    static class Node{
        int idx;
        int score;
        boolean isBoth;

        public Node(int idx, int score, boolean isBoth){
            this.idx = idx;
            this.score = score;
            this.isBoth = isBoth;
        }
    }
}
