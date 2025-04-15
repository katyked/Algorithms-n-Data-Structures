package lab3;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        if (empty()) {return -1;}
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int top = queue1.poll();
        Queue<Integer> t = queue1;
        queue1 = queue2;
        queue2 = t;
        return top;
    }

    public int top() {
        if (empty()) {return -1;}
        int top = -1;
        while (!queue1.isEmpty()) {
            top = queue1.poll();
            queue2.offer(top);
        }
        Queue<Integer> t = queue1;
        queue1 = queue2;
        queue2 = t;
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
