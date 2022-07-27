package SDS_Lecture.DAY02;

import java.io.*;
import java.util.StringTokenizer;

public class p1805_나무자르기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > max){
                max = Math.max(trees[i], max);
            }
        }

        long start = 0, end = max, mid, result = 0;

        while(start <= end){
            mid = (start + end) / 2;

            long sum = 0;
            // 자른 나무 길이 구하기
            for(int len : trees){
                if(len > mid) sum += (len - mid);
            }

            // 자른 나무가 많다
            if(sum > M){
                result = mid;
                start = mid + 1;
            }
            // 자른 나무가 적다
            else if(sum < M){
                end = mid - 1;
            }
            // 나무 딱 떨어짐
            else{
                result = mid;
                break;
            }
        }

        System.out.println(result);
    }
}
