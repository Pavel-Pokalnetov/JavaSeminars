package HomeWork5;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/*
* Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.

Example 1:
Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].

Example 2:
Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

* */
public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        findMaxSubArray(nums1, nums2);
        System.out.println();
    }

    private static void task2() {
        int[] nums1 = new int[]{0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{9, 0, 1, 0, 2, 1};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        findMaxSubArray(nums1, nums2);
        System.out.println();
    }
//==========================================================================

    /**
     * @param nums1 - первый массивов
     * @param nums2 - второй массивов
     * @return -  подмассив максимального размера
     */
    private static void findMaxSubArray(int[] nums1, int[] nums2) {

        HashSet<ArrayList<Integer>> tempSet1 = getAllSet(nums1);  // получаем множества
        HashSet<ArrayList<Integer>> tempSet2 = getAllSet(nums2);  // подмассивов каждого входного массива
        tempSet2.retainAll(tempSet1); // находим пересечение множеств
        int max = 0;
        for (ArrayList<Integer> item : tempSet2) { // находим самы большой размер подмассива
            if (max < item.size()) {
                max = item.size();
            }
        }
        ArrayList<ArrayList<Integer>> resultArrays = new ArrayList<>();
        for (ArrayList<Integer> item : tempSet2) { // сохраняем найденные подмассивы с список
            if (max == item.size()) {
                resultArrays.add(item);
            }
        }
        if (resultArrays.size()==0){
            System.out.println("Нет повторяющихся подмассивов");
            return;
        }
        if (resultArrays.size() > 1) {
            System.out.println("Найдено несколько подмассивов максимального размера: ");
        } else {
            System.out.println("Подмассив максимального размера равен: ");
        }
        System.out.println(resultArrays);
    }

    /**
     * Возвращает множество подмассивов исходного массива
     *
     * @param array - исходный массив
     * @return - множество подмассивов исходного массива
     */
    private static HashSet<ArrayList<Integer>> getAllSet(int[] array) {
        HashSet<ArrayList<Integer>> tempSet = new HashSet<>();
        for (int n = 1; n <= array.length; n++) {
            for (int i = 0; i < array.length; i++) {
                ArrayList<Integer> tempArray = new ArrayList<>();
                for (int j = i; j < i + n; j++) {
                    if (j >= array.length) break;
                    tempArray.add(array[j]);
                }
                if (tempArray.size() >= 2) {
                    tempSet.add(tempArray);
                }
            }
        }
        return tempSet;
    }
}
