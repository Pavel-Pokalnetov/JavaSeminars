package src.main.java.HomeWork1;

import java.util.Scanner;

/*
1.1 Вычислить n-ое треугольного число(сумма чисел от 1 до n),
1.2 Вычислить n! (произведение чисел от 1 до n)
2.  Вывести все простые числа от 1 до 1000
3.  Реализовать простой калькулятор
4*. Задано уравнение вида q + w = e, q, w, e >= 0.
    Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение 
    или сообщить, что его нет.
 */
public class HomeWork1 {
    public static void main(String[] args) {
        // Задача 1.1
        {
            System.out.println("Задание 1");
            System.out.print("Введите n: ");
            int n = new Scanner(System.in).nextInt();
            System.out.println("T(n)=" + triangularNumber(n));
        }

        // Задача 1.2
        {
            System.out.println("Задание 1.1");
            System.out.print("Введите n: ");
            int n = new Scanner(System.in).nextInt();
            System.out.println("n!=" + factorial(n));
        }

        // Задача 2
        {
            System.out.print("Поиск простых чисел от 1 до N, введите N:");
            int n = new Scanner(System.in).nextInt();
            System.out.printf("Простые числа от 1 до %s: ", n);
            System.out.println(simpleNumber(n));
        }
        // Задача 3
        {
            System.out.println("Введите выражение, формат:  X + Y ENTER");
            String stringExpr = new Scanner(System.in).nextLine();
            System.out.printf("%s = %s\n", stringExpr, simpleCalc(stringExpr));
        }

        // Задача 4

        findRightExpression("2? + ?5 = 69"); // 24 + 45
        findRightExpression("?6 * 2?4 = 6084.0"); // 26 * 6084
        findRightExpression("?6 * 2?4 = 6034.0"); // нет решения



    }

    public static int triangularNumber(int n) {
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n)
        int number = 1;
        for (int i = 2; i < n; i++)
            number += i;
        return number;
    }

    public static int factorial(int n) {
        // Вычислить n! (факториал)
        if (n == 1)
            return 1;
        return factorial(n - 1) * n;
    }

    static boolean testPrimeNumber(int x) {
        // проверка числа на принадлежность к простым числам
        int d = 2;
        while (x % d != 0 && d < x)
            d++;
        return (d == x);
    }

    public static StringBuilder simpleNumber(int n) {
        // Вывести все простые числа от 1 до 1000
        StringBuilder resuls = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (testPrimeNumber(i)) {
                resuls.append(String.valueOf(i));
                resuls.append(',');
            }
        }
        resuls.deleteCharAt(resuls.length() - 1);
        return resuls;
    }

    public static double simpleCalc(String stringExpr) {
        // простой калькулятор
        class InvalidCommand extends Exception {
            //класс исключения для отлова неверно введенной команды в калькуляторе
        }
        double a, b, result;
        char command;
        String[] exprArray = stringExpr.split(" ");
        try {
            a = Double.parseDouble(exprArray[0]);
            b = Double.parseDouble(exprArray[2]);
            command = exprArray[1].charAt(0);

            result = switch (command) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> a / b;
                default -> throw (new InvalidCommand());
            };

            return (result);

        } catch (ArithmeticException e) {
            System.out.println("Вычислительная ошибка, возможно деление на 0");
            throw (new RuntimeException(e));
        } catch (InvalidCommand e) {
            System.out.println("Неправильная арифметическая команда");
            throw (new RuntimeException(e));
        }
    }


    private static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i < array.length - 1 ? "," : "\n");
        }

    }

    public static void findRightExpression(String userExpr) {
        System.out.println(userExpr);
        String[] expr = userExpr.split("=")[0].split(" ");
        Double result = Double.parseDouble(userExpr.split("=")[1]);
//        printArray(expr);
//        System.out.println(result);
        String a = expr[0];
        char command = expr[1].charAt(0);
        String b = expr[2];
        int counter = 0;
        String testExpression;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                testExpression = a.replace("?", String.valueOf(i)) +
                        " " + command + " " +
                        b.replace("?", String.valueOf(j));
                if (simpleCalc(testExpression) == result) {
                    System.out.println(testExpression + " = " + result);
                    counter++;
                }
            }
        }
        if (counter==0) System.out.println("Решений данного выражения нет");
        System.out.println();
    }
}



