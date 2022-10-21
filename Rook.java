import java.util.ArrayList;

import java.awt.Point;

public class Rook extends Piece{
    public Rook (String color, int x, int y ){
        super(color, x ,y);
    }

    @Override
    public ArrayList<Point>  getLegalMoves(Square [][] b) {
        ArrayList<Point>  movesMap = new ArrayList<Point> ();

        int lastYabove = 0;
        int lastXright = 7;
        int lastYbelow = 7;
        int lastXleft = 0;

        var x = this.x; var y = this.y;
        
        for (int i = 0; i < y; i++) {
            if (b[x][i].isOccupied()) {
                if (b[x][i].getPiece().whatColor() != whatColor()) {
                    lastYabove = i;
                } else lastYabove = i + 1;
            }
        }

        for (int i = 7; i > y; i--) {
            if (b[x][i].isOccupied()) {
                if (b[x][i].getPiece().whatColor() != whatColor()) {
                    lastYbelow = i;
                } else lastYbelow = i - 1;
            }
        }

        for (int i = 0; i < x; i++) {
            if (b[i][y].isOccupied()) {
                if (b[i][y].getPiece().whatColor() != whatColor()) {
                    lastXleft = i;
                } else lastXleft = i + 1;
            }
        }

        for (int i = 7; i > x; i--) {
            if (b[i][y].isOccupied()) {
                if (b[i][y].getPiece().whatColor() != whatColor()) {
                    lastXright = i;
                } else lastXright = i - 1;
            }
        }
        
        int[] occups = {lastYabove, lastYbelow, lastXleft, lastXright};

        for (int i = occups[0]; i <= occups[1]; i++) {
            if (i != y) movesMap.add(new Point(x, i));
        }
        
        for (int i = occups[2]; i <= occups[3]; i++) {
            if (i != x) movesMap.add(new Point(i, y));
        }

        return movesMap;
    }


    public String getName(){ return "R";}
}
