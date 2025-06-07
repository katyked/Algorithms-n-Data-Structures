package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Node_h {
    int data;
    Node_h left, right;

    Node_h(int d) {
        data = d;
        left = right = null;
    }
}

public class t4_height {
    static Node_h root;

    static int height(Node_h node) {
        if (node == null)
            return 0;
        else {
            int lheight = height(node.left);
            int rheight = height(node.right);

            return Math.max(lheight, rheight) + 1;
        }
    }

    static Node_h insert(Node_h node, int data) {
        if (node == null) {
            return new Node_h(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            }
            return node;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] numsStr = line.split(" ");
        root = null;
        for (String numStr : numsStr) {
            int num = Integer.parseInt(numStr);
            if (num == 0) break;
            root = insert(root, num);
        }
        System.out.println(height(root));
    }
}
