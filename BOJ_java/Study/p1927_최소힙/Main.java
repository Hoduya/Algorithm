package Study.p1927_최소힙;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(pq.isEmpty()) sb.append("0" + "\n");
                else sb.append(pq.poll() + "\n");
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
