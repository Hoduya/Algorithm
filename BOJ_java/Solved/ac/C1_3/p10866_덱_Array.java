package Solved.ac.C1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10866_덱_Array {
    public static int[] queue;
    public static int front;
    public static int back;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        queue = new int[2 * N];
        front = N;
        back = N;

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front() + "\n");
                    break;

                case "pop_back":
                    sb.append(pop_back() + "\n");
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

    public static void push_front(int data){
        front--;
        queue[front] = data;
    }

    public static void push_back(int data){
        queue[back] = data;
        back++;
    }

    public static int pop_front(){
        if (isEmpty()) return -1;

        int popData = queue[front];
        queue[front] = 0;
        front++;
        return  popData;
    }

    public static int pop_back(){
        if (isEmpty()) return -1;

        back--;
        int popData = queue[back];
        queue[back] = 0;
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
