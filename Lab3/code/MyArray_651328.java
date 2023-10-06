package Lab3.code;

import java.util.Arrays;

public class MyArray_651328 {
    protected int MAX_SIZE;
    protected int data[] ;
    protected int size = 0;

    public MyArray_651328() {
        MAX_SIZE = 100_100;
        data = new int[MAX_SIZE];
    }

    public MyArray_651328(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public void add(int d) {
        if (isFull()){
            data = expand();
        }
        data[size] = d;
        size++;
    }

    public void insert(int d, int index) {
        data[size++] = data[index];
        data[index] = d;
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b = size - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (data[m] == d)
                return m;
            if (d < data[m])
                b = m - 1;
            else
                a = m + 1; // d>data[m]
        }
        return -1;
    }

    public void delete(int index) {
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = 0;
            size--;
        }
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // implicitly allocate a k * MAX_SIZE array to prevent overflow addition (add()
    // method)
    public int[] expandByK(int k) {
        MAX_SIZE = k * MAX_SIZE;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        return newData;
    }

    public int[] expand(){
        return expandByK(2);
    }

    @Override
    public String toString() {
        return "MyArrayBasic [MAX_SIZE=" + MAX_SIZE + ", data=" + Arrays.toString(data) + ", size=" + size + "]";
    }
}
