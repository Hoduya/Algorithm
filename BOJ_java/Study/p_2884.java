package Study;

import java.util.Scanner;

public class p_2884 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int hour, min;

        hour = keyboard.nextInt();
        min = keyboard.nextInt();
        keyboard.close();

        // min 이 45 이상일때
        if (min >= 45){
            min = min - 45;
        }
        // min 이 45 미만일때
        else{
            min = 60 - (45 - min);
            // hour 0 일때
            if(hour == 0) {
                hour = 23;
            }
            // hour 0 아닐때
            else{
                hour -= 1;
            }
        }
        System.out.println(hour + " " + min);
    }
}
