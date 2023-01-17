package com.example.tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CrossNoughts extends Application {
    private IGame game;
    private int position;
    private Stage primaryStage;
    private Label playerLabel;
    private String selectedPlayer1Key;
    private String selectedPlayer2Key;
    ToggleGroup groupPlayer2Key;
    ToggleGroup groupPlayer1Key;
    private ToggleGroup x;

    public void clickAction(String key, Label cell, HashMap<Label, String> cells, ArrayList<Label> cords,
            int position) {
        int boardCheck = 0;
        boolean gameWon = false;
        String winningCells = "";
        Alert newAlert = new Alert(AlertType.INFORMATION);
        newAlert.setTitle("TicTacToe - Round Result");

        // fill and add selected cell with player key
        cell.setText("  " + key + "  ");
        cells.putIfAbsent(cell, key);

        // style selected cell
        if (key.equals("X")) {
            cell.setStyle("-fx-font: normal bold 30px 'cambria'; -fx-padding: 10;"
                    + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 2;"
                    + "-fx-border-insets: 2;"
                    + "-fx-border-radius: 5;"
                    + "-fx-border-color: blue;");
        } else {
            cell.setStyle("-fx-font: normal bold 29px 'cambria'; -fx-padding: 10;"
                    + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 2;"
                    + "-fx-border-insets: 2;"
                    + "-fx-border-radius: 5;"
                    + "-fx-border-color: blue;");
        }

        // disable click action on selected cell
        EventHandler<MouseEvent> handler = MouseEvent::consume;
        cell.addEventFilter(MouseEvent.ANY, handler);

        // get number of filled cells
        for (Label i : cells.keySet()) {
            if (cells.get(i) != null) {
                boardCheck += 1;
            }
        }

        // start checking for wining combo
        if (boardCheck > 4) {

            ArrayList<Integer> check = new ArrayList<Integer>();

            for (Label i : cells.keySet()) {

                if (cells.get(i) == key) {

                    for (int j = 0; j < cords.size(); j++) {
                        if (cords.get(j) == i) {
                            check.add(j + 1);
                        }
                    }

                }

            }

            String result = check.toString();

            if (result.contains("1") && result.contains("2") && result.contains("3")) {

                gameWon = true;
                winningCells = "123";

            } else if (result.contains("4") && result.contains("5") && result.contains("6")) {

                winningCells = "456";
                gameWon = true;

            } else if (result.contains("7") && result.contains("8") && result.contains("9")) {

                winningCells = "789";
                gameWon = true;

            } else if (result.contains("1") && result.contains("4") && result.contains("7")) {

                winningCells = "147";
                gameWon = true;

            } else if (result.contains("2") && result.contains("5") && result.contains("8")) {

                winningCells = "258";
                gameWon = true;

            } else if (result.contains("3") && result.contains("6") && result.contains("9")) {

                winningCells = "369";
                gameWon = true;

            } else if (result.contains("1") && result.contains("5") && result.contains("9")) {

                winningCells = "159";
                gameWon = true;

            } else if (result.contains("3") && result.contains("5") && result.contains("7")) {

                winningCells = "357";
                gameWon = true;

            }

        }

        // style winning cells
        if (gameWon) {
            Label c1, c2, c3;

            String[] winningCellArr = winningCells.split("");

            c1 = cords.get(Integer.parseInt(winningCellArr[0]) - 1);
            c2 = cords.get(Integer.parseInt(winningCellArr[1]) - 1);
            c3 = cords.get(Integer.parseInt(winningCellArr[2]) - 1);

            if (key.equals("X")) {

                c1.setStyle("-fx-font: normal bold 30px 'cambria'; -fx-padding: 10;"
                        + "-fx-border-style: solid inside;"
                        + "-fx-border-width: 2;"
                        + "-fx-border-insets: 2;"
                        + "-fx-border-radius: 5;"
                        + "-fx-border-color: green;");

                c2.setStyle("-fx-font: normal bold 30px 'cambria'; -fx-padding: 10;"
                        + "-fx-border-style: solid inside;"
                        + "-fx-border-width: 2;"
                        + "-fx-border-insets: 2;"
                        + "-fx-border-radius: 5;"
                        + "-fx-border-color: green;");

                c3.setStyle("-fx-font: normal bold 30px 'cambria'; -fx-padding: 10;"
                        + "-fx-border-style: solid inside;"
                        + "-fx-border-width: 2;"
                        + "-fx-border-insets: 2;"
                        + "-fx-border-radius: 5;"
                        + "-fx-border-color: green;");

            } else {

                c1.setStyle("-fx-font: normal bold 29px 'cambria'; -fx-padding: 10;"
                        + "-fx-border-style: solid inside;"
                        + "-fx-border-width: 2;"
                        + "-fx-border-insets: 2;"
                        + "-fx-border-radius: 5;"
                        + "-fx-border-color: red;");

                c2.setStyle("-fx-font: normal bold 29px 'cambria'; -fx-padding: 10;"
                        + "-fx-border-style: solid inside;"
                        + "-fx-border-width: 2;"
                        + "-fx-border-insets: 2;"
                        + "-fx-border-radius: 5;"
                        + "-fx-border-color: red;");

                c3.setStyle("-fx-font: normal bold 29px 'cambria'; -fx-padding: 10;"
                        + "-fx-border-style: solid inside;"
                        + "-fx-border-width: 2;"
                        + "-fx-border-insets: 2;"
                        + "-fx-border-radius: 5;"
                        + "-fx-border-color: red;");

            }

            game.getCurrentTurn().setScore(1);
            game.setRoundsPlayed(1);

            // show alert
            try {
                Thread.sleep(500);
                if (key.equals(game.getPlayerOne().getPlayerKey().toString())) {

                    newAlert.setHeaderText("Player1 Wins");
                    newAlert.setContentText(game.getPlayerOne().getName() + " has won this round\n"
                            + game.getPlayerTwo().getName() + " lost");

                } else {

                    newAlert.setHeaderText("Player2 Wins");
                    newAlert.setContentText(game.getPlayerTwo().getName() + " has won this round\n"
                            + game.getPlayerOne().getName() + " lost");

                }

                newAlert.setOnCloseRequest(e -> gameRound());
                newAlert.show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {

            // allow further game action or start new round
            if (boardCheck < 9) {

                if (game.getCurrentTurn().equals(game.getPlayerOne())) {
                    playerLabel.setText("Player 2");
                    game.setCurrentTurn(game.getPlayerTwo());
                } else if (game.getCurrentTurn().equals(game.getPlayerTwo())) {
                    playerLabel.setText("Player 1");
                    game.setCurrentTurn(game.getPlayerOne());
                }

            } else if (boardCheck > 8) {

                // allow further game action
                try {
                    Thread.sleep(500);
                    newAlert.setTitle("TicTacToe - Round Result");
                    newAlert.setHeaderText("Draw!!!");
                    newAlert.setContentText("it\'s a tie");
                    newAlert.setOnCloseRequest(e -> gameRound());
                    newAlert.show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                game.setRoundsPlayed(1);

            }

        }

    }

    public void gameRound() {

        HashMap<Label, String> cells = new HashMap<Label, String>();
        ArrayList<Label> cordinates = new ArrayList<Label>();

        // create game round cells
        Label cell1 = new Label();
        cells.put(cell1, null);
        cordinates.add(cell1);

        Label cell2 = new Label();
        cells.put(cell2, null);
        cordinates.add(cell2);

        Label cell3 = new Label();
        cells.put(cell3, null);
        cordinates.add(cell3);

        Label cell4 = new Label();
        cells.put(cell4, null);
        cordinates.add(cell4);

        Label cell5 = new Label();
        cells.put(cell5, null);
        cordinates.add(cell5);

        Label cell6 = new Label();
        cells.put(cell6, null);
        cordinates.add(cell6);

        Label cell7 = new Label();
        cells.put(cell7, null);
        cordinates.add(cell7);

        Label cell8 = new Label();
        cells.put(cell8, null);
        cordinates.add(cell8);

        Label cell9 = new Label();
        cells.put(cell9, null);
        cordinates.add(cell9);

        // set player to start first and other consequent games
        if (game.getRoundsPlayed() < 1) {
            if (x.equals(groupPlayer2Key)) {
                game.setCurrentTurn(game.getPlayerTwo());
                game.setRoundsStarter(game.getPlayerTwo());

            } else if (x.equals(groupPlayer1Key)) {
                game.setCurrentTurn(game.getPlayerOne());
                game.setRoundsStarter(game.getPlayerOne());

            }
        } else {

            if (game.getRoundStarter().equals(game.getPlayerOne())) {
                game.setCurrentTurn(game.getPlayerTwo());
            } else if (game.getRoundStarter().equals(game.getPlayerTwo())) {
                game.setCurrentTurn(game.getPlayerOne());
            }
        }

        // add styling to cells
        // add mouse click action to cells
        for (Label cell : cells.keySet()) {

            cell.setText("      ");
            cell.setStyle("-fx-font: normal bold 30px 'cambria'; -fx-padding: 10; -fx-border-style: solid inside;"
                    + "-fx-border-width: 1; -fx-border-insets: 2; -fx-border-radius: 2; -fx-border-color: grey;");
            cell.setTextAlignment(TextAlignment.CENTER);

            // add mouse usage to play game
            cell.setOnMouseClicked(env -> {

                for (Label item : cordinates) {
                    if (item == cell) {
                        position = cordinates.indexOf(item) + 1;
                    }
                }

                clickAction(game.getCurrentTurn().getPlayerKey().toString(), cell, cells, cordinates, position);

            });

        }
        // create outer grid
        GridPane gridIndicator = new GridPane();
        gridIndicator.setPrefSize(350, 70);
        gridIndicator.setPadding(new Insets(5, 5, 5, 5));
        gridIndicator.setHgap(7);
        gridIndicator.setAlignment(Pos.CENTER);
        gridIndicator.setStyle("-fx-background-color: LIGHTBLUE;");

        Label currentLabel = new Label("Current Turn : ");
        currentLabel.setStyle("-fx-font: normal 15px 'consolas'");

        playerLabel = new Label();
        playerLabel.setStyle("-fx-font: italic bold 15px 'cambria'");

        // set playerlabel to change on player turns
        if (game.getRoundsPlayed() < 1) {
            if (game.getCurrentTurn().equals(game.getPlayerTwo())) {
                playerLabel.setText("Player 2");
            } else if (game.getCurrentTurn().equals(game.getPlayerOne())) {
                playerLabel.setText("Player 1");
            }
        } else if (game.getRoundsPlayed() > 0) {
            if (game.getRoundStarter().equals(game.getPlayerTwo())) {
                playerLabel.setText("Player 1");
                game.setRoundsStarter(game.getPlayerOne());
            } else if (game.getRoundStarter().equals(game.getPlayerOne())) {
                playerLabel.setText("Player 2");
                game.setRoundsStarter(game.getPlayerTwo());

            }
        }

        gridIndicator.add(currentLabel, 0, 0);
        gridIndicator.add(playerLabel, 1, 0);

        // create inner cells grid
        GridPane gridGame = new GridPane();
        gridGame.setPrefSize(350, 350);
        gridGame.setPadding(new Insets(50, 50, 50, 50));
        gridGame.setVgap(7);
        gridGame.setHgap(6);
        gridGame.setStyle("-fx-background-color: BEIGE;");

        gridGame.setAlignment(Pos.CENTER);

        gridGame.add(cell1, 0, 0);
        gridGame.add(cell4, 0, 1);
        gridGame.add(cell7, 0, 2);

        gridGame.add(cell2, 1, 0);
        gridGame.add(cell5, 1, 1);
        gridGame.add(cell8, 1, 2);

        gridGame.add(cell3, 2, 0);
        gridGame.add(cell6, 2, 1);
        gridGame.add(cell9, 2, 2);

        // add all nodes container
        VBox vbox = new VBox();
        vbox.getChildren().addAll(gridIndicator, gridGame);

        Scene scene = new Scene(vbox, 450, 370);

        // enable keyboard use to play game
        scene.setOnKeyPressed((KeyEvent event) -> {
            int cellNum = Integer.parseInt(event.getText());

            if (cellNum > 0) {
                Label cell = cordinates.get(cellNum - 1);
                if (cells.get(cell) == null) {
                    clickAction(game.getCurrentTurn().getPlayerKey().toString(), cell, cells, cordinates, cellNum - 1);
                }
            }
        });

        // game result to show on window close
        primaryStage.setOnCloseRequest(e -> {
            int draws = game.getRoundsPlayed() - (game.getPlayerOne().getScore() + game.getPlayerTwo().getScore());
            int p1Loss = game.getPlayerTwo().getScore();
            int p2Loss = game.getPlayerOne().getScore();

            Alert newAlert = new Alert(AlertType.INFORMATION);
            newAlert.setResult(ButtonType.CLOSE);
            newAlert.setTitle("TicTacToe - Game Result");
            newAlert.setContentText("- Game stats -\n Player 1 > " + game.getPlayerOne().getName() + " [ " + "Wins : "
                    + game.getPlayerOne().getScore() + ", "
                    + " Loss : "
                    + p1Loss + " ]\n Player 2 > " + game.getPlayerTwo().getName() + " [ " + "Wins : "
                    + game.getPlayerTwo().getScore() + ", " + " Loss : "
                    + p2Loss + " ]\n Draws : " + draws + "\n Rounds Played : " + game.getRoundsPlayed());

            if (game.getPlayerOne().getScore() > game.getPlayerTwo().getScore()) {
                newAlert.setHeaderText(game.getPlayerOne().getName() + " Wins");
            } else if (game.getPlayerTwo().getScore() > game.getPlayerOne().getScore()) {
                newAlert.setHeaderText(game.getPlayerTwo().getName() + " Wins");
            } else {
                newAlert.setHeaderText("Game Drawn");
            }

            newAlert.setOnCloseRequest(env -> primaryStage.close());
            newAlert.show();
        });

        primaryStage.setTitle("TicTacToe - Play");
        primaryStage.setScene(scene);
    }

    @Override
    public void start(Stage stage) throws Exception {

        primaryStage = stage;

        Label header = new Label("Tic-Tac-Toe");
        header.setStyle("-fx-font: italic bold 30px 'candara'; -fx-background-color: LIGHTBLUE;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 10;"
                + "-fx-border-color: grey;");
        header.setPadding(new Insets(20, 120, 20, 120));

        Label footer = new Label("made by @certified_dev 2022");
        footer.setPadding(new Insets(5, 8, 5, 8));

        GridPane gridGame = new GridPane();
        gridGame.setPrefSize(350, 230);
        gridGame.setPadding(new Insets(50, 50, 50, 50));
        gridGame.setVgap(7);
        gridGame.setHgap(10);
        gridGame.setStyle("-fx-background-color: BEIGE;");

        Label player1Label = new Label("Player 1");
        Label player2Label = new Label("Player 2");

        ToggleButton cross1 = new ToggleButton("X");
        cross1.setPadding(new Insets(10, 13, 10, 13));
        cross1.setVisible(false);

        ToggleButton nought1 = new ToggleButton("O");
        nought1.setPadding(new Insets(10, 13, 10, 13));
        nought1.setVisible(false);

        groupPlayer1Key = new ToggleGroup();
        nought1.setToggleGroup(groupPlayer1Key);
        cross1.setToggleGroup(groupPlayer1Key);

        ToggleButton cross2 = new ToggleButton("X");
        cross2.setPadding(new Insets(10, 13, 10, 13));
        cross2.setVisible(false);

        ToggleButton nought2 = new ToggleButton("O");
        nought2.setPadding(new Insets(10, 13, 10, 13));
        nought2.setVisible(false);

        groupPlayer2Key = new ToggleGroup();
        nought2.setToggleGroup(groupPlayer2Key);
        cross2.setToggleGroup(groupPlayer2Key);

        groupPlayer1Key.selectedToggleProperty().addListener(
                (ChangeListener<? super Toggle>) new ChangeListener<Toggle>() {
                    @Override
                    public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle,
                            final Toggle new_toggle) {
                        if (((ToggleButton) new_toggle) != null) {

                            if (new_toggle.getToggleGroup().equals(groupPlayer1Key) && x == null) {
                                x = groupPlayer1Key;
                            }

                            selectedPlayer1Key = ((ToggleButton) new_toggle).getText();

                            if (selectedPlayer1Key.equals("X")) {
                                groupPlayer2Key.selectToggle(nought2);
                            } else if (selectedPlayer1Key.equals("O")) {
                                groupPlayer2Key.selectToggle(cross2);
                            }

                        } else {
                            groupPlayer1Key.selectToggle(null);
                            groupPlayer2Key.selectToggle(null);
                        }
                    }
                });

        groupPlayer2Key.selectedToggleProperty().addListener(
                (ChangeListener<? super Toggle>) new ChangeListener<Toggle>() {
                    @Override
                    public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle,
                            final Toggle new_toggle) {
                        if (((ToggleButton) new_toggle) != null) {

                            if (new_toggle.getToggleGroup().equals(groupPlayer2Key) & x == null) {
                                x = groupPlayer2Key;
                            }

                            selectedPlayer2Key = ((ToggleButton) new_toggle).getText();

                            if (selectedPlayer2Key.equals("X")) {
                                groupPlayer1Key.selectToggle(nought1);
                            } else if (selectedPlayer2Key.equals("O")) {
                                groupPlayer1Key.selectToggle(cross1);
                            }

                        } else {

                            groupPlayer1Key.selectToggle(null);
                            groupPlayer2Key.selectToggle(null);

                        }
                    }
                });

        TextField player1NameField = new TextField();
        player1NameField.setPrefHeight(35);
        player1NameField.setOnKeyTyped(e -> {
            if (((TextField) e.getSource()).getText().length() > 2) {
                cross1.setVisible(true);
                nought1.setVisible(true);
            } else {
                cross1.setVisible(false);
                nought1.setVisible(false);
            }
        });

        TextField player2NameField = new TextField();
        player2NameField.setPrefHeight(35);
        player2NameField.setOnKeyTyped(e -> {
            if (((TextField) e.getSource()).getText().length() > 2) {
                cross2.setVisible(true);
                nought2.setVisible(true);
            } else {
                cross2.setVisible(false);
                nought2.setVisible(false);
            }

        });

        HBox toggleHbox1 = new HBox();
        toggleHbox1.getChildren().addAll(nought1, cross1);
        toggleHbox1.setSpacing(78);

        HBox toggleHbox2 = new HBox();
        toggleHbox2.getChildren().addAll(nought2, cross2);
        toggleHbox2.setSpacing(78);

        Alert newAlert = new Alert(AlertType.ERROR);
        newAlert.setTitle("TicTacToe - Start Game");
        newAlert.setHeaderText("Incomplete input");

        Button button1 = new Button("start");
        button1.setPadding(new Insets(7, 15, 7, 15));
        button1.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font: normal 15px 'cambria' ");
        button1.setOnAction(e -> {

            if (player1NameField.getText().length() > 2 && player2NameField.getText().length() > 2) {
                if (selectedPlayer1Key != null || selectedPlayer2Key != null) {
                    // create player
                    Player playerOne = new Player(player1NameField.getText(), selectedPlayer1Key);
                    Player playerTwo = new Player(player2NameField.getText(), selectedPlayer2Key);

                    // instantiate and initialize game with player objects
                    game = new Game(playerOne, playerTwo);
                    gameRound();
                } else {
                    newAlert.setContentText("player must select a key");
                    newAlert.show();
                }

            } else {
                newAlert.setContentText("Enter names of both player");
                newAlert.show();
            }
        });

        Button button2 = new Button("close");
        button2.setPadding(new Insets(7, 15, 7, 15));
        button2.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font: normal 15px 'cambria' ");
        button2.setOnAction(e -> primaryStage.close());

        gridGame.add(player1Label, 0, 0);
        gridGame.add(player1NameField, 0, 1);
        gridGame.add(toggleHbox1, 0, 2);

        gridGame.add(player2Label, 1, 0);
        gridGame.add(player2NameField, 1, 1);
        gridGame.add(toggleHbox2, 1, 2);
        gridGame.setAlignment(Pos.CENTER);

        HBox btnHbox = new HBox();
        btnHbox.getChildren().addAll(button1, button2);
        btnHbox.setStyle("-fx-background-color: BEIGE;");
        btnHbox.setSpacing(20);
        btnHbox.setAlignment(Pos.CENTER);
        btnHbox.setPadding(new Insets(0, 0, 20, 0));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(header, gridGame, btnHbox, footer);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 450, 370);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String args[]) {
        launch(args);
    }
}
