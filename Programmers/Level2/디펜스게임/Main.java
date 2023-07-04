package Level2.디펜스게임;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }
}

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        if(enemy.length <= k) {
            return enemy.length;
        }

        for(int i = 0; i < k; i++) {
            pq.add(enemy[i]);
        }

        for(int i = k; i < enemy.length; i++) {
            if(!pq.isEmpty() && pq.peek() < enemy[i]) {
                n -= pq.poll();
                pq.add(enemy[i]);
            } else {
                n -= enemy[i];
            }

            if (n < 0) return i;
            if (n == 0) return i + 1;
        }
        return enemy.length;
    }
}