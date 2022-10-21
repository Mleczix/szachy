
import java.awt.Rectangle;

import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;



public class Board {
    private Square[][] chessboard = new Square[8][8];
    private Square selectedPiece;

    private JPanel gamePanel;

    public Board(JPanel gamePanel) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard[i][j] = new Square(i, j);
                chessboard[i][j].setBounds(new Rectangle(500 / 8 - 5, 300 / 8 - 5));
                chessboard[i][j].setVisible(true);
                chessboard[i][j].addActionListener(this::onClick);
                gamePanel.add(chessboard[i][j]);
            }
        }

        init();

        gamePanel.revalidate();

        this.gamePanel = gamePanel;

    }

    public Square[][] getSquareArray() {
        return chessboard;
    }

    private void init() {

        // White pawns
        for (int x = 0; x < 8; x++) {
            chessboard[1][x].addPiece(new Pawn("white", 1, x));
        }

        // Black pawns
        for (int x = 0; x < 8; x++) {
            chessboard[6][x].addPiece(new Pawn("black", 6, x));
        }

        // Rooks
        chessboard[0][0].addPiece(new Rook("white", 0, 0));
        chessboard[0][7].addPiece(new Rook("white", 0, 7));
        chessboard[7][7].addPiece(new Rook("black", 7, 7));
        chessboard[7][0].addPiece(new Rook("black", 7, 0));

        // Knights
        chessboard[0][1].addPiece(new Knight("white", 0, 1));
        chessboard[0][6].addPiece(new Knight("white", 0, 6));
        chessboard[7][6].addPiece(new Knight("black", 7, 6));
        chessboard[7][1].addPiece(new Knight("black", 7, 1));

        // Bishops
        chessboard[0][2].addPiece(new Bishop("white", 0, 2));
        chessboard[0][5].addPiece(new Bishop("white", 0, 5));
        chessboard[7][2].addPiece(new Bishop("black", 7, 2));
        chessboard[7][5].addPiece(new Bishop("black", 7, 5));

        // Queens
        chessboard[0][3].addPiece(new Queen("white", 0, 3));
        chessboard[7][4].addPiece(new Queen("black", 7, 4));

        // Kings
        chessboard[0][4].addPiece(new King("white", 0, 4));
        chessboard[7][3].addPiece(new King("black", 7, 3));

    }

    public void onClick(ActionEvent e) {

        var square = (Square) e.getSource(); // odzyskuje element

        if (square.isOccupied()) {
            if(square.getBackground() == Color.RED && selectedPiece != null){ // jezeli jest zaznaczony jakis pion i kolor tego kwadratu jest czerwony to go zbij
                square.removePiece(); //licznik punktow +1
                selectedPiece.moveTo(square);
                clearSquaresColor();
                return;
            }

            clearSquaresColor(); // czyszcze wszystkie podswietlenia

            selectedPiece = square;
            var moves = square.getLegalMoves(chessboard);

            for (Point p : moves) {
                // System.out.println("x: " + p.x + " y: " + p.y);
                var sq = chessboard[p.x][p.y];
                sq.setBackground(Color.RED);
                sq.setOpaque(true);
                sq.revalidate();
            }
        } else { 
            // System.out.println("kolor: " + Color.RED + " value: " + selectedPiece);
            if(square.getBackground() == Color.RED && selectedPiece != null){ //przenies w to miejsce wybrany pionek (jeżeli jest wybrany)
                
                selectedPiece.moveTo(square);
            } 
            clearSquaresColor(); // czyszcze wszystkie podswietlenia
        }


        
    }

    private void clearSquaresColor() { //czyszczenie zaznacznień dla dozwolonych ruchów (swego rodzaju redraw)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard[i][j].resetColors();
            }
        }
    }

    public void remove(){ //usuwanie elementów z panelu (przy ponownym rozpoczeciu gry)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.gamePanel.remove(chessboard[i][j]);
            }
        }
        gamePanel.revalidate();
    }
}
