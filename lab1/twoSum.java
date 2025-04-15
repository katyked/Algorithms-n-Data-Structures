package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class twoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = scanner.nextInt();
        System.out.print("Введите элементы массива: ");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Введите цель: ");
        int target = scanner.nextInt();

        System.out.println("Массив чисел: " + Arrays.toString(nums));
        System.out.println("Цель: " + target);

        for (int j = 0; j < length - 1; j++) {
            if (nums[j] + nums[j + 1] == target) {
                System.out.print("[" + j + ", ");
                System.out.print(j+1 + "]");
            }

            scanner.close();
        }
    }
}

