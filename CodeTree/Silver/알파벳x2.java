package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳x2 {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean[] vst = new boolean[26];
        int[] counts = new int[26];
        int result = 0;

        for(int i = 0; i < str.length(); i++) {
            char first = str.charAt(i);
            int index = first - 'A';
            if(vst[index]) continue;
            vst[index] = true;

            Arrays.fill(counts, 0);
            for(int j = i + 1; j < str.length(); j++) {
                char next = str.charAt(j);
                if(first == next) break;
                counts[next - 'A']++;
            }
            result += check(counts);
        }
        System.out.println(result / 2);
    }

    static int check(int[] counts) {
        int lineCount = 0;
        for(int count : counts) {
            if(count == 1) {
                lineCount += 1;
            }
        }
        return lineCount;
    }
}
