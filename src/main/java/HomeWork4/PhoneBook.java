package HomeWork4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    HashMap<String, HashSet<String>> book;

    public PhoneBook() {
        book = new HashMap<>();

    }

    /**
     * Добавить телефонный номер в книгу
     *
     * @param login - логин (уникальный)
     * @param phone - номер телефона для добавления
     */
    public void add(String login, String phone) {
        HashSet<String> phones;
        if (book.get(login) != null) {
            phones = book.get(login);
        } else {
            phones = new HashSet<>();
        }
        phones.add(phone);
        book.put(login, phones);
    }

    /**
     * Получить логин по номеру телефона
     *
     * @param phone (String) - номер телефона для поиска логина
     * @return (String) - найденный логин, либо null
     */
    public ArrayList<String> find_login(String phone) {
        HashSet<String> phones;
        ArrayList<String> logins = new ArrayList<>();
        for (String login : book.keySet()) {
            phones = book.get(login);
            if (phones.contains(phone)) {
                logins.add(login);
            }
        }
        return logins;
    }

    /**
     * Получить список номеров телефонов по введенному логину
     *
     * @param login - логин для получения списка телефонов
     * @return - список телефонов с разделителем \n
     */
    public ArrayList<String> find_phone(String login) {
        // полу
        if (book.get(login) == null) {
            return null;
        }
        return new ArrayList<>(book.get(login));
    }

    /**
     * Удаление номера из всей книги (сквозной поиск)
     *
     * @param phone - номер для удаления
     */
    public void remove_phone(String phone) {
        ArrayList<String> logins = this.find_login(phone);
        for (String login : logins) {
            book.get(login).remove(phone);
        }
        this.clean();
    }

    /**
     * Удаление записи по логину
     *
     * @param login - удаляемый логин
     */
    public void remove_login(String login) {
        book.remove(login);
    }

    /**
     * Замена старого номера на новый
     *
     * @param login     - выбранный логин
     * @param new_phone - новый номер
     * @param old_phone - старый (удаляемый)
     */
    public void replace_phone_from_login(String login, String new_phone, String old_phone) {
        HashSet<String> phones = book.get(login);
        if (phones != null) {
            phones.remove(old_phone);
            phones.add(new_phone);
            book.put(login, phones);
        }
        this.clean();
    }

    /**
     * Очистка книги от пустых записей (не содержащих номеров)
     */
    private void clean() {
        ArrayList<String> logins = new ArrayList<>(book.keySet());
        for (String login : logins) {
            if (book.get(login).isEmpty()) {
                book.remove(login);
            }
        }
    }

    /**
     * Печать книги (для отладки)
     */
    public void print() {
        int n = 1;
        for (String login : book.keySet()) {
            System.out.printf("%d. %s: ", n, login);
            System.out.println(this.find_phone(login));
            n++;
        }
    }

    /**
     * Возвращает JSON всей тел.книги
     */
    public String get_json() {
        StringBuilder json = new StringBuilder("{\n");
        for (String login : book.keySet()) {
            json.append(String.format("\"%s\":{\"phone\":[", login));
            for (String phone : this.find_phone(login)) {
                json.append(String.format("\"%s\",", phone));
            }
            json.deleteCharAt(json.length() - 1);
            json.append("]},\n");
        }
        json.deleteCharAt(json.length() - 2);
        json.append("}");
        return json.toString();
    }

    public static ArrayList<String> get_All_logins(HashMap<String, HashSet<String>> book) {
        return new ArrayList<>(book.keySet());
    }

    public void testload() {
        this.add("admin", "1000");
        this.add("admin", "1001");
        this.add("admin", "1002");
        this.add("modrator", "2000");
        this.add("superadmin", "0000");
        this.add("user1", "3-12-45");
        this.add("user2", "3-24-05");
    }

//    public static void main(String[] args) {
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("admin", "999");
//        phoneBook.add("admin", "9991");
//        phoneBook.add("admin", "100");
//        phoneBook.add("modrator", "200");
//        phoneBook.add("superadmin", "000");
//        phoneBook.add("user1", "325");
//        phoneBook.add("user2", "345");
//        System.out.println(phoneBook.get_json());
//
//    }
}