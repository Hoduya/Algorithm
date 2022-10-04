import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Softeer_플레이페어암호 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        String key = br.readLine();
        char[][] ciper = new char[5][5];
        boolean[] used = new boolean[26];

        String str = "";
        // 문자열 중복 문자 제거
        for(int i = 0; i < key.length(); i++){
            if(key.indexOf(key.charAt(i)) == i) {
                str += key.charAt(i);
            }
        }

        int count = 0;
        // 암호화_ 중복 문자 제거
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            used[c - 'A'] = true;
            ciper[i / 5][i % 5] = c;
            count++;
        }

        // 나머지 문자 채우기
        for (int i = 0; i < 26; i++) {
            if(used[i] || i == 'J' - 'A') continue;
            ciper[count / 5][count % 5] = (char)('A' + i);
            count++;
        }
        
        // 메세지 쌍으로 나누기
        ArrayList<String> pair = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if(sb.length() == 0) {
                sb.append(ch);
                if(i == message.length() - 1) {
                    sb.append("X");
                    pair.add(sb.toString());
                }
            }
            else if(sb.length() == 1) {
                if(sb.charAt(0) != ch) {
                    sb.append(ch);
                    pair.add(sb.toString());
                    sb = new StringBuilder();
                }
                else {
                    if(sb.charAt(0) == 'X'){
                        sb.append("Q");
                    } else {
                        sb.append("X");
                    }
                    pair.add(sb.toString());
                    sb = new StringBuilder();
                    sb.append(ch);

                    if(i == message.length() - 1) {
                        sb.append("X");
                        pair.add(sb.toString());
                    }
                }
            }
        }

        HashMap<Character, Pos> map = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map.put(ciper[i][j], new Pos(i, j));
            }
        }

        char a, b;
        Pos posA, posB;
        String result = "";
        for(String s : pair) {
            a = s.charAt(0);
            b = s.charAt(1);
            posA = map.get(a);
            posB = map.get(b);
            // 1. 쌍이 같은 행에 존재 -> 한 칸 오른쪽 글자로 변환
            if(posA.row == posB.row) {
                result += ciper[posA.row][(posA.col + 1) % 5];
                result += ciper[posB.row][(posB.col + 1) % 5];
            }
            // 2. 쌍이 같은 열에 존재 -> 한 칸 아래쪽 글자로 변환
            else if(posA.col == posB.col) {
                result += ciper[(posA.row + 1) % 5][posA.col];
                result += ciper[(posB.row + 1) % 5][posB.col];
            }
            // 3. 그 외 -> 같은 쌍의 다른 글자 열에 있는 글자로 변환
            else {
                result += ciper[posA.row][posB.col];
                result += ciper[posB.row][posA.col];
            }
        }

        System.out.print(result);
    }

    static class Pos {
        int row, col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}