package Algorithm.LIS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이분 탐색 방법
// 최장증가부분수열의 길이뿐만 아니라 부분 수열 원소 모두 출력
/*
    증가 부분 수열 저장 방법
    - 새로운 P배열에 원소 배열의 원소가 LIS 배열의 어느 인덱스에 있는지 저장한다.
      P 배열에는 1 2 3 2 4 5 이런 식으로 저장되어 있을 텐데
      끝(5) 부터 처음 나타나는 값을 추적.
 */
public class p14003_가장긴증가하는부분수열5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];
        int[] p = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        LIS[0] = arr[0];
        p[0] = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > LIS[end]) { // 조건 1
                LIS[++end] = arr[i];
                p[i] = end;
            } else { // 조건 2
                int idx = getLowerBounds(LIS, end + 1, arr[i]);
                LIS[idx] = arr[i];
                p[i] = idx;
            }
        }

        System.out.println(end + 1);

        StringBuilder sb = new StringBuilder();
        int idx = end;
        int[] lis_final = new int[end + 1];
        for (int i = p.length - 1; i >= 0; i--) {
            if (p[i] == idx) {
                lis_final[idx] = arr[i];
                idx--;
            }
        }

        for (int element : lis_final) {
            sb.append(element + " ");
        }
        System.out.println(sb);
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
