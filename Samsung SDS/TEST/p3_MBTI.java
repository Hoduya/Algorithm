package TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class p3_MBTI {
    static int[] out;
    static String[] MBTI;
    static char[] elements;
    static int[] rewards;
    static int[] N_Reward;
    static ArrayList<CombN> combList;

    static class CombN{
        int[] combIdx;
        int N;

        CombN(int[] indices, int N, int R){
            this.combIdx = new int[R];
            for(int i = 0; i < R; i++){ this.combIdx[i] = indices[i]; }
            this.N = N;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        elements = new char[]{'E','S','T','J','I','N','F','P'};
        MBTI = new String[]{
                "ENFJ", "ENFP", "ENTJ", "ENTP", "ESFJ", "ESFP", "ESTJ", "ESTP",
                "INFJ", "INFP", "INTJ", "INTP", "ISFJ", "ISFP", "ISTJ", "ISTP"
        };
        N_Reward = new int[9]; // index = N, value = reward
        for(int i = 1; i < 9; i++){ N_Reward[i] = 1987654321; }

        // N이 1~8인 모든 조합 찾고
        // 조합인덱스와 N 저장.
        out = new int[16];
        combList = new ArrayList<CombN>();

        for(int i = 2; i <= 16; i++){
            combination(0, 0, i);
        }

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int min_reward = 1987654321;

            rewards = new int[16];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 16; i++){
                rewards[i] = Integer.parseInt(st.nextToken());
            }

            // 입력 N 을 만족하는 조합 순회하면서 min reward 찾기
            for(CombN c : combList){
                if(c.N == N){
                    int reward = 0;
                    for(int idx: c.combIdx){
                        reward += rewards[idx];
                    }
                    if( reward < min_reward ){
                        min_reward = reward;
                    }
                }
            }
            sb.append("#" + (t+1) + " " + min_reward + "\n");
        }
        System.out.println(sb);
    }
    // dfs
    // 조합 16C2 ~ 16C16
    static void combination(int idx, int start, int R){
        if(idx == R){
            StringBuilder outString = new StringBuilder();
            // 조합 문자열
            for(int i = 0; i < idx; i++){
                outString.append(MBTI[out[i]]);
            }

            String s = outString.toString();
            // 문자포함 수 (N) 계산 - 0 이면 return
            int min_count = 9;
            int count = 0;
            for(int i = 0; i < 8; i++){
                count = 0;
                for(int j = 0; j < s.length(); j++){
                    if(elements[i] == s.charAt(j)) count++;
                }
                if(count == 0) return;

                if(count < min_count) min_count = count;
            }
            combList.add(new CombN(out, min_count, R));
        }

        for(int i = start; i < 16; i++){
            out[idx] = i;
            combination(idx + 1, i + 1, R);
        }
    }
}
