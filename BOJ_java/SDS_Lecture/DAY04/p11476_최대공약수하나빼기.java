package SDS_Lecture.DAY04;

import java.io.*;
import java.util.StringTokenizer;

public class p11476_최대공약수하나빼기 {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] frontGCDs = new int[N];
        int[] backGCDs = new int[N];
        frontGCDs[0] = nums[0];
        backGCDs[N - 1] = nums[N - 1];

        // gcd 배열 정방향 / 역방향 생성
        for (int i = 1; i < N; i++) {
            frontGCDs[i] = gcd(frontGCDs[i - 1], nums[i]);
            backGCDs[N - 1 - i] = gcd(backGCDs[N - i], nums[N - i - 1]);
        }
        int maxGCD = 0;
        int maxK = 0;
        for (int i = 0; i < N; i++) {
            int k = nums[i];
            int gcd = 0;
            // 하나 빼기
            if(i == 0){
                gcd = backGCDs[1];
            } else if(i == N - 1){
                gcd = frontGCDs[N - 1];
            } else{
                gcd = gcd(frontGCDs[i - 1], backGCDs[i + 1]);
            }

            if(nums[i] % gcd != 0 && gcd > maxGCD) {
                maxGCD = gcd;
                maxK = nums[i];
            }
        }

        if(maxGCD == 0){
            System.out.println(-1);
        } else{
            System.out.println(maxGCD + " " + maxK);
        }
    }

    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
