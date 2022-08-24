package Algorithm.LIS;

/*
    최장 증가 부분 수열

    Type 1) DP 방법
            : DP 배열에서 이전 원소 중 자신보다 수가 작고 최대 DP 값을 갖는 것의 DP 값 + 1
             시간 복잡도 : O ( N^2 )

    Type 2) 이분탐색 방법
            : LIS 배열을 생성.
              원소가 LIS 배열의 end 값보다 크면 PUSH,
              그렇지 않으면 이분 탐색으로 Lower Bound를 찾아 값을 바꾼다.
              시간 복잡도 : O( N Log N )
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분 탐색 방법
public class LIS {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        LIS[0] = arr[0];
        // 조건
        // 1. 현재 원소가 LIS 배열의 end 보다 크면 push
        // 2. 현재 원소가 end값 이하면 lowerbound에 대입
        for(int i = 1; i < N; i++) {
            if(arr[i] > LIS[end]) { // 조건 1
                LIS[++end] = arr[i];
            }
            else { // 조건 2
                int idx = getLowerBounds(LIS, end + 1, arr[i]);
                LIS[idx] = arr[i];
            }
        }

        for (int element : LIS) {
            System.out.print(element + " ");
        }

        System.out.println(end + 1);
    }

    static int getLowerBounds(int[] arr, int size, int val) {
        int l = 0;
        int h = size - 1;
        int mid;
        while(l < h) {
            mid = l + ( h - l ) / 2;
            if(arr[mid] >= val) h = mid;
            else l = mid + 1;
        }
        return l;
    }
}
