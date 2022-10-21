import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Square extends JButton {
    private boolean occupied;
    private int dx;
    private int dy;
    private Piece piece;

    public Square(int x, int y) {
        super("");
        this.dx = x;
        this.dy = y;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public void addPiece(Piece p) {
        if (!isOccupied()) {
            this.piece = p;
            this.occupied = true;
            this.setText(this.piece.getName());

            if(this.piece.whatColor() == "white"){
                this.setBackground(Color.WHITE);
            } else {
                this.setBackground(Color.BLACK);
                this.setForeground(Color.WHITE);
            }
        }
        this.revalidate();
    }

    public void removePiece() {
        this.piece = null;
        this.occupied = false;
        this.setText("");
        this.setBackground(null);
        this.setForeground(null);
        this.revalidate();
    }

    public Piece getPiece() {return this.piece;}

    public int getdX() {
        return this.dx;
    }

    public int getdY() {
        return this.dy;
    }

    public ArrayList<Point> getLegalMoves(Square [][] chessboard){
        return this.piece.getLegalMoves(chessboard);
    }

    public void moveTo(Square to){
        this.piece.move(to);

        to.addPiece(this.getPiece());
        this.removePiece();
    }

    public void resetColors(){
        this.setBackground(null);
        this.setForeground(null);

        if(this.piece == null) return;

        if(this.piece.whatColor() == "white"){
            this.setBackground(Color.WHITE);
        } else {
            this.setBackground(Color.BLACK);
            this.setForeground(Color.WHITE);
        }
    }



}
