package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class t1_traversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static void inorderTraversal(Node root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderTraversal(root.left, writer);
            writer.write(String.valueOf(root.data));
            writer.newLine();
            inorderTraversal(root.right, writer);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = null;
        String line;
        while ((line = reader.readLine()) != null) {
            int data = Integer.parseInt(line);
            if (data == 0) {
                break;
            }
            root = insert(root, data);
        }

        inorderTraversal(root, writer);

        reader.close();
        writer.close();
    }
}