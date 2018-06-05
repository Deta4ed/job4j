package ru.job4j.chess.figures.team;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class King  extends Figure {
    public King(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new King(dest, this.team);
    }
}
