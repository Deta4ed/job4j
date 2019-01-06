package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Board - chess board contains all the figures.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    /**
     * Add figure.
     * @param figure - figure.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Move figure.
     * @param source - cell sourse.
     * @param dest - destination cell.
     * @return
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
            if (source != null) {
                int res = this.findBy(source);
                Cell[] steps = this.figures[res].way(source, dest);
                if (res != -1 && steps.length > 0 && this.possibility(steps) && steps[steps.length - 1].equals(dest)) {
                    result = true;
                    this.figures[res] = this.figures[res].copy(dest);
                }
            }
        return result;
    }

    /**
     * cleaning of all the figures on the board
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     *
     * @param steps - array of path steps.
     * @return - possibility of passing.
     * @throws OccupiedWayException
     */
    private boolean possibility(Cell[] steps) throws OccupiedWayException {
        boolean potential = Arrays.stream(steps).flatMap(s -> Arrays.stream(figures).filter(f -> f != null && s.equals(f.position))).count() == 0;
        if (!potential) {
            throw new OccupiedWayException("Occupied way exception!");
        }
        return potential;
    }

    /**
     *
     * @param cell - cell.
     * @return - actual location in a cell.
     * @throws FigureNotFoundException
     */
    private int findBy(Cell cell) throws FigureNotFoundException {
        int res = IntStream.range(0, figures.length).filter(x -> figures[x] != null && figures[x].position().equals(cell)).findFirst().orElse(-1);
        if (res == -1) {
            throw new FigureNotFoundException("Figure not found exception!");
        }
        return res;
    }
}
