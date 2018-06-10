package ru.job4j.chess.figures.team;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Pawn extends Figure {

    public Pawn(Cell dest, Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (source.x != dest.x
                || source.equals(dest)
                || source.y - dest.y > 0 && this.team != Team.Black
                || source.y - dest.y < 0 && this.team != Team.White
                || Math.abs(source.y - dest.y) > 1
                && (this.team == Team.Black && source.y == 7 && dest.y != 5
                || this.team == Team.White && source.y == 2 && dest.y != 4)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];
        int stepY = Integer.compare(dest.y,source.y);
        for (int index = 1; index <= Math.abs(source.y - dest.y); index++) {
            steps[index - 1] = Cell.findBy(source.x, source.y + index * stepY);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest, this.team);
    }
}
