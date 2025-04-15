package lab3;

import java.io.*;
import java.util.Stack;

public class wagonSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] train = reader.readLine().split(" ");
        int[] wagons = new int[n];
        for (int i = 0; i < n; i++) {
            wagons[i] = Integer.parseInt(train[i]);
        }

        Stack<Integer> sid = new Stack<>();
        int x = 1;
        int i = 0;

        while (i < n) {
            if (wagons[i] == x) {
                x++;
                i++;
            } else if (!sid.isEmpty() && sid.peek() == x) {
                sid.pop();
                x++;
            } else {
                sid.push(wagons[i]);
                i++;
            }
            while (!sid.isEmpty() && sid.peek() == x) {
                sid.pop();
                x++;
            }
        }
        while (!sid.isEmpty() && sid.peek() == x) {
            sid.pop();
            x++;
        }
        if (sid.isEmpty()) {
            writer.write("yes");
        } else {
            writer.write("no");
        }
        reader.close();
        writer.close();
    }
}
