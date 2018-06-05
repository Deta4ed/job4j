package ru.job4j.chess.figures.team;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Rook extends Figure {
    public Rook(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new Rook(dest, this.team);
    }
}
