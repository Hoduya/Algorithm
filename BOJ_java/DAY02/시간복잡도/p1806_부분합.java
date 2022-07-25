package DAY02.시간복잡도;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1806_부분합 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, h = 0, sum = 0, minLength = 0;

        while(true){
            if(sum >= M){
                minLength = Math.min(h - l + 1, minLength);
                sum -= nums[l++];
            } else {
                sum += nums[++h];
            }
            if(h == M) break;
        }
    }
}
