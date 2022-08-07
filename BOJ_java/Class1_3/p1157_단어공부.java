package Class1_3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i);
            if(n >= 'a') n -= 'a';
            else n = n - 'A';
            count[n]++;
        }

        boolean twice = false;
        int max = 0;
        char maxChar = ' ';
        for (int i = 0; i < count.length; i++) {
            if(max < count[i]) {
                max = count[i];
                maxChar = (char) (i + 'A');
            }
            else if(count[i] == max) {
                maxChar = '?';
            }
        }

        System.out.println(maxChar);
    }
}
