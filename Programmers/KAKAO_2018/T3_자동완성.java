package KAKAO_2018;

public class T3_자동완성 {
    static int count = 0;
    static int[] numbers = {1, 2, 3, -2, 0, 2};
    public static void main(String[] args) {

        dfs(0, 0, 0);
        System.out.println(count);
    }

    static void dfs(int start, int depth, int sum) {
        if(depth == 3) {
            if(sum == 0) {
                count++;
            }
        }

        for (int i = start; i < numbers.length; i++) {

        }
    }
}
