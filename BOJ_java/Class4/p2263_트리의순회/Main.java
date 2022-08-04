package Class4.p2263_트리의순회;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preOrder, inOrder, postOrder;
    static StringBuilder sb;
    static int[] inOrderIdx;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        preOrder = new int[N + 1];
        inOrder = new int[N + 1];
        postOrder = new int[N + 1];
        inOrderIdx = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) inOrder[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) postOrder[i] = Integer.parseInt(st.nextToken());

        // 빠른 검색을 위해 중위 순회 배열 값-인덱스 정보 저장.
        for (int i = 1; i <= N; i++) inOrderIdx[inOrder[i]] = i;

        getPreOrder(1, N, 1, N);
        System.out.println(sb);
    }

    static void getPreOrder(int in_start, int in_end, int post_start, int post_end) {

        if(in_end < in_start || post_end < post_start) return;

        int root_data = postOrder[post_end];
        sb.append(root_data + " ");

        int root_idx = inOrderIdx[root_data];
        // root 기준 왼쪽 자식 개수 세기
        int left = root_idx - in_start;

        getPreOrder(in_start, root_idx - 1, post_start, post_start + left - 1);

        getPreOrder(root_idx + 1, in_end, post_start + left, post_end - 1);
    }
}
