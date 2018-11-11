package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private final ReentrantLock[][] board;
    private final int width;
    private final int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new ReentrantLock[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    public boolean  move(Cell source, Cell dest) throws InterruptedException {
        boolean result = false;
        if (board[dest.getX()][dest.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
            result = true;
            board[source.getX()][source.getY()].unlock();
            System.out.println(String.format("Thread %s made a move out (%d : %d) on (%d : %d)",
                    Thread.currentThread().getName(),
                    source.getX(),
                    source.getY(),
                    dest.getX(),
                    dest.getY()
            ));
        } else {
            System.out.println(String.format("Thread %s could not make a move out (%d : %d) on (%d : %d)",
                    Thread.currentThread().getName(),
                    source.getX(),
                    source.getY(),
                    dest.getX(),
                    dest.getY()
            ));
        }
        return result;
    }

    public boolean validCell(Cell cell) {
        return (cell.getX() >= 0 && cell.getX() < board.length)
                && (cell.getY() >= 0 && cell.getY() < board.length);
    }

    public void setLock(int x, int y) {
        board[x][y].lock();
    }
}
