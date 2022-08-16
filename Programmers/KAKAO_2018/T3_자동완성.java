package KAKAO_2018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class T3_자동완성 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        int[] order = {4, 3, 5, 2, 1};

        int count = 0;
        int i = 1;
        while(count < order.length) {
            if (order[count] > i) {
                st.push(i++);
                continue;
            }

            if(order[count] == i) {
                count += 1;
                i += 1;
            }
            else if(order[count] == st.pop()) count += 1;
            else break;
        }

        System.out.println(count);
    }
}
