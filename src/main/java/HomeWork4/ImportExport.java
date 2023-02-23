package HomeWork4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImportExport {

    static void pBexport(PhoneBook phoneBook) {
        String json = phoneBook.get_json();
        File jsonFile = new File("phonebook.json");
        try (FileWriter jsonFileWriter = new FileWriter(jsonFile)) {
            jsonFileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pBimport(PhoneBook phoneBook) {
        File jsonFile = new File("phonebook.json");

    }
}
