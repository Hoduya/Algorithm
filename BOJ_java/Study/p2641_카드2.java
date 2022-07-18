package Study;// Queue 인터페이스 사용

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2641_카드2 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N, top = 1;
        N = keyboard.nextInt();

        for(int i=1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll();
            top = queue.element();
            queue.poll();
            queue.add(top);
        }

        System.out.println(top);
    }

}
