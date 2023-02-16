package src.main.java.Mylib;

import java.util.ArrayList;

public class MyLib {
    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i < array.length - 1 ? "," : "\n");
        }}


}
