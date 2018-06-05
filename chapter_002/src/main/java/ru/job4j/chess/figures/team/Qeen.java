package ru.job4j.chess.figures.team;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Qeen extends Figure {
    public Qeen(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new Qeen(dest, this.team);
    }
}
