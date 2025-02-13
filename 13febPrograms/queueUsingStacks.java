import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public QueueUsingStacks() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    public void enqueue(int value) {
        stackEnqueue.push(value);
    }

    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.isEmpty() ? -1 : stackDequeue.pop(); // Return -1 if queue is empty
    }

    public int peek() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.isEmpty() ? -1 : stackDequeue.peek(); // Return -1 if queue is empty
    }

    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek());    // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
    }
}
