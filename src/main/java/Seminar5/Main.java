package Seminar5;

public class Main {

    public static void main(String[] args) {


//        task1();


    }

    private static void task1() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        StringBuilder result = new StringBuilder();
        for (int index : indices) {
            result.append(s.charAt(index));
        }
        System.out.println(result);
    }

}
