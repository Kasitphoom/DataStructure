package Lab9.code;

public class MyPriorityQueue_651328 {
    MyMinHeap_651328 heap = new MyMinHeap_651328();
    public void enqueue(int d) {
        if (!heap.isFull()) heap.insert(d);
    }
    public int dequeue() {
        if (!heap.isEmpty()) return heap.remove();
        return -1;
    }
    public int front() {
        return heap.peek();
    }
    public boolean isFull() {
        return heap.isFull();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public String toString() {
        return heap.toString();
    }
}
