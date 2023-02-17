package src.main.java.HomeWork3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static src.main.java.Mylib.MyLib.*;

/*
1 Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
2 Пусть дан произвольный список целых чисел, удалить из него четные числа
3* Реализовать алгоритм сортировки слиянием
*/
public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        int[] array = getArrayInt(20);


    }

    private static void task2() {
        //Пусть дан произвольный список целых чисел, удалить из него четные числа
        ArrayList<Integer> list = getArrList(7);

        Iterator iterList = list.iterator();
        System.out.println(list);
        while (iterList.hasNext()) {
            if (isEven((int) iterList.next())) iterList.remove();
        }

        System.out.println(list);
    }

    private static void task1() {
        //Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
        ArrayList<Integer> list = getArrList(20);

        int min = list.get(0);
        int max = min;
        double aver = min;
        for (int item : list) {
            aver += item;
            if (min > item) {
                min = item;
            } else if (max < item) {
                max = item;
            }
        }
        aver /= list.size();

        System.out.printf("min=%d, max=%d, average=%.2f\n", min, max, aver);
        System.out.println(list);
    }


    public static boolean isEven(int N) {
        //проверка на четность
        return (N % 2 == 0);
    }

}
