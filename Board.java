// File: Board.java
package tictactoe;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    /**
     * Membersihkan papan, mengisi semua sel dengan spasi.
     *  (Dibutuhkan untuk fitur "Ulangi Game")
     */
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /**
     * Menampilkan papan 3x3 ke konsol.
     * 
     */
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    /**
     * Pengecekan apakah sel tertentu masih kosong.
     *  (Dibutuhkan untuk validasi)
     */
    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == ' ';
    }

    /**
     * Meletakkan simbol pemain (X atau O) di papan.
     * 
     */
    public boolean placeMove(int row, int col, char symbol) {
        if (isCellEmpty(row, col)) {
            cells[row][col] = symbol;
            return true;
        }
        return false;
    }

    /**
     * Pengecekan apakah papan sudah penuh.
     * [cite: 13] (Dibutuhkan untuk Pengecekan Kondisi Seri)
     */
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false; // Ditemukan sel kosong, papan belum penuh
                }
            }
        }
        return true; // Tidak ada sel kosong
    }

    /**
     * Pengecekan kondisi menang untuk simbol tertentu.
     * [cite: 12]
     */
    public boolean checkWin(char symbol) {
        // Cek Baris
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == symbol && cells[i][1] == symbol && cells[i][2] == symbol) {
                return true;
            }
        }
        // Cek Kolom
        for (int j = 0; j < 3; j++) {
            if (cells[0][j] == symbol && cells[1][j] == symbol && cells[2][j] == symbol) {
                return true;
            }
        }
        // Cek Diagonal
        if (cells[0][0] == symbol && cells[1][1] == symbol && cells[2][2] == symbol) {
            return true;
        }
        if (cells[0][2] == symbol && cells[1][1] == symbol && cells[2][0] == symbol) {
            return true;
        }
        return false;
    }
}