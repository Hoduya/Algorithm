package Lecture.DAY02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2143_두배열의합 {
    static int T;
    static int[] A, B;
    static List subA, subB;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1. Sub A, Sub B 의 합 배열 구하기.
        subA = new ArrayList<Integer>();
        subB = new ArrayList<Integer>();



        // 2. 정렬하기 subA는 오름차순, subB는 내림차순
        Collections.sort(subA);
        Collections.sort(subB, Collections.reverseOrder());

        System.out.println(subA);
        // 3. two 포인터로 부분합 계산
        twoPointer();

    }


    static void twoPointer(){
        int ptA = 0; //subA 포인터
        int ptB = 0; //subB 포인터


    }
}
