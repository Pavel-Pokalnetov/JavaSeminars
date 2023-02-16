package src.main.java.Seminar3;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    private static void task4() {
        List<ArrayList<String>> arList = new ArrayList<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("басни");
        list.add("мартышка и очки");

        arList.add(list);
        System.out.println(arList.get(0).get(0));

        for (ArrayList item : arList) {
            if (item.get(0).equals("басни")) {
                System.out.println(item);
            }

        }
    }

    private static void task3() {
        ArrayList<String> planet = new ArrayList<>(Arrays.asList(
                "Марс",
                "Земля",
                "Венера",
                "Меркурий",
                "Марс",
                "Юпитер",
                "Сатурн"));

        Collections.sort(planet);
        int count = 1;
        for (int i = 1; i < planet.size(); i++) {
            if (planet.get(i).equals(planet.get(i - 1))) {
                count++;
            } else {
                System.out.println(planet.get(i - 1) + " - " + count);
                count = 1;
            }
        }
        System.out.println(planet.get(planet.size() - 1) + " - " + count);


        System.out.println(planet);

        for (int i = 1; i < planet.size(); i++) {
            if (planet.get(i).equals(planet.get(i - 1))) {
                planet.remove(i);
                i--;
            }
        }


        System.out.println(planet);
    }


    private static void task2() {
        ArrayList<Integer> array = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            array.add(i, new Random().nextInt(0, 100));
        }
        Collections.sort(array);

        System.out.println(array);


    }

    private static void task1() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        System.out.println(s1 == s1);
        System.out.println(s3 == s1);
        System.out.println(s2 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1.equals(s5));
        System.out.println(s5 == s6);
        System.out.println(s5.equals(s6));
    }


}

