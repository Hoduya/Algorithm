package Level3.여행경로;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }
}

class Solution {

    boolean[] visit;
    ArrayList<String> results = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        Arrays.fill(visit, false);
        dfs("", tickets, "ICN", 0);

        results.sort((s1, s2) -> {
            return s1.compareTo(s2);
        });

        System.out.println(results);

        return results.get(0).split(" ");
    }

    void dfs(String path, String[][] tickets, String code, int depth) {
        path += code + " ";
        if (depth == tickets.length) {
            results.add(path);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0];
            String e = tickets[i][1];
            if (!visit[i] && s.equals(code)) {
                visit[i] = true;
                dfs(path, tickets, e, depth + 1);
                visit[i] = false;
            }
        }
    }
}
