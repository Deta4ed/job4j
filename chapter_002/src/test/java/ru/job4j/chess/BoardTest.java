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

    @Test (expected = OccupiedWayException.class)
    public void whenPawnWolksThroughOccupideCellThenOccupideException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Pawn(Cell.B7, Team.Black));
        board.add(new Bishop(Cell.B6, Team.Black));
        board.move(Cell.B7, Cell.B6);
    }

    @Test (expected = OccupiedWayException.class)
    public void whenKnightWolksThroughOccupideCellThenOccupideException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Knight(Cell.B8, Team.Black));
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.B8, Cell.C6);
    }

    @Test (expected = OccupiedWayException.class)
    public void whenKingWolksThroughOccupideCellThenOccupideException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new King(Cell.E8, Team.Black));
        board.add(new Bishop(Cell.E7, Team.Black));
        board.move(Cell.E8, Cell.E7);
    }

    @Test (expected = OccupiedWayException.class)
    public void whenQuinWolksThroughOccupideCellThenOccupideException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Qeen(Cell.D8, Team.Black));
        board.add(new Bishop(Cell.D7, Team.Black));
        board.move(Cell.D8, Cell.D6);
    }

    @Test (expected = OccupiedWayException.class)
    public void whenRooKWolksThroughOccupideCellThenOccupideException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Rook(Cell.A8, Team.Black));
        board.add(new Bishop(Cell.A7, Team.Black));
        board.move(Cell.A8, Cell.A6);
    }

    @Test
    public void whenFiguresWolksByTheRulesThenWithoutExeption() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        this.initBoard(board);
        board.move(Cell.C7, Cell.C5);
        board.move(Cell.C2, Cell.C4);
        board.move(Cell.B8, Cell.C6);
        board.move(Cell.G1, Cell.F3);
        board.move(Cell.G8, Cell.F6);
        board.move(Cell.B1, Cell.C3);
        board.move(Cell.F6, Cell.D5);
        board.move(Cell.A2, Cell.A4);
        board.move(Cell.E7, Cell.E5);
        board.move(Cell.A1, Cell.A3);
        board.move(Cell.D7, Cell.D6);
        board.move(Cell.D2, Cell.D3);
        board.move(Cell.C8, Cell.G4);
        board.move(Cell.F3, Cell.D4);
        board.move(Cell.D8, Cell.H4);
        board.move(Cell.C3, Cell.B5);
        board.move(Cell.E1, Cell.D2);
        board.move(Cell.F8, Cell.E7);
        board.move(Cell.F2, Cell.F3);
        board.move(Cell.G4, Cell.F5);
        board.move(Cell.G2, Cell.G3);
        board.move(Cell.H4, Cell.H6);
        board.move(Cell.D2, Cell.C2);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheLeftThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.B6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenPawnWolksToTheLeftThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Pawn(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.B6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenPawnKnightToTheLeftThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Knight(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.B6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheRightThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenPawnWolksToTheRightThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Pawn(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenKnightWolksToTheRightThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Knight(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheTopThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.C7);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenKnightWolksToTheTopThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Knight(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.C7);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopWolksToTheBottomThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.C5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenPawnWolksToTheBottomThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Pawn(Cell.C6, Team.White));
        board.move(Cell.C6, Cell.C5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenKnightWolksToTheBottomThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Knight(Cell.C6, Team.White));
        board.move(Cell.C6, Cell.C5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenPawnWolksToTheDiagonalThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Pawn(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenRookWolksToTheDiagonalThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Rook(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenKnightWolksToTheDiagonalThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Knight(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.D5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenKingWolksOnToCellThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new King(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.C8);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenThereAreNoFigureThenFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.add(new Bishop(Cell.C6, Team.Black));
        board.move(Cell.C6, Cell.B5);
        board.move(Cell.C6, Cell.D5);
    }

    public void initBoard(Board board) {
        board.add(new Pawn(Cell.A7, Team.Black));
        board.add(new Pawn(Cell.B7, Team.Black));
        board.add(new Pawn(Cell.C7, Team.Black));
        board.add(new Pawn(Cell.D7, Team.Black));
        board.add(new Pawn(Cell.E7, Team.Black));
        board.add(new Pawn(Cell.F7, Team.Black));
        board.add(new Pawn(Cell.G7, Team.Black));
        board.add(new Pawn(Cell.H7, Team.Black));
        board.add(new Rook(Cell.A8, Team.Black));
        board.add(new Knight(Cell.B8, Team.Black));
        board.add(new Bishop(Cell.C8, Team.Black));
        board.add(new Qeen(Cell.D8, Team.Black));
        board.add(new King(Cell.E8, Team.Black));
        board.add(new Bishop(Cell.F8, Team.Black));
        board.add(new Knight(Cell.G8, Team.Black));
        board.add(new Rook(Cell.H8, Team.Black));
        board.add(new Pawn(Cell.A2, Team.White));
        board.add(new Pawn(Cell.B2, Team.White));
        board.add(new Pawn(Cell.C2, Team.White));
        board.add(new Pawn(Cell.D2, Team.White));
        board.add(new Pawn(Cell.E2, Team.White));
        board.add(new Pawn(Cell.F2, Team.White));
        board.add(new Pawn(Cell.G2, Team.White));
        board.add(new Pawn(Cell.H2, Team.White));
        board.add(new Rook(Cell.A1, Team.White));
        board.add(new Knight(Cell.B1, Team.White));
        board.add(new Bishop(Cell.C1, Team.White));
        board.add(new Qeen(Cell.D1, Team.White));
        board.add(new King(Cell.E1, Team.White));
        board.add(new Bishop(Cell.F1, Team.White));
        board.add(new Knight(Cell.G1, Team.White));
        board.add(new Rook(Cell.H1, Team.White));
    }

}
