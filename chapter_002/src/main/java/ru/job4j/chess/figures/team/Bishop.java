package ru.job4j.chess.figures.team;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Bishop extends Figure {

    public Bishop(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y) || source.equals(dest)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int stepX = Integer.compare(dest.x, source.x);
        int stepY = Integer.compare(dest.y, source.y);
        for (int index = 1; index <= Math.abs(source.x - dest.x); index++) {
            steps[index - 1] = Cell.findBy(source.x + index * stepX, source.y + index * stepY);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest, this.team);
    }
}
