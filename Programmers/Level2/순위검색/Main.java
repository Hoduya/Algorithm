package Level2.순위검색;
import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(String i : info) {
            dfs(0, "", i.split(" "));
        }

        for(ArrayList<Integer> scores: map.values()) {
            Collections.sort(scores);
        }

        for(int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" and ");
            String[] e = q[3].split(" ");
            String str = q[0] + " " + q[1] + " " + q[2] + " " + e[0] + " ";
            if (map.containsKey(str)) {
                answer[i] = upperCounts(map.get(str), Integer.parseInt(e[1]));
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public int upperCounts(ArrayList<Integer> arr, int target) {
        int s = 0;
        int e = arr.size() - 1;

        while(s <= e) {
            int mid = (s + e) / 2;
            if (arr.get(mid) < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return arr.size() - s;
    }

    public void dfs(int depth, String q, String[] arr) {
        if (depth == 4) {
            int score = Integer.parseInt(arr[4]);
            if (!map.containsKey(q)) {
                ArrayList<Integer> scores = new ArrayList<>();
                scores.add(score);
                map.put(q, scores);
            } else {
                map.get(q).add(score);
            }
            return;
        }

        dfs(depth + 1, q + arr[depth] + " ", arr);
        dfs(depth + 1, q + "- ", arr);
    }
}
