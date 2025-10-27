// File: TicTacToe.java
package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat Datang di Game Tic-Tac-Toe!");

        // Loop untuk fitur "Ulangi Game" 
        while (true) {
            Player player1;
            Player player2;

            // Pemilihan mode 
            System.out.println("Pilih mode permainan:");
            System.out.println("1. Manusia vs Manusia");
            System.out.println("2. Manusia vs Komputer");
            int mode = -1;
            while(mode != 1 && mode != 2) {
                System.out.print("Masukkan pilihan (1 atau 2): ");
                try {
                    mode = scanner.nextInt();
                    if(mode != 1 && mode != 2) System.out.println("Pilihan tidak valid.");
                } catch (Exception e) {
                    System.out.println("Input tidak valid. Masukkan angka.");
                    scanner.nextLine(); // clear buffer
                }
            }


            player1 = new HumanPlayer('X', scanner); // Player 1 selalu manusia (X)

            if (mode == 1) {
                player2 = new HumanPlayer('O', scanner); // Manusia vs Manusia
            } else {
                player2 = new ComputerPlayer('O'); // Manusia vs Komputer 
            }

            // Membuat dan memulai game baru
            Game game = new Game(player1, player2);
            game.start();

            // Fitur Ulangi Game 
            System.out.print("Apakah Anda ingin bermain lagi? (y/n): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break; // Keluar dari loop utama
            }
        }

        System.out.println("Terima kasih telah bermain!");
        scanner.close();
    }
}