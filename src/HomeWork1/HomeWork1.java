package HomeWork1;

import java.util.Scanner;

/*
1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
2. Вывести все простые числа от 1 до 1000 
3. Реализовать простой калькулятор
4. *+Задано уравнение вида q + w = e, q, w, e >= 0.
    Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение 
    или сообщить, что его нет.

 */
public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println("Треугольное число при n равном 5:  " + task1(5));
        System.out.println("Факториал 6 = " + task11(6));
        task2(1000);
        System.out.println();
        task3();
    }

    public static int task1(int n) {
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n)
        int number = 1;
        for (int i = 2; i < n; i++)
            number += i;
        return number;
    }

    public static int task11(int n) {
        // Вычислить n! (факториал)
        if (n == 1)
            return 1;
        int factorial = task11(n - 1) * n;
        return factorial;
    }

    static boolean testPrimeNumber(int x) {
        // проверка числа на принадлежность к простым числам
        int d = 2;
        while (x % d != 0 && d < x)
            d++;
        return (d == x);
    }

    public static void task2(int n) {
        // Вывести все простые числа от 1 до 1000
        for (int i = 1; i <= n; i++) {
            if (testPrimeNumber(i))
                System.out.print(i + ", ");
        }
    }

    public static void task3() {
        // Реализовать простой калькулятор
        double result = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите первый операнд: ");
            double a = scanner.nextDouble();
            System.out.print("Введите второй операнд: ");
            double b = scanner.nextDouble();
            System.out.print("Введите операцию (+ - / *): ");
            char command = scanner.next().charAt(0);
            switch (command) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        System.out.println("Error!!! Деление на 0");
                    } else {
                        result = a / b;
                    }
                    break;
                default:
                    System.out.println("неверная операция");
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
        }

    }
}
