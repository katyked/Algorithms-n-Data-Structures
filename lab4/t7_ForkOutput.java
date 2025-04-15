package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node2 {
    int data;
    Node2 left, right;

    Node2(int data) {
        this.data = data;
        left = right = null;
    }
}

public class t7_ForkOutput {

    static Node2 insert(Node2 root, int data) {
        if (root == null) {
            return new Node2(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static void getNodesWithTwoChildren(Node2 root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            result.add(root.data);
        }
        getNodesWithTwoChildren(root.left, result);
        getNodesWithTwoChildren(root.right, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        Node2 root = null;
        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            if (num == 0) break;
            root = insert(root, num);
        }

        List<Integer> result = new ArrayList<>();
        getNodesWithTwoChildren(root, result);
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            writer.write(String.valueOf(result.get(i)));
            if (i < result.size() - 1) {
                writer.write("\n");
            }
        }

        reader.close();
        writer.close();
    }
}