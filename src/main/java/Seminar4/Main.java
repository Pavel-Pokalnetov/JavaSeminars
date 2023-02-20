package Seminar4;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        task1();




    }

    private static void task1() {
        // сгенерировать 100 случайных чисел и посчитать их количество по номиналу
        Random rnd = new Random();
        Integer randomNumber;
        HashMap<Integer,Integer> counts = new HashMap<>(100);
        for (int i = 0; i < 100; i++) {
            randomNumber = rnd.nextInt(0,99);
            if (counts.get(randomNumber)==null){
                counts.put(randomNumber,1);
            }else {
                counts.put(randomNumber,(1+counts.get(randomNumber)));
            }
        }
    }
}
