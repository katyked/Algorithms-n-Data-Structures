package lab1;

import java.util.Scanner;
import java.util.Arrays;
public class plusOne {
    public int[] plusOneTest(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        plusOne plusOne = new plusOne();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String num = scanner.nextLine();
        int[] digits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) { digits[i] = Character.getNumericValue(num.charAt(i));
        }
        int[] finalResult = plusOne.plusOneTest(digits);
        System.out.println(Arrays.toString(finalResult));
        scanner.close();
    }
}
