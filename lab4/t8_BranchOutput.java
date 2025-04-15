package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node3 {
    int data;
    Node3 left;
    Node3 right;

    Node3(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class t8_BranchOutput {

    static Node3 insert(Node3 root, int data) {
        if (root == null) {
            return new Node3(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static void findNodesWithOneChild(Node3 root, List<Integer> result) {
        if (root == null) {
            return;
        }

        int childrenCount = 0;
        if (root.left != null) {
            childrenCount++;
        }
        if (root.right != null) {
            childrenCount++;
        }

        if (childrenCount == 1) {
            result.add(root.data);
        }

        findNodesWithOneChild(root.left, result);
        findNodesWithOneChild(root.right, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();
        String[] numsStr = line.split(" ");
        Node3 root = null;
        for (int i = 0; i < numsStr.length; i++) {
            int num = Integer.parseInt(numsStr[i]);
            if (num == 0) break;
            root = insert(root, num);
        }

        List<Integer> result = new ArrayList<>();
        findNodesWithOneChild(root, result);
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            writer.write(String.valueOf(result.get(i)));
            if (i < result.size() - 1) {
                writer.write("\n");
            }
        }
        writer.newLine();


        reader.close();
        writer.close();
    }
}
