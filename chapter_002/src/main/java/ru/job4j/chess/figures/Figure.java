package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Figure {
    public final Cell position;
    public final Team team;

    public Figure(final Cell position, final Team team) {
        this.position = position;
        this.team = team;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public abstract Figure copy(Cell dest);

    public Cell position() {
        return this.position;
    }

    public String icon() {
        return String.format("%s%s.png", this.getClass().getSimpleName(), this.team);
    }
}
