package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Team;
import ru.job4j.chess.figures.team.*;

public class BoardTest  {

    @Test (expected = OccupiedWayException.class)
    public void whenBishopWolksThroughOccupideCellThenOccupideException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Pawn(Cell.B7, Team.Black));
        board.add(new Bishop(Cell.C8, Team.Black));
        board.move(Cell.C8, Cell.A6);
    }

    @Test
    public void whenBishopWolksByTheRulesThenWithoutExeption() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C8, Team.Black));
        board.move(Cell.C8, Cell.D7);
        board.move(Cell.D7, Cell.B5);
        board.move(Cell.B5, Cell.C4);
        board.move(Cell.C4, Cell.D5);
        board.move(Cell.D5, Cell.C6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheLeftThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.B6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheRightThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheTopThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.C7);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheBottomThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.C5);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenThereAreNoFigureThenFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.B5);
        board.move(Cell.C6, Cell.D5);
    }
}
