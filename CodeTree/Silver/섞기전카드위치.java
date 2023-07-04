package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섞기전카드위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] shuffle = new int[N];
        int[] cards = new int[N];
        int[] temp = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            shuffle[i] = Integer.parseInt(st1.nextToken()) - 1;
            cards[i] = Integer.parseInt(st2.nextToken());
        }

        int count = 3;
        while(count-- > 0) {
            for(int i = 0; i < N; i++) {
                temp[i] = cards[shuffle[i]];
            }
            cards = temp.clone();
        }

        StringBuilder sb = new StringBuilder();
        for(int card : cards) {
            sb.append(card).append("\n");
        }
        System.out.println(sb);
    }
}