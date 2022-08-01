package C1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10845_큐_Array {
    public static int[] queue;
    public static int front = 0;
    public static int back = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        queue = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop() + "\n");
                    break;

                case "front":
                    sb.append(front() + "\n");
                    break;

                case "back":
                    sb.append(back() + "\n");
                    break;

                case "size":
                    sb.append(back - front + "\n");
                    break;

                case "empty":
                    if(isEmpty())
                        sb.append("1"+ "\n");
                    else
                        sb.append("0"+ "\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int data){
        queue[back] = data;
        back++;
    }

    public static int pop(){
        if (isEmpty()) return -1;

        int popData = queue[front];
        queue[front] = 0;
        front++;
        return  popData;
    }

    public static boolean isEmpty(){
        return front == back;
    }

    public static int front(){
        if (isEmpty()) return -1;

        return queue[front];
    }

    public static int back(){
        if (isEmpty()) return -1;

        return queue[back - 1];
    }
}
