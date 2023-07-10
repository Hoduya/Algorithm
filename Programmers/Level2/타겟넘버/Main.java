package Level2.타겟넘버;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

class Solution {

    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int result) {
        if (idx == numbers.length) {
            if (target == result) answer += 1;
            return;
        }
        dfs(numbers, target, idx + 1, result + numbers[idx]);
        dfs(numbers, target, idx + 1, result - numbers[idx]);
    }
}