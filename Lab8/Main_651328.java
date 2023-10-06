package Lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import Lab8.code.MyArrDemo_651328;
import Lab8.code.SillyLuckyNumber_651328;

public class Main_651328 {
    public static void main(String[] args) {
        // demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        testRuntime();
    }

    static void demo1() {
        System.out.println("-demo1---");
        SillyLuckyNumber_651328[] arr = {
                new SillyLuckyNumber_651328("Terrier"), new SillyLuckyNumber_651328("Jack"),
                new SillyLuckyNumber_651328("Pom"), new SillyLuckyNumber_651328("Beagle")
        };
        System.out.println(Arrays.toString(arr));
        // Comparator<SillyLuckyNumber> engine = new Comparator<>() {
        // @Override
        // public int compare(SillyLuckyNumber o1, SillyLuckyNumber o2) {
        // return Integer.compare(o1.getLuckyNumer(), o2.getLuckyNumer());
        // }
        // };
        Comparator<SillyLuckyNumber_651328> engine = (o1, o2) -> Integer.compare(o1.getLuckyNumer(), o2.getLuckyNumer());
        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }

    static void demo2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber_651328> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber_651328("Terrier"), new SillyLuckyNumber_651328("Jack"),
                new SillyLuckyNumber_651328("Pom"), new SillyLuckyNumber_651328("Beagle")));
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.getLuckyNumer(), o2.getLuckyNumer()));
        System.out.println(list);
    }

    static void demo3() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber_651328> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber_651328("Terrier"), new SillyLuckyNumber_651328("Jack"),
                new SillyLuckyNumber_651328("Pom"), new SillyLuckyNumber_651328("Beagle")));
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber_651328::getLuckyNumer));
        System.out.println(list);
        // demo shallow copy
        ArrayList<SillyLuckyNumber_651328> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed"); // Terrier
        System.out.println(list); // notice how Terrier in list is also effected
    }

    static void demo4() {
        System.out.println("-demo4----");
        MyArrDemo_651328<SillyLuckyNumber_651328> arr = new MyArrDemo_651328<>();
        arr.add(new SillyLuckyNumber_651328("Terrier"));
        arr.add(new SillyLuckyNumber_651328("Jack"));
        arr.add(new SillyLuckyNumber_651328("Pom"));
        arr.add(new SillyLuckyNumber_651328("Beagle"));
        System.out.println(arr);
        arr.swap(1, 3);
        System.out.println(arr);
    }

    static void demo5() {
        System.out.println("-demo5----");
        MyArrDemo_651328<SillyLuckyNumber_651328> arr = new MyArrDemo_651328<>();
        arr.add(new SillyLuckyNumber_651328("Terrier"));
        arr.add(new SillyLuckyNumber_651328("Jack"));
        arr.add(new SillyLuckyNumber_651328("Pom"));
        arr.add(new SillyLuckyNumber_651328("Beagle"));
        arr.add(new SillyLuckyNumber_651328("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber_651328("Basenji"));
        System.out.println(arr);
        selectionSort(arr);
        System.out.println(arr);
    }

    static void selectionSort(MyArrDemo_651328<SillyLuckyNumber_651328> arr) {
        for (int i = 0; i < arr.currentSize() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.currentSize(); j++) {
                if (arr.get(j).getLuckyNumer() < arr.get(minIndex).getLuckyNumer())
                    minIndex = j;
            }
            arr.swap(i, minIndex);
        }
    }

    public static void whatSortIsThis(int[] arr, int PREFERRED_SIZE) {
        int BLOCK_SIZE = arr.length / 4 > PREFERRED_SIZE ? PREFERRED_SIZE : arr.length / 4;
        for (int start = 0; start < arr.length; start += BLOCK_SIZE) {
            int end = Math.min(start + BLOCK_SIZE - 1, arr.length - 1);
            bite_size_sort(arr, start, end);
        }
        for (int mergeSize = BLOCK_SIZE; mergeSize < arr.length; mergeSize *= 2) {
            for (int left = 0; left < arr.length; left += 2 * mergeSize) {
                int mid = left + mergeSize - 1;
                int right = Math.min(left + 2 * mergeSize - 1, arr.length - 1);
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
        // System.out.println(Arrays.toString(arr));
    }

    private static void bite_size_sort(int[] b, int start, int end) {
        int i = start;
        for (; i < end; i++) {
            int j = i + 1;
            int tmp = b[j];
            while (j > start && b[j - 1] > tmp) {
                b[j] = b[j - 1];
                j--;
            }
            b[j] = tmp;
        }
    }

    private static void merge(int[] twob, int low, int mid, int high) {
        int[] leftArr = new int[mid - low + 1];
        int[] rightArr = new int[high - mid];
        System.arraycopy(twob, low, leftArr, 0, leftArr.length);
        System.arraycopy(twob, mid + 1, rightArr, 0, rightArr.length);
        int leftCounter = 0;
        int rightCounter = 0;
        int twobCounter = low;
        while (leftCounter < leftArr.length && rightCounter < rightArr.length) {
            twob[twobCounter++] = leftArr[leftCounter] < rightArr[rightCounter]
                    ? leftArr[leftCounter++] : rightArr[rightCounter++];
        }
        while (leftCounter < leftArr.length)
            twob[twobCounter++] = leftArr[leftCounter++];
        while (rightCounter < rightArr.length)
            twob[twobCounter++] = rightArr[rightCounter++];
    }

    private static void testRuntime() {
        int ARRAY_SIZE = 2_000_000;
        int[] arr32 = new int[1];
        int[] arr2048 = new int[1];
        ;
        int[] arr3 = new int[1];
        ;
        int numIter = 10;
        int[] size32Time = new int[numIter];
        int[] size2048Time = new int[numIter];
        int[] sizeSortTime = new int[numIter];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= ARRAY_SIZE; i++){
            list.add(i);
        }
        for (int i = 0; i < numIter; i++) {
            Collections.shuffle(list);
            arr32 = list.stream().mapToInt(Integer::intValue).toArray();
            arr2048 = list.stream().mapToInt(Integer::intValue).toArray();
            arr3 = list.stream().mapToInt(Integer::intValue).toArray();
            long startElapse = System.currentTimeMillis();
            whatSortIsThis(arr32, 32);
            size32Time[i] = (int) (System.currentTimeMillis() - startElapse);
            startElapse = System.currentTimeMillis();
            whatSortIsThis(arr2048, 2048);
            size2048Time[i] = (int) (System.currentTimeMillis() - startElapse);
            startElapse = System.currentTimeMillis();
            Arrays.sort(arr3);
            sizeSortTime[i] = (int) (System.currentTimeMillis() - startElapse);
        }
        System.out.println("confirm isSort " + isSort(arr32)
                + " " + isSort(arr2048) + " " + isSort(arr3));
        System.out.println("takes " + Arrays.toString(size32Time));
        System.out.println("takes " + Arrays.toString(size2048Time));
        System.out.println("takes " + Arrays.toString(sizeSortTime));
    }

    private static boolean isSort(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] > arr[i])
                return false;
        return true;
    }
}
