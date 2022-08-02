package Class1_3.p7662_이중우선순위큐;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> tMap = new TreeMap<>();

        int TC = Integer.parseInt(br.readLine());
        int N, num;
        String op;
        while (0 < TC--) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                op = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                switch (op) {
                    case "I":
                        tMap.put(num, tMap.getOrDefault(num, 0) + 1);
                        break;

                    case "D":
                        if (!tMap.isEmpty()) {
                            num = (num == 1) ? tMap.lastKey() : tMap.firstKey();
                            if (tMap.get(num) > 1) tMap.put(num, tMap.get(num) - 1);
                            else tMap.remove(num);
                        }
                        break;
                }
            }
            if (tMap.isEmpty()) {
                sb.append("EMPTY" + "\n");
            } else {
                sb.append(tMap.lastKey() + " " + tMap.firstKey() + "\n");
            }
            tMap.clear();
        }
        System.out.print(sb);
    }
}
