package Class1_3.p9095_123더하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[10 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 10; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (0 < TC--) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num] + "\n");
        }
        System.out.println(sb);
    }
}