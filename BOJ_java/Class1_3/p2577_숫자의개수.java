package Class1_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2577_숫자의개수 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int n = a * b * c;
        while(n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(count[i] + "\n");
        }

        System.out.println(sb);
    }
}