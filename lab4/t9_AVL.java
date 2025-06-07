package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node4 {
    int key;
    Node4 left, right;
    int height;

    Node4(int key) {
        this.key = key;
        left = right = null;
        height = 1;
    }
}

class AVLTree {
    Node4 root;

    int height(Node4 N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node4 rightRotate(Node4 y) {
        Node4 x = y.left;
        Node4 T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node4 leftRotate(Node4 x) {
        Node4 y = x.right;
        Node4 T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node4 N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node4 insert(Node4 node, int key) {
        if (node == null)
            return (new Node4(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    boolean isBalanced(Node4 node) {
        if (node == null)
            return true;

        int balance = getBalance(node);
        if (Math.abs(balance) > 1)
            return false;

        return isBalanced(node.left) && isBalanced(node.right);
    }
}

public class t9_AVL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        AVLTree tree = new AVLTree();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("0")) break;
            int key = Integer.parseInt(input[i]);
            tree.root = tree.insert(tree.root, key);
        }
        if (tree.isBalanced(tree.root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}