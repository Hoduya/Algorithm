package TEST.p1927_최소힙;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                if(minHeap.isEmpty()) {
                    sb.append("0" + "\n");
                } else {
                    sb.append(minHeap.poll() + "\n");
                }
            } else {
                minHeap.add(number);
            }
        }
        System.out.println(sb);
    }
}
