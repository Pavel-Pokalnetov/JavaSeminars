package HomeWork4;

public class MainApp {
    public static PhoneBook phoneBook;

    public static void main(String[] args) {
        phoneBook = new PhoneBook();
        mainLoop();
    }

    private static void mainLoop() {
        // главное меню
        Menu menu = new Menu();
        menu.add("1", "Добавить запись");
        menu.add("2", "Вывод всех записей");
        menu.add("3", "Поиск логина по номеру");
        menu.add("4", "Поиск номера(ов) по логину");
        menu.add("5", "Изменить запись");
        menu.add("6", "Удаление номера");
        menu.add("7", "Удаление записи по логину");
        menu.add("8", "Импорт/Экспорт");
        menu.add("9", "Выход");
        while (true) {
            switch (menu.run()) {
                case "1":
                    Actions.add_number(phoneBook);
                    break;
                case "2":
                    Actions.view_all(phoneBook);
                case "3":
                    Actions.find_login(phoneBook);
                    break;
                case "4":
                    Actions.find_phones(phoneBook);
                    break;
                case "5":
                    Actions.edit(phoneBook);
                    break;
                case "6":
                    Actions.remove_numbers(phoneBook);
                    break;
                case "7":
                    Actions.remove_login(phoneBook);
                    break;
                case "8":
                    Actions.import_export(phoneBook);
                    break;
                case "9":
                    return;
            }
        }
    }

}



