package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10828_스택_Array {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop() + "\n");
                    break;

                case "top":
                    sb.append(top() + "\n");
                    break;

                case "size":
                    sb.append(size + "\n");
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
        stack[size++] = data;
    }

    public static int pop(){
        if (isEmpty()) return -1;

        int popData = stack[size - 1];
        stack[size] = 0;
        size--;
        return  popData;
    }

    public static boolean isEmpty(){
        return size == 0;
    }

    public static int top(){
        if (isEmpty()) return -1;

        return stack[size - 1];
    }
}
