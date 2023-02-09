package Seminar1;

import java.lang.reflect.Array;
import java.text.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        /*
        System.out.println("Hello world!");

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        System.out.println("Текущая дата " + formatForDateNow.format(dateNow));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваше имя?: ");
        String userName = scanner.next();
        System.out.println("Привет, " + userName);

        int hour = LocalTime.now().getHour();

        if (hour >= 5 && hour < 12) {
            System.out.print("Доброе утро, ");
        } else if (hour >= 12 && hour < 18) {
            System.out.print("Добрый день, ");
        } else if (hour >= 18 && hour < 23) {
            System.out.print("Добрый вечер, ");
        } else {
            System.out.print("Доброй ночи, ");
        }
        System.out.println(userName);
        */
//        int array[] = new int[] {1,1,0,1,1,0,0,1,0,1,1,1,1,0,0,0};
//        int max = 0;
//        int count=0;
//        for (i=0;i<array.length;i++){
//            if (array[i]==1){
//                count++;
//                if (count > max) {
//                    max=count;
//                }else{
//                    count=0;
//                }
//            }
//        }

//        int array[] = new int[]{3, 60, 3, 4, 7, 2, 3, 1, 2, 8, 4, 5, 6, 3, 3, 2, 7, 5};
//        for (int i : array) {
//            System.out.print(i + ", ");
//        }
//        System.out.println();
//
//        int etalon = 3;
//
//        int temp[] = new int[array.length];
//        int index = 0;
//        for (int item : array) {
//            if (item != etalon) {
//                temp[index] = item;
//                index++;
//            }
//        }
//
//        for (int i = index; i < array.length; i++) {
//            temp[i] = etalon;
//        }
//        array = temp;
//        for (int i : array) {
//            System.out.print( i + ", ");
//        }
        String strings[] = new String[]{
                "кот",
                "котик",
                "котенок",
                "котофей"};

        int minLen = strings[0].length();
        for (String string : strings) {
            minLen = string.length() < minLen ? string.length() : minLen;
        }
        int count = 0;
        char sym;
        boolean flag = false;
        for (int i = 0; i < minLen; i++) {
            sym = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++) {
                if (sym != strings[j].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            count++;
        }
        StringBuffer prefix= new StringBuffer();
        prefix.append(strings[0],0,count);
        System.out.println("Максимальный общий префикс: \"" + prefix + "\", длинной " + count+" символа(ов)");
    }
}