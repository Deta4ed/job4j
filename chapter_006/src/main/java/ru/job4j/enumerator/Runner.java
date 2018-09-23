package ru.job4j.enumerator;

public class Runner implements Runnable {
    private final Enumerator enumerator;

    public Runner(Enumerator enumerator) {
        this.enumerator = enumerator;
    }

    @Override
    public void run() {
        while (enumerator.get() < 20) {
            enumerator.add();
            System.out.println(String.format("Поток: %s - установлено значение - %s", Thread.currentThread().getName(), enumerator.get()));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
