// File: Game.java
package tictactoe;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.board = new Board(); // Relasi Composition
        this.player1 = player1;   // Relasi Aggregation
        this.player2 = player2;   // Relasi Aggregation
        this.currentPlayer = player1; // 'X' selalu mulai duluan
    }

    /**
     * Memulai loop permainan utama.
     */
    public void start() {
        while (true) {
            board.printBoard();
            
            // 1. Dapatkan langkah dari pemain saat ini
            int[] move = currentPlayer.getMove(board);
            int row = move[0];
            int col = move[1];

            // 2. Letakkan langkah di papan 
            board.placeMove(row, col, currentPlayer.getSymbol());

            // 3. Cek kondisi menang [cite: 12]
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Selamat! Player " + currentPlayer.getSymbol() + " MENANG!");
                break; // Keluar dari loop
            }

            // 4. Cek kondisi seri [cite: 13]
            if (board.isFull()) {
                board.printBoard();
                System.out.println("Permainan SERI!");
                break; // Keluar dari loop
            }

            // 5. Pengaturan giliran pemain 
            switchPlayer();
        }
    }

    /**
     * Mengganti pemain saat ini.
     */
    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}