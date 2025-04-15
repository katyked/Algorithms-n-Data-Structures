package lab1;

import java.util.Scanner;

public class removeDuplicates {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;
        while (list != null && list.next != null) {
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return head;
    }

    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов в списке: ");
        int num = scanner.nextInt();
        int[] array = new int[num];
        System.out.print("Введите элементы списка: ");
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        ListNode list = createList(array);

        removeDuplicates removeDuplicates = new removeDuplicates();
        ListNode sortedList = removeDuplicates.deleteDuplicates(list);

        printList(sortedList);
        scanner.close();
    }
}
