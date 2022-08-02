package Class1_3.p11279_최대힙;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        int num;
        while (0 < N--) {
            num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pqMax.isEmpty()) sb.append("0" + "\n");
                else sb.append(pqMax.poll() + "\n");
            }
            else {
                pqMax.add(num);
            }
        }
        System.out.println(sb);
    }
}