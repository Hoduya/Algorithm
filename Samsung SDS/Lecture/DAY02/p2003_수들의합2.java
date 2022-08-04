package Lecture.DAY02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

public class p2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, h = 0, sum = 0, count = 0;

        while(true){

            if(sum == M){
                count++;
                sum -= A[l++];
            }

            else if(sum > M){
                sum -= A[l++];
            }

            else{
                if(h == N) continue;
                sum += A[h++];
            }

            if(h == N && sum < M){
                break;
            }
        }

        System.out.println(count);
    }
}
