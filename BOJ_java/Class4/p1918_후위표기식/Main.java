package Class4.p1918_후위표기식;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    후위표기식 규칙 (스택 사용)
    1. 피 연산자는 출력.
    2. 연산자는 스택에 넣되,
      2.1 스택 top이 자신과 우선순위가 같거나 높으면 pop & 출력 하고 넣는다.
    3. 식이 끝나면 스택 전부 pop
    4. 괄호
      4.1 여는 괄호는 스택에 넣는다.
      4.2 닫는 괄호가 나올때 까지 모든 연산자는 그냥 넣는다.
      4.3 닫는 괄호가 나오면 여는 괄호가 나올 때까지 pop
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        String infix = br.readLine();
        char op;
        int pr;
        for (int i = 0; i < infix.length(); i++) {
            op = infix.charAt(i);
            pr = getPrioirty(op);
            switch(op) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while(!s.isEmpty() && getPrioirty(s.peek()) >= pr)
                        sb.append(s.pop());
                    s.push(op);
                    break;
                case '(' :
                    s.push(op);
                    break;
                case ')' :
                    while(!s.isEmpty() && s.peek() != '(')
                        sb.append(s.pop());
                    s.pop();
                    break;
                default:
                    sb.append(op);
            }
        }
        while(!s.isEmpty())
            sb.append(s.pop());

        System.out.println(sb);
    }

    static int getPrioirty(char op) {
        switch(op) {
            case '+' :
            case '-' :
                return 0;
            case '*' :
            case '/' :
                return 1;
            default:
                return -1;
        }
    }
}
