package Lab9.code;

public class MyMinHeap_651328 {
    int MAX_SIZE = 6;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    public void insert(int d) {
        if (isFull())
            return;
        int p = size++;
        heap[p] = d;
        int parent = (p - 1) / 2;
        while ((p > 0) && (heap[p] < heap[parent])) {
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;

    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        int p = 0;
        while (true) {
            int left = 2 * p + 1;
            if (left >= size)
                break; // no child
            int right = 2 * p + 2;
            if (right == size) { // one child
                if (heap[p] > heap[left])
                    swap(p, left);
                break; // no more child, nothing to do
            } else { // two childs
                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q])
                    swap(p, q);
                else
                    break;
                p = q;
            }
        } // end while
        return d;
    }

    public int peek() {
        return heap[0];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            int parent = heap[i];
            int left = 2 * i + 1 < size ? heap[2 * i + 1] : 0;
            int right = 2 * i + 2 < size ? heap[2 * i + 2] : 0;
            
            s = s + "PARENT : " + parent + " LEFT CHILD : " + left + " RIGHT CHILD :" + right
                    + "\n";
        }
        return s;
    }
}