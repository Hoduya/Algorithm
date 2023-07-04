package Level2.해시;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].length() > phone_book[i + 1].length()) continue;
            String nextSlice = phone_book[i + 1].substring(0, phone_book[i].length());
            if (phone_book[i].equals(nextSlice)) {
                return false;
            }
        }
        return true;
    }
}