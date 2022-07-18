package DAY01.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sds_p1062_가르침 {
    static int N, K;
    static String[] words;
    static String[] subString;
    static boolean[] visited = new boolean[26];
    static int max;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ_java/DAY01/DFS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        // a, n, t, i, c 방문 처리
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        max = 0;
        subString = new String[N];

        if(K < 5){  // 5개 이하면 0
            System.out.println(0);
            return;
        } else if(K == 26){ // 모든 단어 가능
            System.out.println(N);
            return;
        } else{ // 앞뒤 4개 자르기
            for(int i = 0; i < N; i++){
                subString[i] = words[i].substring(4, words[i].length() - 4);
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int depth, int start){
        // 1. 체크인
        // 2. 목적지인가?
        // 3. 연결된 곳을 순회?
        //  4. 갈 수 있는가?
        //  5. 간다.
        // 6. 체크아웃

        // 길이 K - 5 일때 단어 check
        if(depth == K - 5){
            int count = 0;

            for(int i = 0; i < N; i ++){
                count += 1;
                for(int j = 0; j < subString[i].length(); j++){
                    if(visited[subString[i].charAt(j) - 'a'] == false){
                        count -= 1;
                        break;
                    }
                }
            }
            max = Math.max(max, count);
            return;
        }
        for(int i = start; i < 26; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
