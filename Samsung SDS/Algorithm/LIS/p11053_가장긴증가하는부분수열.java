package Algorithm.LIS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이분 탐색 방법
public class p11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> LIS = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int e = 0;
        LIS.add(0);
        for(int i = 0; i < N; i++) {
            if(arr.get(i) > LIS.get(e) ) { // 조건 1
                LIS.add(arr.get(i));
                e++;
            }
            else { // 조건 2
                int idx = getLowerBounds(LIS, arr.get(i));
                LIS.set(idx, arr.get(i));
            }
        }

        System.out.println(e);
    }

    static int getLowerBounds(ArrayList<Integer> arr, int val) {
        int l = 0;
        int h = arr.size() - 1;
        int mid;
        while(l < h) {
            mid = l + ( h - l ) / 2;
            if(arr.get(mid) >= val) h = mid;
            else l = mid + 1;
        }
        return l;
    }
}
