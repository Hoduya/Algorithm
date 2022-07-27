package SDS_Lecture.DAY04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// Trie & BFS
public class p9202_Boggle {
    static String[] words;
    static char[][] board;
    static Trie trie;
    static boolean[][] visited;
    static int[] MX = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] MY = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        trie = new Trie();

        int W = Integer.parseInt(br.readLine());
        words = new String[W];
        for (int i = 0; i < W; i++) {
            words[i] = br.readLine();
            trie.put(words[i]);
        }

        br.readLine();
        int B = Integer.parseInt(br.readLine());
        int T = 0;
        board = new char[4][4];
        visited = new boolean[4][4];

        while(T++ < B){
            for (int i = 0; i < 4; i++) {
                String line = br.readLine();
                board[i] = line.toCharArray();
            }
            // case


            br.readLine();
        }

    }
    static void dfs(int x, int y, int length){
        // 체크인
        visited[y][x] = true;

        // 목적지에 도달했는가? -> isWord == true, isHit == false

        // 순회 -> 8방향
        for (int i = 0; i < 8; i++) {
            int tx = x + MX[i];
            int ty = y + MY[i];
            // 가능한가? -> 경계, 방문여부, node가 해당자식 있는가?
            if(!visited[ty][tx] && 0 <= tx && tx <= 4 && 0 <= ty && ty <= 4 ){
                dfs(x + MX[i], y + MY[i], length + 1);
            }
        }
    }
}
class Trie{
    Node root;
    int maxLength = 0;

    public Trie() {
        this.root = new Node();
    }

    public void put(String word){
        maxLength = Math.max(maxLength, word.length());

        Node curNode = root;
        // 한글자씩 확인
        for (int i = 0; i < word.length(); i++) {
            int putIdx = word.charAt(i) - 'A';

            // 글자 있으면 -> 다음 노드로
            // 글자 없으면 -> 자식 만들고 다음 노드
            if(curNode.child[putIdx] == null){
                curNode.child[putIdx] = new Node();
            }
            curNode = curNode.child[putIdx];
        }
        // 마지막 글자(노드)에 isWord
        curNode.isWord = true;
    }

    void clearHit() {
        root.isHit = false;

    }

    boolean hasChild(char c){
        return root.child[c - 'A'] != null;
    }

    Node getChild(char c){
        return root.child[c - 'A'];
    }
}

class Node{
    Node[] child = new Node[26];
    boolean isWord = false;
    boolean isHit = false;
}


