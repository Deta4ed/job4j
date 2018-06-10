package ru.job4j.chess.figures.team;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Rook extends Figure {
    public Rook(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (source.x != dest.x && source.y != dest.y || source.equals(dest)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        int stepX = Integer.compare(dest.x,source.x);
        int stepY = Integer.compare(dest.y,source.y);
        int count = Math.abs(source.x - dest.x) > Math.abs(source.y - dest.y) ? Math.abs(source.x - dest.x) : Math.abs(source.y - dest.y);
        Cell[] steps = new Cell[count];
        for (int index = 1; index <= count; index++) {
            steps[index - 1] = Cell.findBy(source.x + index * stepX, source.y + index * stepY);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Rook(dest, this.team);
    }
}
