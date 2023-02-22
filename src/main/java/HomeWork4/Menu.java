package HomeWork4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Compiler.command;

public class Menu {
    HashMap<String, String> menu_list;

    public Menu() {
        this.clean();
    }

    /**
     * Добавление пунктов меню
     *
     * @param a           - пункт меню
     * @param description - описание
     */
    public void add(Character a, String description) {
        menu_list.put(a, description);
    }

    /**
     * Очистка пунктов меню
     */
    public void clean() {
        menu_list = new HashMap<>();
    }

    public void print() {

        for (String a : menu_list.keySet()) {
            System.out.printf("%3s - %s\n", a, menu_list.get(a));
        }

    }

    public String run() {
        Scanner scanner = new Scanner(System.in);
        String key;
        this.print();
        while (true) {
            System.out.print("  >:");
            key = scanner.next();
            if (menu_list.get(key) != null) {
                // сработал пункт меню
                scanner.close();
                return key;
            }
            System.out.println("\033[2A");
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add('1', "Пункт 1");
        menu.add('2', "Пункт 2");
        menu.add('3', "Пункт 3");
        menu.add('4', "Пункт 4");
        switch (menu.run()) {
            case "1":
                System.out.println(1);
                break;
            case "2":
                System.out.println(2);
                break;
            case "3":
                System.out.println(3);
                break;
            case "4":
                System.out.println(4);
                break;

        }

    }

}
