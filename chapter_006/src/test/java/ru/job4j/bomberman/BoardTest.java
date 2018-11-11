package ru.job4j.bomberman;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void whenTwoPlaersWalkTenSecondAndStop() throws InterruptedException {
        Board board = new Board(3, 3);
        Player player1 = new Player(board, new Cell(0, 0));
        Player player2 = new Player(board, new Cell(2, 2));
        Thread thread1 = new Thread(player1);
        thread1.setName("player1");
        thread1.start();
        Thread thread2 = new Thread(player2);
        thread2.setName("player2");
        thread2.start();
        TimeUnit.SECONDS.sleep(10);
        thread1.interrupt();
        thread2.interrupt();
        thread1.join();
        thread2.join();
        assertTrue(thread1.getState().toString() == "TERMINATED");
        assertTrue(thread2.getState().toString() == "TERMINATED");
    }
}