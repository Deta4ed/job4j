package ru.job4j.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ru.job4j.chess.figures.*;
import ru.job4j.chess.figures.team.*;

public class Chess extends Application {
    private static final String JOB4J = "Шахматы на www.job4j.ru";
    private final int size = 8;
    private final Board board = new Board();
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private Rectangle buildRectangle(int x, int y, int size, boolean white) {
        Rectangle rect = new Rectangle();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        if (white) {
            rect.setFill(Color.WHITE);
        } else {
            rect.setFill(Color.GRAY);
        }
        rect.setStroke(Color.BLACK);
        return rect;
    }

    private Rectangle buildFigure(int x, int y, int size, String image)  {
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setHeight(size);
        rect.setWidth(size);
        Image img = new Image(this.getClass().getClassLoader().getResource(image).toString());
        rect.setFill(new ImagePattern(img));
        final Rectangle momento = new Rectangle(x, y);
        rect.setOnDragDetected(
            event -> {
                momento.setX(event.getX());
                momento.setY(event.getY());
            }
        );
        rect.setOnMouseDragged(
            event -> {
                rect.setX(event.getX() - size / 2);
                rect.setY(event.getY() - size / 2);
            }
        );
        rect.setOnMouseReleased(
            event -> {
                boolean perhaps = false;
                try {
                    perhaps = board.move(this.findBy(momento.getX(), momento.getY()), this.findBy(event.getX(), event.getY()));
                } catch (ImpossibleMoveException imv) {
                    this.alertShow("Impossible move exception!");
                } catch (OccupiedWayException owe) {
                    this.alertShow("Occupied way exception!");
                } catch (FigureNotFoundException fnfe) {
                    this.alertShow("Figure not found exception!");
                }
                if (perhaps) {
                    rect.setX(((int) event.getX() / 40) * 40 + 5);
                    rect.setY(((int) event.getY() / 40) * 40 + 5);
                } else {
                    if (momento.getX() != 0) {
                        rect.setX(((int) momento.getX() / 40) * 40 + 5);
                        rect.setY(((int) momento.getY() / 40) * 40 + 5);
                    } else {
                        rect.setX(((int) event.getX() / 40) * 40 + 5);
                        rect.setY(((int) event.getY() / 40) * 40 + 5);
                    }
                }
            }
        );
        return rect;
    }

    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 0; y != this.size; y++) {
            for (int x = 0; x != this.size; x++) {
                panel.getChildren().add(
                        this.buildRectangle(x + 1, y + 1, 40, (x + y) % 2 == 0)
                );
            }
        }
        return panel;
    }

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Start");
        start.setOnMouseClicked(
                event -> this.refresh(border)
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 400, 400));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        this.refresh(border);
    }

    private void refresh(final BorderPane border) {
        Group grid = this.buildGrid();
        this.board.clean();
        border.setCenter(grid);
        this.buildWhiteTeam(grid);
        this.buildBlackTeam(grid);
    }

    private void buildBlackTeam(Group grid) {
        this.add(new Pawn(Cell.A7, Team.Black), grid);
        this.add(new Pawn(Cell.B7, Team.Black), grid);
        this.add(new Pawn(Cell.C7, Team.Black), grid);
        this.add(new Pawn(Cell.D7, Team.Black), grid);
        this.add(new Pawn(Cell.E7, Team.Black), grid);
        this.add(new Pawn(Cell.F7, Team.Black), grid);
        this.add(new Pawn(Cell.G7, Team.Black), grid);
        this.add(new Pawn(Cell.H7, Team.Black), grid);
        this.add(new Rook(Cell.A8, Team.Black), grid);
        this.add(new Knight(Cell.B8, Team.Black), grid);
        this.add(new Bishop(Cell.C8, Team.Black), grid);
        this.add(new Qeen(Cell.D8, Team.Black), grid);
        this.add(new King(Cell.E8, Team.Black), grid);
        this.add(new Bishop(Cell.F8, Team.Black), grid);
        this.add(new Knight(Cell.G8, Team.Black), grid);
        this.add(new Rook(Cell.H8, Team.Black), grid);
    }

    public void buildWhiteTeam(Group grid) {
        this.add(new Pawn(Cell.A2, Team.White), grid);
        this.add(new Pawn(Cell.B2, Team.White), grid);
        this.add(new Pawn(Cell.C2, Team.White), grid);
        this.add(new Pawn(Cell.D2, Team.White), grid);
        this.add(new Pawn(Cell.E2, Team.White), grid);
        this.add(new Pawn(Cell.F2, Team.White), grid);
        this.add(new Pawn(Cell.G2, Team.White), grid);
        this.add(new Pawn(Cell.H2, Team.White), grid);
        this.add(new Rook(Cell.A1, Team.White), grid);
        this.add(new Knight(Cell.B1, Team.White), grid);
        this.add(new Bishop(Cell.C1, Team.White), grid);
        this.add(new Qeen(Cell.D1, Team.White), grid);
        this.add(new King(Cell.E1, Team.White), grid);
        this.add(new Bishop(Cell.F1, Team.White), grid);
        this.add(new Knight(Cell.G1, Team.White), grid);
        this.add(new Rook(Cell.H1, Team.White), grid);
    }

    public void add(Figure figure, Group grid) {
        this.board.add(figure);
        Cell position = figure.position();
        grid.getChildren().add(
            this.buildFigure(
                position.x * 40 + 5,
                position.y * 40 + 5,
                30,
                figure.icon()
            )
        );
    }

    private void alertShow(String contextText) {
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

    private Cell findBy(double graphX, double graphY) {
        return Cell.findBy((int) graphX / 40, (int) graphY / 40);
    }
}
