import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10250_ACM호텔 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T = Integer.parseInt(br.readLine());
            int H, W, N;

            for(int i = 0; i < T; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                H = Integer.parseInt(st.nextToken());
                W = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());

                int floor, rNum;

                // 최상층 배정
                if(N % H == 0){
                    floor = H;
                    rNum = N / H;
                }else {
                    floor = N % H;
                    rNum = N / H + 1;
                }

                System.out.println((floor * 100) + rNum);
            }
        }
}
