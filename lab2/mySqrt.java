package lab2;

import java.util.Scanner;

public class mySqrt {

    public static int testSqrt(int x){
        int left = 0;
        int right = x;
        int result = 0;
        while(left <= right){
            int mid = (left+right)/2;
            int preResult = mid * mid;
            if (preResult == x) {
                return mid;
            }
            else if (preResult < x) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        System.out.println(testSqrt(num));
        scanner.close();
    }
}
