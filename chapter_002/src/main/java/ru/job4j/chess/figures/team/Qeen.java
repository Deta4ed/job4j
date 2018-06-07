package ru.job4j.chess.figures.team;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Team;

public class Qeen extends Figure {

    public Qeen(final Cell dest, final Team team) {
        super(dest, team);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        try {
            Bishop bishop = new Bishop(source, this.team);
            steps = bishop.way(source, dest);
        } catch (ImpossibleMoveException ime) {
            Rook rook = new Rook(source, this.team);
            steps = rook.way(source, dest);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Qeen(dest, this.team);
    }
}
