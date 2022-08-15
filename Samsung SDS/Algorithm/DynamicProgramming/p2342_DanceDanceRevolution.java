package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2342_DanceDanceRevolution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = st.countTokens() - 1;
        int[] commands = new int[N + 1];
        // [n 번째][왼발][오른발] = 최소 점수
        int[][][] dp = new int[N + 1][5][5];

        for(int i = 1; i <= N; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        int command;
        for(int i = 1; i <= N; i++) {
            command = commands[i];


        }

    }

    static int getWeight(int command, int pos) {
        if(pos == 0) {
            return 2;
        } else if(command == pos) {
            return 1;
        } else if(Math.abs(command - pos) == 2) {
            return 4;
        } else {
            return 3;
        }
    }
}

