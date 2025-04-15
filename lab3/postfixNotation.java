package lab3;

import java.io.*;
import java.util.Stack;

public class postfixNotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine().trim();
        String[] tokens = input.split("\\s+");

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    writer.write("Неверное выражение...");
                    reader.close();
                    writer.close();
                    return;
                }
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    default:
                        writer.write("Неверный оператор");
                        reader.close();
                        writer.close();
                        return;
                }
                stack.push(result);
            }
        }
        if (stack.size() != 1) {
            writer.write("Неверное выражение...");
            reader.close();
            writer.close();
            return;
        }
        writer.write(String.valueOf(stack.pop()));

        reader.close();
        writer.close();
    }
}
