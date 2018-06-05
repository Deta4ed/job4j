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
        Cell[] steps = new Cell[0];
        if (this.team == Team.Black) {
            if (source.y == 7 && source.y == dest.y + 2 && source.x == dest.x) {
                steps = new Cell[2];
                steps[0] = Cell.findBy(source.x, source.y - 1);
                steps[1] = dest;
            }
            if (source.y == dest.y + 1 && source.x == dest.x) {
                steps = new Cell[] {dest};
            }
        } else if (this.team == Team.White) {
            if (source.y == 2 && source.y == dest.y - 2 && source.x == dest.x) {
                steps = new Cell[2];
                steps[0] = Cell.findBy(source.x, source.y + 1);
                steps[1] = dest;
            }
            if (source.y == dest.y - 1 && source.x == dest.x) {
                steps = new Cell[] {dest};
            }
        }
        if (steps.length == 0 && !source.equals(dest)) {
            throw new ImpossibleMoveException("Impossible move exception!");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest, this.team);
    }
}
