package src.main.java.Mylib;

public class Timer {
    long timer;

    public Timer() {
        timer = System.nanoTime();
    }

    public void start() {
        timer = System.nanoTime();
    }

    public void fix() {
        System.out.printf("время %d наносекунд\n",System.nanoTime() - timer);
        timer = System.nanoTime();
    }
}
