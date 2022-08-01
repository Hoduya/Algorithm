package Solved.ac.C1_3.p1620_포켓몬마스터;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String names[] = new String[N + 1];
        HashMap<String, Integer> nameMap = new HashMap<>();

        String name;
        for(int i = 1; i <= N; i++){
            name =  br.readLine();
            names[i] = name;
            nameMap.put(name, i);
        }

        int boundary = 'A';

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String question = br.readLine();
            if(question.charAt(0) >= boundary) {
                sb.append(nameMap.get(question) + "\n");
            } else{
                int idx = Integer.parseInt(question);
                sb.append(names[idx] + "\n");
            }
        }

        System.out.println(sb);
    }
}
