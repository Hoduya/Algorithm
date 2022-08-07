package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        int n;
        for(int i = 0; i < 5; i++) {
            n = Integer.parseInt(st.nextToken());
            result += n * n;
        }
        System.out.println(result % 10);
    }
}