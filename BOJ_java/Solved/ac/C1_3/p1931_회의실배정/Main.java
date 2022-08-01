package Solved.ac.C1_3.p1931_회의실배정;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // 0은 시작, 1은 종료 시간
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시점을 기준으로 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같으면 시작 시간 오름차순으로
                if(o1[1] == o2[1]){
                    return o1[0] - o2[1];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int lastEnd = 0;
        for (int i = 0; i < N; i++) {
            if(time[i][0] >= lastEnd){
                lastEnd = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}