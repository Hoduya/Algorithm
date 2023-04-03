package 가장큰수;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        int[] param = {3, 30, 34, 5, 9};
        System.out.println(sol.solution(param));
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String lhs = o1 + o2;
                String rhs = o2 + o1;
                return Integer.parseInt(rhs) - Integer.parseInt(lhs);
            }
        });

        for (String s: arr) {
            answer += s;
        }

        if (answer.charAt(0) == '0') return "0";
        else return answer;
    }
}