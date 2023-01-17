package com.example.tictactoe;

enum Key {
    X,
    O
}

public interface IGame {

    void setCurrentTurn(Player currentTurn);

    void setRoundsPlayed(int roundsPlayed);

    void setRoundsStarter(Player player);
 
    Player getCurrentTurn();

    Player getPlayerOne();

    Player getPlayerTwo();

    int getRoundsPlayed();

    Player getRoundStarter();
}

class Player {
    private String name;
    private Key playerKey;
    private int score;

    public Player(String playerName, String playerKey) {
        this.name = playerName;
        this.playerKey = (playerKey.compareTo("X") == 0) ? Key.X : Key.O;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Key getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(Key playerKey) {
        this.playerKey = playerKey;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
}

class Game implements IGame {
    private Player playerOne;
    private Player playerTwo;
    private Player currentTurn;
    private int roundsPlayed;
    private Player roundStarter;

    public Game(Player player1, Player player2) {
        this.playerOne = player1;
        this.playerTwo = player2;
        this.roundsPlayed = 0;
    }

    @Override
    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    @Override
    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed += roundsPlayed;
    }

    @Override
    public Player getCurrentTurn() {
        return currentTurn;
    }

    @Override
    public Player getPlayerOne() {
        return playerOne;
    }

    @Override
    public Player getPlayerTwo() {
        return playerTwo;
    }

    @Override
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    @Override
    public Player getRoundStarter() {
        return this.roundStarter;
    }

    @Override
    public void setRoundsStarter(Player player) {
        this.roundStarter = player;

    }

}
