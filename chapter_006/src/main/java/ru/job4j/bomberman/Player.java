package ru.job4j.bomberman;

import java.util.Random;

public class Player implements Runnable {
    private final Board board;
    private final Direction[] directionValues = Direction.values();
    private static final Random RN = new Random();
    private Cell cell;

    public Player(Board board, Cell cell) {
        this.board = board;
        this.cell = cell;
    }

    private Cell getCell(Cell source) {
        boolean selected = false;
        Cell dest = source;
        while (!selected) {
            Direction direction = directionValues[RN.nextInt(3)];
            dest = new Cell(source.getX() + direction.x, source.getY() + direction.y);
            selected = board.validCell(dest);
        }
        return dest;
    }

    @Override
    public void run() {
        board.setLock(cell.getX(), cell.getY());
        while (!Thread.currentThread().isInterrupted()) {
            final Cell dest = getCell(cell);
            try {
                if (board.move(cell, dest)) {
                    cell = dest;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
