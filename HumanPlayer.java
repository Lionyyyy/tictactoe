// File: HumanPlayer.java
package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(char symbol, Scanner scanner) {
        super(symbol);
        this.scanner = scanner;
    }

    @Override
    public int[] getMove(Board board) {
        while (true) {
            try {
                System.out.print("Player " + getSymbol() + ", masukkan langkah (baris[0-2] kolom[0-2]): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                // Validasi 1: Cek rentang
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    // Validasi 2: Cek kotak harus kosong 
                    if (board.isCellEmpty(row, col)) {
                        return new int[]{row, col};
                    } else {
                        System.out.println("Sel ini sudah terisi. Coba lagi.");
                    }
                } else {
                    System.out.println("Input tidak valid. Baris dan kolom harus antara 0 dan 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); // Membersihkan buffer scanner
            }
        }
    }
}