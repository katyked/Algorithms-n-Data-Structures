package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class t6_LeafOutput {

    static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static void getLeaves(Node1 root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.data);
        }
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();
        String[] numsStr = line.split(" ");

        Node1 root = null;
        for (int i = 0; i < numsStr.length; i++) {
            int num = Integer.parseInt(numsStr[i]);
            if (num == 0) break;
            root = insert(root, num);
        }

        List<Integer> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        Collections.sort(leaves);

        for (int leaf : leaves) {
            writer.write(String.valueOf(leaf));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
