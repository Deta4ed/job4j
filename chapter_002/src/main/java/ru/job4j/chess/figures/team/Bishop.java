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
        Cell[] steps = new Cell[0];
        int stepY; int stepX;
        if (source.x - dest.x == source.y - dest.y || source.x - dest.x == -(source.y - dest.y)) {
            steps = new Cell[source.x - dest.x > 0 ? source.x - dest.x : -(source.x - dest.x)];
            stepX = source.x - dest.x > 0 ? -1 : 1;
            stepY = source.x - dest.x == source.y - dest.y ? source.x - dest.x > 0 ? -1 : 1 : source.x - dest.x > 0 ? 1 : -1;
            for (int index = 0; index != (source.x - dest.x > 0 ? source.x - dest.x : -(source.x - dest.x)); index++) {
                steps[index] = Cell.findBy(source.x + index * stepX + stepX, source.y + index * stepY + stepY);
            }
        }
        if (steps.length == 0 && !source.equals(dest)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest, this.team);
    }
}
