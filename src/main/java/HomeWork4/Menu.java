package HomeWork4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
    public void add(String a, String description) {
        menu_list.put(a, description);
    }

    /**
     * Очистка пунктов меню
     */
    public void clean() {
        menu_list = new HashMap<>();
    }

    public void print() {
        ArrayList<String> menu_items = new ArrayList<String>(menu_list.keySet());
        Collections.sort(menu_items);
        for (String a : menu_items) {
            System.out.printf("%3s - %s\n", a, menu_list.get(a));
        }

    }

    public String run() {
        String key;
        while (true) {
            this.print();
            System.out.print("  >:");
            key = Actions.input();
            if (menu_list.get(key) != null) {
                // сработал пункт меню
                return key;
            }
        }
    }

}
