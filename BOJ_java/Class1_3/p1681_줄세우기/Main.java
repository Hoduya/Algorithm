package Class1_3.p1681_줄세우기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();

        int count = 0;
        Integer label = 0;

        while(count < N){
            // L 포함 체크
            label++;
            if(!label.toString().contains(L)){
                count++;
            }
        }
        System.out.println(label);
    }
}