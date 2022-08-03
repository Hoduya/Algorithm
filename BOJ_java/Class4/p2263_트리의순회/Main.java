package Class4.p2263_트리의순회;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preOrder, inOrder, postOrder;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        preOrder = new int[N];
        inOrder = new int[N];
        postOrder = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) inOrder[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) postOrder[i] = Integer.parseInt(st.nextToken());

        int in_start = 0;
        int in_end = N - 1;
        int root_idx = 0;
        int root_data = postOrder[N - 1];
        for (int i = 0; i < N; i++) {
            if(root_data == inOrder[i])
                root_idx = i;
        }

        getPreOrder(in_start, in_end, root_idx);
    }

    static void getPreOrder(int in_start, int in_end, int root_idx) {
        if(in_start <= in_end) return;


        int root_data = postOrder[root_idx];
        for (int i = 0; i < in_end - in_start; i++) {
            if(root_data == inOrder[i])
                root_idx = i;
        }

        // 왼쪽 자식
        getPreOrder(in_start, in_end, root_idx);
        // 오른쪽 자식
        getPreOrder(in_start,root_idx - 1);
    }
}
