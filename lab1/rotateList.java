package lab1;

import java.util.Scanner;

class ListNodeNew {
    int val;
    ListNodeNew next;

    ListNodeNew() {
    }

    ListNodeNew(int val) {
        this.val = val;
    }
    ListNodeNew(int val, ListNodeNew next) {
        this.val = val;
        this.next = next;
    }
}
public class rotateList {
    public ListNodeNew rotateRight(ListNodeNew head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNodeNew current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        k = k % length;
        k = length - k;
        while (k-- > 0) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }
    public static ListNodeNew createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNodeNew head = new ListNodeNew(arr[0]);
        ListNodeNew current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNodeNew(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static void printList(ListNodeNew head) {
        ListNodeNew current = head;
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
        System.out.println("Введите элементы списка: ");
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Введите количество поворотов: ");
        int rotate = scanner.nextInt();

        ListNodeNew list = createList(array);

        rotateList rotateList = new rotateList();
        ListNodeNew rotatedList = rotateList.rotateRight(list, rotate);

        printList(rotatedList);
        scanner.close();
    }
}