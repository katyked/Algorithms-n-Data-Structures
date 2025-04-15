package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class unionMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] line = new int[L];
            for (int j = 0; j < L; j++) {
                line[j] = scanner.nextInt();
            }
            list.add(line);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] merger = unionSort(list.get(i), list.get(j));
                result.append(merger[L - 1]).append("\n");
            }
        }
        System.out.print(result);
    }

    private static int[] unionSort(int[] seq1, int[] seq2) {
        int[] union = new int[seq1.length + seq2.length];
        System.arraycopy(seq1, 0, union, 0, seq1.length);
        System.arraycopy(seq2, 0, union, seq1.length, seq2.length);
        Arrays.sort(union);
        return union;
    }
}
