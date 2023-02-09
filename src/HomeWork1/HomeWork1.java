package HomeWork1;

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
    }

    public static int task1(int n) {
        int number = 1;
        for (int i = 2; i < n; i++)
            number += i;
        return number;
    }

    public static int task11(int n) {
        if (n == 1)
            return 1;
        int factorial = task11(n - 1) * n;
        return factorial;
    }

    static boolean testPrimeNumber(int x) {

        int d = 2;
        while (x % d != 0 && d < x)
            d++;
        return (d == x);
    }

    public static void task2(int n) {

        for (int i = 1; i <= n; i++) {
            if (testPrimeNumber(i)) System.out.println(i);
        }
    }

}
