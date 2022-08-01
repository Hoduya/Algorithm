package Solved.ac.C1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816_숫자카드2_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cardList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            cardList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardList);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cardList, key) - lowerBound(cardList, key) + " ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(key <= arr[mid]){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(key < arr[mid]){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}
