package C1_3;// Arrays sort는 퀵정렬, 최악의 경우 O(N^2)
// Collections sort를 이용해서 시간을 줄여야함 -> time sort 이용...
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p2751_수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list);

        for(int value: list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
