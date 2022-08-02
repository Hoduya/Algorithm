package Class1_3.p18870_좌표압축;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        int[] ascArr = arr.clone();
        Arrays.sort(ascArr);

        // 좌표 크기 번호 부여 0 ~
        map.put(ascArr[0], 0);
        int number = 0;
        for (int i = 1; i < N; i++) {
            if(ascArr[i] != ascArr[i - 1]){
                map.put(ascArr[i], ++number);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 좌표 값과 크기 번호 매핑
        for (int i = 0; i < N; i++) {
            arr[i] = map.get(arr[i]);
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
