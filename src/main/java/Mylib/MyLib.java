package src.main.java.Mylib;

import java.util.ArrayList;
import java.util.Random;

public class MyLib {
    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i < array.length - 1 ? "," : "\n");
        }
    }

    public static ArrayList<Integer> getArrList(int N) {
        ArrayList<Integer> list = new ArrayList<>(N);
        Random rnd = new Random();
        for (int i = 0; i < N; i++) {
            list.add(i, rnd.nextInt(1, 10));
        }
        return list;
    }

    public static int[] getArrayInt(int N) {
        int[] array = new int[N];
        Random rnd = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = rnd.nextInt(1, 10);
        }
        return array;
    }


}
