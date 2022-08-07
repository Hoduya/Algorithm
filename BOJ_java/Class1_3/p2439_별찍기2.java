package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2439_별찍기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++) {
                if(j <= (n - i)) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}