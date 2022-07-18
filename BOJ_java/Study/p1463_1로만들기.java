package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463_1로만들기 {
    static int n, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        count = 0;
        div();
    }

    public static void div(){
        if(n == 1){
            return;
        }
        int rem = n % 3;
        if(rem == 0){
            n /= 3;
        }else if(rem == 1){
            n-= 1;
        }else{
            n /= 2;
        }
        count++;
        div();
    }
}
