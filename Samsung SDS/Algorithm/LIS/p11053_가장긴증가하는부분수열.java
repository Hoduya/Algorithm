package Algorithm.LIS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분 탐색 방법
public class p11053_가장긴증가하는부분수열 {
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
