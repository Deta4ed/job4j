package ru.job4j.chess.figures.team;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Knight extends Figure {
    public Knight(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (Math.abs(source.x - dest.x) == 2 && Math.abs(source.y - dest.y) == 1
                || Math.abs(source.x - dest.x) == 1 && Math.abs(source.y - dest.y) == 2) {
            steps = new Cell[1];
            steps[0] = dest;
        }
        if (steps.length == 0 && !source.equals(dest)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Knight(dest, this.team);
    }
}
