package Lab3.code;

import java.util.Arrays;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public void add(int d) {
        if (size < MAX_SIZE) {
            data[size] = d;
            size++;
        }
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

    // a constructor creating the first MAX_SIZE
    public MyArrayBasic(int... a) {
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                add(a[i]);
            }
        }

    }

    // a constructor creating an empty array
    public MyArrayBasic() {
    }

    @Override
    public String toString() {
        return "MyArrayBasic [MAX_SIZE=" + MAX_SIZE + ", data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

}