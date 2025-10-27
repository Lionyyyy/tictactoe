package tictactoe;

// Abstract class untuk Player
public abstract class Player {
    protected char symbol; // 'X' atau 'O'

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
    public abstract int[] getMove(Board board);
}