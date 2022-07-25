package DAY05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p1837_암호제작 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String c = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[K + 1];
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i * i <= K; i++){
            for (int j = i * i; j <= K; j += i) {
                isNotPrime[j] = true;
            }
        }

        int num = 0;
        int remain = 0;
        for(int i = 2; i < K; i++){
            if(isNotPrime[i] == false){
                for(int j = 0; j < c.length(); j++){
                    num = (int)c.charAt(i);
                    remain = num % i;
                }
            }
        }
    }
}
