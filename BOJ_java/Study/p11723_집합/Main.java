package Study.p11723_집합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        set = new HashSet();

        int M = Integer.parseInt(br.readLine());
        String op;
        int num;
        while (0 < M--) {
            st = new StringTokenizer(br.readLine(), " ");
            op = st.nextToken();
            num = op.equals("all") || op.equals("empty") ? 0 : Integer.parseInt(st.nextToken());
            switch (op) {
                case "add" :
                    set.add(num);
                    break;

                case "remove" :
                    set.remove(num);
                    break;

                case "check" :
                    sb.append(set.contains(num) ? 1 : 0).append("\n");
                    break;

                case "toggle" :
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;

                case "all" :
                    fillSet();
                    break;

                case "empty" :
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
    static void fillSet() {
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }
}
