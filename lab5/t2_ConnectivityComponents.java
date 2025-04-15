package lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class t2_ConnectivityComponents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adjList, visited, component);
                components.add(component);
            }
        }
        writer.write(String.valueOf(components.size()));
        writer.newLine();

        for (List<Integer> component : components) {
            writer.write(String.valueOf(component.size()));
            writer.newLine();
            for (int vertex : component) {
                writer.write(vertex + " ");
            }
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    private static void dfs(int vertex, List<List<Integer>> adjList, Set<Integer> visited, List<Integer> component) {
        visited.add(vertex);
        component.add(vertex);

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjList, visited, component);
            }
        }
    }
}
