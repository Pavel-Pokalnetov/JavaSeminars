package HomeWork4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Compiler.command;

public class Menu {
    HashMap<Character, ArrayList<Object>> menu_list;

    public Menu() {
        this.clean();
    }

    /**
     * Добавление пунктов меню
     *
     * @param a           - пункт меню
     * @param description - описание
     * @param method      - метод для выполнения
     */
    public void add(Character a, String description, Object method) {
        ArrayList<Object> menu_point = new ArrayList<>();
        menu_point.add(description);
        menu_point.add(method);
        menu_list.put(a, menu_point);
    }

    /**
     * Очистка пунктов меню
     */
    public void clean() {
        menu_list = new HashMap<>();
    }

    public void print() {
        for (Character a : menu_list.keySet()) {
            System.out.printf("%3s - %s\n", a, menu_list.get(a).get(0));
        }

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String key;
        ArrayList<Character> menu_points = new ArrayList<>();
        ArrayList<Object> menu_commands = new ArrayList<>();
        for (Character a : menu_list.keySet()) {
            menu_points.add(a);
            menu_commands.add();
        }
        this.print();
        System.out.print("  > ");
        while(true){
            key = scanner.next();
            for (Character a: menu_points) {
                if (key.equals(a.toString())){
                    //сработал пункт меню
                    if (menu_list.get(a).get(1)==null){
                        //выход из меню
                        return;
                    }else {
                        Object command = menu_points.get(a).get(1);
                        return command();
                    }
                };
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add('1', "Пункт 1", null);
        menu.add('2', "Пункт 2", null);
        menu.add('3', "Пункт 3", null);
        menu.add('4', "Пункт 4", null);
        menu.run();
    }


}
