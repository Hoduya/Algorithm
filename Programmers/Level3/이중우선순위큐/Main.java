package Level3.이중우선순위큐;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new String[]{"I -1", "I -1", "D -1"});

    }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(String operator : operations) {
            String[] command = operator.split(" ");

            switch (command[0]) {
                case "I":
                    // push
                    maxHeap.add(Integer.parseInt(command[1]));
                    minHeap.add(Integer.parseInt(command[1]));
                    break;

                case "D":
                    // pop
                    if (command[1].equals("1")) {
                        // 최댓값
                        if (maxHeap.isEmpty()) continue;
                        if (maxHeap.poll().equals(minHeap.peek())) {
                            maxHeap.clear();
                            minHeap.clear();
                        }
                    } else {
                        // 최솟값
                        if (minHeap.isEmpty()) continue;
                        if (minHeap.poll().equals(maxHeap.peek())) {
                            maxHeap.clear();
                            minHeap.clear();
                        }
                    }
                    break;
            }
        }

        answer = new int[2];
        answer[0] = maxHeap.peek() == null ? 0 : maxHeap.peek();
        answer[1] = minHeap.peek() == null ? 0 : minHeap.peek();

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }
}
