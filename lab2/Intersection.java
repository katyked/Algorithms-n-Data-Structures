package lab2;

import java.util.Scanner;
import java.util.Arrays;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        int list1 = nums1.length;
        int list2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < list1 && j < list2) {
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Введите число элементов в 1 массиве: ");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.print("Введите элементы 1 массива: ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.println("Введите число элементов во 2 массиве: ");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Введите элементы 2 массива: ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }
        Intersection intersection = new Intersection();
        int[] result = intersection.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
        scanner.close();
    }
}
