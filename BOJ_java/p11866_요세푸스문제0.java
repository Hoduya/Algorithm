import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> list = new LinkedList();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        int index = 0;
        sb.append("<");
        while(list.size() > 1){
            index = (index + (K - 1)) % list.size();

            sb.append(list.remove(index) + ", ");
        }
        sb.append(list.remove(0) + ">");

        System.out.println(sb);
    }
}
