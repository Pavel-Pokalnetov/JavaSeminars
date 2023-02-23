package HomeWork4;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

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
        class PhoneBookRecord {
            private String login;
            private String[] phones;

            public void setLogin(String login) {
                this.login = login;
            }

            public void setPhones(String[] phones) {
                this.phones = phones;
            }
        }
        PhoneBook newPhoneBook = new PhoneBook();
        InputStream input = null;
        try {
            input = new FileInputStream("phonebook.json");
        } catch (FileNotFoundException e) {
            System.out.println("файл phonebook.json не найден");
            return;
        }
        JsonReader reader = Json.createReader(input);
        JsonObject rootJSON = reader.readObject();
        reader.close();
        JsonObject pbJSON = rootJSON.getJsonObject("phonebook");
        System.out.println(pbJSON.toString());

    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.testload();
        pBexport(pb);
    }
}
