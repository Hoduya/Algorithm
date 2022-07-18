package SDSTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1_마당잔디깎기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()); // 세로
            int M = Integer.parseInt(st.nextToken()); // 가로
            int D = Integer.parseInt(st.nextToken()); // 일수

            int numOfGrass = N * M;
            long total = 0; // 총 깎은 양

            LinkedList<Grass> list_grass = new LinkedList<>(); // 잔디 길이 저장

            // 각 노드에 위치
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    list_grass.add(new Grass(Integer.parseInt(st.nextToken()), 0));
                }
            }

            // 내림차순 정렬
            Collections.sort(list_grass, new Comparator<Grass>() {
                @Override
                public int compare(Grass o1, Grass o2) {
                    return o2.length - o1.length;
                }
            });

            st = new StringTokenizer(br.readLine(), " ");
            for (int day = 1; day <= D; day++) {
                // 하루
                long daytTotal = 0;

                int K = Integer.parseInt(st.nextToken()); // 기름량

                // 깎은 양 계산 -> 첫번째 제거, 리스트 맨 뒤 1추가.
                for(int k = 0; k < K; k++){
                    int growLength = day - list_grass.getFirst().lastDay;
                    daytTotal += list_grass.getFirst().length + growLength - 1;
                    list_grass.remove();
                    list_grass.addLast(new Grass(1, day));
                }

                total += day * daytTotal;
            }

            sb.append("#" + (i + 1) + " " + total + "\n");
        }
        System.out.println(sb);
    }
}

class Grass{
    int length;
    int lastDay;

    public Grass(int length, int lastDay){
        this.length = length;
        this.lastDay = lastDay;
    }
}