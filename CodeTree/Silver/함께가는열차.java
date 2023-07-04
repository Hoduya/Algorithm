package Silver;
import java.util.*;
import java.io.*;

public class 함께가는열차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] speeds = new int[N];

        for(int i = N - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            speeds[i] = Integer.parseInt(st.nextToken());
        }

        int count = 1;
        int headSpeed = speeds[0];
        for(int i = 1; i < speeds.length; i++) {
            if (headSpeed >= speeds[i]) {
                count++;
                headSpeed = speeds[i];
            }
        }
        System.out.println(count);
    }
}

