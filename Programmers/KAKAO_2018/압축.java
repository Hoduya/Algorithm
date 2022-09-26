package KAKAO_2018;
import java.util.*;

class 압축 {
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            char c = 'A' + 1;
            map.put(Character.toString(c), i + 1);
        }

        String str = "";
        int idx = 27;
        for(int i = 0; i < msg.length(); i++) {
            String cur = Character.toString(msg.charAt(i));

            // 사전에 있으면 문자열에 추가하고 다음 글자로 이동
            str += cur;

            // 사전에 없는 경우
            if(map.get(str) == null) {
                // 사전에 추가
                map.put(str, idx++);
                // 마지막 글자 뺀 문자열 색인 출력
                result.add(map.get(str.substring(0, str.length() - 1)));
                str = cur;
            }
        }
        result.add(map.get(str));

        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
