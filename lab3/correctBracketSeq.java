package lab3;

import java.io.*;
import java.util.Stack;

public class correctBracketSeq {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();
        Stack<Character> stack = new Stack<>();
        boolean val = true;

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    val = false;
                    break;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    val = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            val = false;
        }
        if (val) {
            writer.write("yes");
        } else {
            writer.write("no");
        }

        reader.close();
        writer.close();
    }
}

