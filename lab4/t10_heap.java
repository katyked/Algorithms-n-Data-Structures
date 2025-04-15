package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class t10_heap {

    static int[] heap;
    static int heapSize;

    static void heapifyUp(int index) {
        while (index > 1 && heap[index] > heap[index / 2]) {
            int temp = heap[index];
            heap[index] = heap[index / 2];
            heap[index / 2] = temp;
            index /= 2;
        }
    }

    static void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if (left <= heapSize && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right <= heapSize && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapifyDown(largest);
        }
    }

    static void insert(int k) {
        heapSize++;
        heap[heapSize] = k;
        heapifyUp(heapSize);
    }

    static int extract() {
        int max = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        heapifyDown(1);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        heap = new int[n + 1]; // +1 for easier indexing
        heapSize = 0;

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split(" ");
            if (command[0].equals("0")) {
                insert(Integer.parseInt(command[1]));
            } else {
                writer.write(String.valueOf(extract()));
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }
}