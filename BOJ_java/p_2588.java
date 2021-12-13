import java.util.*;

public class p_2588 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int num1, num2;
        int r3, r4, r5, r6;

        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();

        r3 = num1 * (num2 % 10);
        r4 = num1 * ((num2 / 10) % 10);
        r5 = num1 * (num2 / 100);
        r6 = num1 * num2;

        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);
    }
}
