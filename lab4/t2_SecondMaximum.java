package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class t2_SecondMaximum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeSet<Integer> set = new TreeSet<>();
        String line = reader.readLine();
        String[] numbers = line.split(" ");
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num == 0) break;
            set.add(num);
        }

        int secondLargest = set.lower(set.last());
        writer.write(String.valueOf(secondLargest));

        reader.close();
        writer.close();
    }
}
