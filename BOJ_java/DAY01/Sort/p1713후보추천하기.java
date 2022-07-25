package DAY01.Sort;

import java.io.*;
import java.util.*;

public class p1713후보추천하기 {
    static int N, K;
    static Candidate[] candidates;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        candidates = new Candidate[101];
        List<Candidate> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int k = 0; k < K; k++) {
            int no = Integer.parseInt(st.nextToken());
            // 해당 후보가 최초 호출 시 -> 객체 생성
            if(candidates[no] == null){
                candidates[no] = new Candidate(no, 0, 0, false);
            }
            // 해당 후보가 사진틀에 있을 경우
            if(candidates[no].isIn == true){
                candidates[no].recommend++;
            } else {
                // 해당 후보가 사진 틀에 없음
                // 사진틀이 가득 찬 경우
                if(list.size() == N){
                  // 정렬, 지울 후보 선정, 제거
                }
                // 사진틀에 여유가 있는 경우
                candidates[no].recommend = 1;
                candidates[no].isIn = true;
                candidates[no].timeStamp = k;
                list.add(candidates[no]);
            }
        }
    }

    static class Candidate {
        int no;
        int recommend;
        int timeStamp;
        boolean isIn;

        public Candidate(int no, int recommend, int timeStamp, boolean isIn) {
            this.no = no;
            this.recommend = recommend;
            this.timeStamp = timeStamp;
            this.isIn = isIn;
        }
    }
}


