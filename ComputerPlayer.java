package tictactoe;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(char symbol) {
        super(symbol);
        this.random = new Random();
    }

    @Override
    public int[] getMove(Board board) {
        System.out.println("Player " + getSymbol() + " (Computer) sedang berpikir...");
        // Logika AI Sederhana: cari sel acak yang kosong
        while (true) {
            int row = random.nextInt(3); // Angka acak 0, 1, atau 2
            int col = random.nextInt(3); // Angka acak 0, 1, atau 2

            if (board.isCellEmpty(row, col)) {
                return new int[]{row, col};
            }
            // Jika tidak kosong, loop akan berlanjut
        }
    }
}