package lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class t4_Path_in_the_graph {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] se = reader.readLine().split(" ");
        int start = Integer.parseInt(se[0]) - 1;
        int end = Integer.parseInt(se[1]) - 1;

        List<Integer> path = findShortestPath(adjacencyMatrix, start, end);

        if (path == null) {
            writer.write("-1");
        } else {
            writer.write(String.valueOf(path.size() - 1));
            writer.newLine();
            for (int node : path) {
                writer.write((node + 1) + " ");
            }
        }
        writer.newLine();
        reader.close();
        writer.close();
    }

    private static List<Integer> findShortestPath(int[][] adjacencyMatrix, int start, int end) {
        int n = adjacencyMatrix.length;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] parent = new int[n];
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == end) {
                break;
            }

            for (int v = 0; v < n; v++) {
                if (adjacencyMatrix[u][v] == 1 && !visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                }
            }
        }
        if (!visited[end]) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        int current = end;
        while (current != -1) {
            path.add(0, current);
            current = parent[current];
        }
        return path;
    }
}