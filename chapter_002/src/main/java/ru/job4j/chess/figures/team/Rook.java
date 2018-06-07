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
        Cell[] steps = new Cell[0];
        if (source.x == dest.x) {
            steps = new Cell[source.y - dest.y > 0 ? source.y - dest.y : -(source.y - dest.y)];
            int stepY = source.y > dest.y ? -1 : 1;
            for (int index = 0; index != (source.y - dest.y > 0 ? source.y - dest.y : -(source.y - dest.y)); index++) {
                steps[index] = Cell.findBy(source.x, source.y + index * stepY + stepY);
            }
        }
        if (source.y == dest.y) {
            steps = new Cell[source.x - dest.x > 0 ? source.x - dest.x : -(source.x - dest.x)];
            int stepX = source.x > dest.x ? -1 : 1;
            for (int index = 0; index != (source.x - dest.x > 0 ? source.x - dest.x : -(source.x - dest.x)); index++) {
                steps[index] = Cell.findBy(source.x + index * stepX + stepX, source.y);
            }
        }
        if (steps.length == 0 && !source.equals(dest)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Rook(dest, this.team);
    }
}
