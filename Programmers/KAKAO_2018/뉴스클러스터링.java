package KAKAO_2018;

import java.util.*;

class 뉴스클러스터링 {
    ArrayList<String> pair1, pair2;

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        pair1 = makePair(str1);
        pair2 = makePair(str2);

        int inCount = 0;

        Collections.sort(pair1);
        Collections.sort(pair2);

        int allCount = pair1.size() + pair2.size();

        // 교집합 원소 개수 찾기
        for(String p1 : pair1) {
            if(pair2.remove(p1)) {
                inCount++;
            }
        }

        allCount -= inCount;

        if(allCount == 0) return 65536;

        answer = (int)(((double)inCount / allCount) * 65536);

        System.out.println(inCount + " " + allCount);

        return answer;
    }

    ArrayList<String> makePair(String str) {
        ArrayList<String> pairs = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            if(Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
                String pair = "";
                pair += a;
                pair += b;
                pairs.add(pair);
            }
        }

        return pairs;
    }
}