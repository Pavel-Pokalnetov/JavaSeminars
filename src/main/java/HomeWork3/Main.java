package src.main.java.HomeWork3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static src.main.java.Mylib.MyLib.*;

/*
1 Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
2 Пусть дан произвольный список целых чисел, удалить из него четные числа
3* Реализовать алгоритм сортировки слиянием
*/
public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println("\n----------------\n");
        task2();
        System.out.println("\n----------------\n");
        task3();
        System.out.println("\n----------------\n");


    }

    private static void task3() {
        // повторение алгоритма Джон фон Нейман для лент
        int[] array = new int[]{5,6,8,4,5,4,4,6,9,8,9,1,2,62,5,3,1,1};
        System.out.printf(" ---- исходный массив размером %d---- \n", array.length);
        printArray(array);
        System.out.print(" сортировка из java:  ");
        printArray(Arrays.stream(array).sorted().toArray());
        System.out.print(" сортировка слиянием: ");
        printArray(arraySortFonNejman(array));
    }

    private static int[] arraySortFonNejman(int[] array) {
        // повторение алгоритма сортировки Джон фон Нейман для магнитных лент
        // или алгоритм сортировки слиянием


        int[] tapeA = new int[array.length]; // лента А
        int[] tapeB = new int[array.length]; // лента B

        boolean isNotSorted = true; // флаг состояния массива
        int index, indexA, indexB, endA, endB; //индексы чтения/записи массивов(лент) и метки конца
        int max_index = array.length;
        boolean state; // true - пишем в ленту А, false - в ленту B

        while (isNotSorted) {
            isNotSorted = false; // сначала считаем, что массив отсортирован

            // распределяем исходным массив по лентам А и Б
            state = true;
            indexA = 0;
            indexB = 0;
            endA = 0;
            endB = 0;
            tapeA[indexA++] = array[0];
            for (index = 1; index < max_index; index++) {
                if (array[index] < array[index - 1]) {
                    state = !state;     // если элементы не по порядку то меняем ленту для записи
                    isNotSorted = true; // если были не сортированные элементы, то запоминаем это
                }
                if (state) {
                    // запись в ленту А
                    tapeA[indexA++] = array[index];
                    endA = indexA;
                } else {
                    // запись в ленту B
                    tapeB[indexB++] = array[index];
                    endB = indexB;
                }

            }
            if (!isNotSorted) { // если оказалось,что массив отсортирован
                return array;  // то сразу возвращаем его
            }
            // собираем модифицированный массив из лент А и Б
            indexA = 0;
            indexB = 0;
            for (index = 0; index < max_index; index++) {
                //проверяем не закончились ли вспомогательные ленты(массивы)
                if (indexA == endA) {
                    //если закончилась лента А - переносим все остатки из B
                    array[index] = tapeB[indexB++];
                    continue;
                }
                if (indexB == endB) {
                    //если закончилась лента B - переносим все остатки из А
                    array[index] = tapeA[indexA++];
                    continue;
                }
                // перенос в основной массив из воспомогательный с учетом "веса" числа
                if (tapeA[indexA] <= tapeB[indexB]) {
                    array[index] = tapeA[indexA++];
                } else {
                    array[index] = tapeB[indexB++];
                }
            }
        }
        return array;
    }

    private static void task2() {
        // Пусть дан произвольный список целых чисел, удалить из него четные числа
        ArrayList<Integer> list = getArrayListInt(7);

        Iterator iterList = list.iterator();
        System.out.println(list);
        while (iterList.hasNext()) {
            if (isEven((int) iterList.next())) iterList.remove();
        }

        System.out.println(list);
    }

    private static void task1() {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
        ArrayList<Integer> list = getArrayListInt(20);
        System.out.println(list);
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
    }


    public static boolean isEven(int N) {
        //проверка на четность
        return (N % 2 == 0);
    }

}
