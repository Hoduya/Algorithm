package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2798_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i = 0; i < N-2; i++){
            for(int j = i + 1; j < N-1; j++){
                for(int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if(sum <= M && sum > max) max = sum;

                    if(M == max) break;
                }
            }
        }

        System.out.println(max);
    }
}
