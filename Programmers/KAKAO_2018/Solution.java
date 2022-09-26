package KAKAO_2018;

import java.util.*;
import java.io.*;

public class Solution {
    static int count;
    static int[] discounts = {40, 30, 20 ,10, 0};
    static int[] answer = {0, 0};
    static int[][] us;
    static int[] emos;

    public static void main(String[] args) throws IOException{
        int[] emoticons = {1,2};
        int[][] users = {{1,2}};
                count = emoticons.length;

                us = users;
                emos = emoticons;

                System.out.println(emos[1]);
    }

    static void comb(int start, int idx, int[] results, int[][] users, int[] emoticons) {
        if (count == idx) {
            if (answer[0] > results[0]) return;
            else {
                if (answer[0] == results[0]) {
                    if (answer[1] > results[1]) return;
                }
                answer[0] = results[0];
                answer[1] = results[1];
            }
        }

        for (int i = 0; i < 5; i++) {
            int discount = discounts[i];
        }
    }
}

