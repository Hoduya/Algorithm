package Class4.p1991_트리순회;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        char data, left, right;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            data = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            Tree.createNode(data, left, right);
        }
        Tree.preOrder(Tree.root);
        System.out.println();
        Tree.inOrder(Tree.root);
        System.out.println();
        Tree.postOrder(Tree.root);
    }
    static class Tree {
        static Node root;

        static void createNode(char data, char left, char right) {
            if(root == null) {
                root = new Node(data);
                root.left = left != '.' ? new Node(left) : null;
                root.right = right != '.' ? new Node(right) : null;
            } else {
                searchNode(root, data, left, right);
            }
        }

        static void searchNode(Node node, char data, char left, char right) {
            if(node == null) {
                return;
            } else if(node.data == data) {
                node.left = left != '.' ? new Node(left) : null;
                node.right = right != '.' ? new Node(right) : null;
            } else {
                searchNode(node.left, data, left, right);
                searchNode(node.right, data, left, right);
            }
        }

        static void preOrder(Node node) {
            if(node != null) {
                System.out.print(node.data);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        static void inOrder(Node node) {
            if(node != null) {
                inOrder(node.left);
                System.out.print(node.data);
                inOrder(node.right);
            }
        }

        static void postOrder(Node node) {
            if(node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data);
            }
        }
    }

    static class Node {
        char data;
        Node right;
        Node left;

        public Node(char data) {
            this.data = data;
        }
    }
}
