package Level2.줄서는방법;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(3, 5);
    }
}

class Solution {

    public int solution(int n, long k) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        HashSet<Integer> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();


        return answer;
    }
}
