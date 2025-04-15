package lab2;

import java.util.Scanner;

public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        searchInsertPosition searchInsert = new searchInsertPosition();
        int[] nums;
        int target;

        System.out.print("Введите количество элементов в массиве: ");
        int num = scanner.nextInt();
        nums = new int[num];

        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Введите число: ");
        target = scanner.nextInt();
        scanner.close();

        int index = searchInsert.searchInsert(nums, target);
        System.out.println(index);
    }
}
