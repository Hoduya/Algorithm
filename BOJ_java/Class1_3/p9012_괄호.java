package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int close_req = 0;

        for(int i = 0; i < N; i++){
            String ps = br.readLine();
            close_req = 0;

            for(int j = 0; j < ps.length(); j++){
                if(ps.charAt(j) == '('){
                    close_req += 1;
                }else{
                    close_req -= 1;
                }

                if(close_req < 0){
                    sb.append("NO").append("\n");
                    break;
                }

                if(j == ps.length() - 1){
                    if(close_req == 0){
                        sb.append("YES").append("\n");
                    }else{
                        sb.append("NO").append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
