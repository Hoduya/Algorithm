import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분할 정복

public class p1074_Z {
    static int N, r, c, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        num = 0;
        int size = (int)Math.pow(2, N);
        visit(size);
        System.out.println(num);
    }

    static void visit(int size){
        if(size == 1) {
            return;
        }

        int half = size / 2;

        // 1 사분면
        // 2 사분면
        if(r >= 0 && r < half &&  c >= half && c < size){
            num += half * half;
            c -= half;
        }
        // 3 사분면
        if(r >= half && r < size && c >= 0 && c < half ){
            num += half * half * 2;
            r-= half;
        }
        // 4 사분면
        if(r >= half && r < size &&  c >= half && c < size){
            num += half * half * 3;
            r -= half;
            c -= half;
        }
        visit(half);
    }
}
