package SDS_Lecture.DAY01.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1759_암호만들기 {
    static int L, C;
    static char[] c;
    static char[] code;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/DAY01/DFS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        c = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            c[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(c);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start){
        // 목적지 -> 최소 한개의 모음, 두개의 자음 만족하면 출력
        if(depth == L){
            int numOfVowel = 0;
            // 암호 내 모음 개수 카운트
            for (int i = 0; i < code.length; i++) {
                char ch = code[i];
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    numOfVowel++;
                }
            }

            if(numOfVowel != 0 && (L - numOfVowel) >= 2){
                String result = new String(code);
                sb.append( result + "\n");
            }
            return;
        }

        // 조합 탐색
        //  문자 하나씩 저장하면서 재귀
        for(int i = start; i < C; i++){
                code[depth] = c[i];
                dfs(depth + 1, i + 1);
            }
        }
}


