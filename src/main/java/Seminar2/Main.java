package src.main.java.Seminar2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
//        task1(10,'A','B');
//        task1(11,'A','B');
        System.out.println( compressString("aaaasssddsdddaa"));
//        System.out.println(palindrom("шалаш"));
//        writeMyFile();
//        getMyListFiles();
    }

    public static void task1(int N, char c1, char c2) {
//        if (N<=0) return;
        StringBuilder result = new StringBuilder();
        while (N > 0) {
            result.append(c1);
            N--;
            if (N == 0) break;
            result.append(c2);
            N--;
        }
        System.out.println(result);
    }

    public static String compressString(String incomingString) {
        StringBuilder tempString = new StringBuilder();
        char charOld = incomingString.charAt(0);
        tempString.append(charOld);
        for (int i = 1; i < incomingString.length(); i++) {
            if (charOld != incomingString.charAt(i)) {
                tempString.append(incomingString.charAt(i));
                charOld = incomingString.charAt(i);
            }
        }
        return new String(tempString);
    }

    public static boolean palindrom(String incomingString) {
        return (incomingString.equals(new StringBuilder(incomingString).reverse().toString()));
    }


    public static String get100TEST() {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            content.append("TEST\n");
        }
        return content.toString();
    }

    public static void writeMyFile() {

        try {
            FileWriter writer = new FileWriter("TEST.txt");
            try {
                writer.write(get100TEST());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMyListFiles() {
        File dir = new File("C:\\MASTER\\Seminars");
        StringBuilder listFiles = new StringBuilder();
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                listFiles.append(item.getName() + '\n');
            }
        }
        try {
            FileWriter writer = new FileWriter("C:\\MASTER\\Seminars\\filelist.txt");
            try {
                writer.write(listFiles.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
