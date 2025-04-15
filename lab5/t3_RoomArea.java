package lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class t3_RoomArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        char[][] maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            maze[i] = reader.readLine().toCharArray();
        }

        String[] coords = reader.readLine().split(" ");
        int startRow = Integer.parseInt(coords[0]) - 1;
        int startCol = Integer.parseInt(coords[1]) - 1;
        int area = calculateRoomArea(maze, startRow, startCol);

        writer.write(String.valueOf(area));
        writer.newLine();

        reader.close();
        writer.close();
    }

    private static int calculateRoomArea(char[][] maze, int row, int col) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == '*' ) {
            return 0;
        }

        if (maze[row][col] == 'V'){
            return 0;
        }

        maze[row][col] = 'V';
        return 1 + calculateRoomArea(maze, row + 1, col)
                + calculateRoomArea(maze, row - 1, col)
                + calculateRoomArea(maze, row, col + 1)
                + calculateRoomArea(maze, row, col - 1);
    }
}
