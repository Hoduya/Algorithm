package Class4.p1629_곱셈;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    지수 법칙: a ^ m+n = a^m * a^n
    모듈러 합동 공식: ( a * b ) % c = ( a % c * b % c ) % c
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long result = pow(a, b, c);
        System.out.println(result);
    }


    static long pow (long a, long exp, long mod) {
        if ( exp == 1 ) {
           return a % mod;
        }

        long temp = pow(a,exp / 2, mod);

        if (exp % 2 == 1) {
            return (temp * temp % mod) * a % mod;
        }

        return temp * temp % mod;
    }
}
