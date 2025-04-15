package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentLine, preLine = null;
        for (int i = 0; i < numRows; ++i) {
            currentLine = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    currentLine.add(1);
                }
                else {
                    currentLine.add(preLine.get(j - 1) + preLine.get(j));
                }
            }
            preLine = currentLine;
            result.add(currentLine);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int numRows = scanner.nextInt();
        scanner.close();

        PascalTriangle triangle = new PascalTriangle();
        List<List<Integer>> pascalTriangle = triangle.generate(numRows);
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
