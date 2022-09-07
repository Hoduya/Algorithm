package KAKAO_2018;

import java.util.*;

class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        // 캐시가 없는 경우
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for(int i = 0; i < cities.length; i++) {
            String str = cities[i].toUpperCase();

            // hit
            if(cache.remove(str)) {
                cache.addLast(str);
                answer += 1;
            }
            // miss
            else {
                // 캐시 공간이 남는 경우
                if(cache.size() < cacheSize) {
                    cache.addLast(str);
                }
                // 캐시가 가득 찬 경우
                else {
                    cache.removeFirst();
                    cache.addLast(str);
                }
                answer += 5;
            }
        }

        return answer;
    }
}