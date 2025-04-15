package lab3;

import java.io.*;
import java.util.*;

public class GoblinsNShamans {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> queue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            String command = parts[0];

            switch (command) {
                case "+":
                    int goblin = Integer.parseInt(parts[1]);
                    queue.add(goblin);
                    break;
                case "*":
                    goblin = Integer.parseInt(parts[1]);
                    int mid = queue.size() / 2;
                    queue.add(mid, goblin);
                    break;
                case "-":
                    int removedGoblin = queue.remove(0);
                    writer.write(removedGoblin + "\n");
                    break;
            }
        }

        reader.close();
        writer.close();
    }
}
