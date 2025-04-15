package lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class t5_CycleSearch {
    static int n;
    static int[][] adjMatrix;
    static boolean[] visited;
    static int[] parent;
    static int cycleStart = -1;
    static int cycleEnd = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        visited = new boolean[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i)) {
                break;
            }
        }

        if (cycleStart == -1) {
            writer.write("NO");
        } else {
            writer.write("YES");
            writer.newLine();

            List<Integer> cycle = new ArrayList<>();
            cycle.add(cycleStart);
            int current = cycleEnd;
            while (current != cycleStart) {
                cycle.add(current);
                current = parent[current];
            }
            writer.write(String.valueOf(cycle.size()));
            writer.newLine();

            for (int i = cycle.size() - 1; i >= 0; i--) {
                writer.write((cycle.get(i) + 1) + " ");
            }
        }
        writer.newLine();
        reader.close();
        writer.close();
    }

    static boolean dfs(int u) {
        visited[u] = true;
        for (int v = 0; v < n; v++) {
            if (adjMatrix[u][v] == 1) {
                if (!visited[v]) {
                    parent[v] = u;
                    if (dfs(v)) {
                        return true;
                    }
                } else if (v != parent[u]) {
                    cycleStart = v;
                    cycleEnd = u;
                    return true;
                }
            }
        }
        return false;
    }
}