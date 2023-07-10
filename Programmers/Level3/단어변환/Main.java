package Level3.단어변환;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean contains = false;
        for (String word: words) {
            if (word.equals(target)) {
                contains = true;
                break;
            }
        }

        if (!contains) return 0;

        return bfs(begin, target, words);
    }

    int bfs(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        Arrays.fill(visit, false);
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word cur = q.poll();

            if (cur.word.equals(target)) {
                return cur.count;
            }

            for(int i = 0; i < words.length; i++) {
                if (!visit[i] && (canChange(cur.word, words[i]))) {
                    visit[i] = true;
                    q.add(new Word(words[i], cur.count + 1));
                }
            }
        }

        return 0;
    }

    boolean canChange(String word, String target) {
        int differentCount = 0;
        for (int i = 0; i < word.length(); i++) {
            differentCount += word.charAt(i) != target.charAt(i) ? 1 : 0;
            if (differentCount > 1) return false;
        }
        return differentCount == 1;
    }

    class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
