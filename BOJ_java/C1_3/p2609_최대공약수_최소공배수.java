package C1_3;/* 유클리드 호제법
    2개의 자연수  a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면
    (단 a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
    이 성질에 따라, b를 r로 나눈 나머지 r0를 구하고,
    다시 r을 r0로 나눈 나머지를 구하는 과정을 반복하여
    나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다
*/
import java.util.Scanner;

public class p2609_최대공약수_최소공배수 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int num1 = keyboard.nextInt();
        int num2 = keyboard.nextInt();

        int gcd = gcd(num1, num2);
        System.out.println(gcd);
        System.out.println(num1 * num2 / gcd);
    }
    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
}
