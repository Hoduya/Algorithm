package C1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10828_스택_LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StackNode stack = new StackNode();

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(stack.pop() + "\n");
                    break;

                case "top":
                    sb.append(stack.peek() + "\n");
                    break;

                case "size":
                    sb.append(stack.getSize() + "\n");
                    break;

                case "empty":
                    if(stack.isEmpty())
                        sb.append("1"+ "\n");
                    else
                        sb.append("0"+ "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

class StackNode{
    public Node top;
    private int size;

    public StackNode(){
        top = null;
    }

    public void push(Object data){
        Node newNode = new Node(data);
        newNode.setNextNode(top);
        top = newNode;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public Object peek(){
        return isEmpty() ? -1 : top.data;
    }

    public Object pop(){
        if (isEmpty()) return -1;

        Object popData = peek();
        top = top.getNextNode();
        return popData;
    }

    public int getSize(){
        int count = 0;
        Node tempNode = top;
        while(tempNode != null){
            tempNode = tempNode.getNextNode();
            count++;
        }

        return count;
    }
}

class Node{
    public Object data;
    private Node nextNode;

    public Node(Object data){
        this.data = data;
        this.nextNode = null;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    public Node getNextNode(){
        return this.nextNode;
    }
}