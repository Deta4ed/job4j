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
        if (Math.abs(source.x - dest.x) + Math.abs(source.y - dest.y) != 3) {
           throw new ImpossibleMoveException("Impossible move exception!");
        }
        Cell[] steps = new Cell[1];
        steps[0] = dest;
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Knight(dest, this.team);
    }
}
