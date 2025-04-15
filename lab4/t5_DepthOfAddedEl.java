package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class t5_DepthOfAddedEl {
    static Node root;

    static int depth(Node node, int data) {
        if (node == null) return 0;
        if (node.data == data) return 1;
        if (data < node.data) return 1 + depth(node.left, data);
        return 1 + depth(node.right, data);
    }

    static Node insert(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data) node.left = insert(node.left, data);
        else if (data > node.data) node.right = insert(node.right, data);
        return node;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        root = null;
        for (String s : input) {
            int num = Integer.parseInt(s);
            if (num == 0) break;
            boolean found = false;
            Node temp = root;
            while (temp != null) {
                if (temp.data == num) {
                    found = true;
                    break;
                }
                if (num < temp.data) temp = temp.left;
                else temp = temp.right;
            }
            if (!found) {
                root = insert(root, num);
                System.out.print(depth(root, num) + " ");
            }
        }
    }
}
