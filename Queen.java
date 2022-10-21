import java.util.ArrayList;

import java.awt.Point;

public class Queen extends Piece{
    public Queen (String color, int x, int y ){
        super(color, x ,y);
    }

    @Override
    public ArrayList<Point>  getLegalMoves(Square [][] b) {
        ArrayList<Point>  movesMap = new ArrayList<Point> ();

        var x = this.x; var y = this.y;

        int xNW = x - 1;
        int xSW = x - 1;
        int xNE = x + 1;
        int xSE = x + 1;
        int yNW = y - 1;
        int ySW = y + 1;
        int yNE = y - 1;
        int ySE = y + 1;

        while (xNW >= 0 && yNW >= 0) {
            if (b[xNW][yNW].isOccupied()) {
                if (b[xNW][yNW].getPiece().whatColor() == whatColor()) {
                    break;
                } else {
                    movesMap.add(new Point(xNW, yNW));
                    break;
                }
            } else {
                movesMap.add(new Point(xNW, yNW));
                yNW--;
                xNW--;
            }
        }

        while (xSW >= 0 && ySW < 8) {
            if (b[xSW][ySW].isOccupied()) {
                if (b[xSW][ySW].getPiece().whatColor() == whatColor()) {
                    break;
                } else {
                    movesMap.add(new Point(xSW, ySW));
                    break;
                }
            } else {
                movesMap.add(new Point(xSW, ySW));
                ySW++;
                xSW--;
            }
        }

        while (xSE < 8 && ySE < 8) {
            if (b[xSE][ySE].isOccupied()) {
                if (b[xSE][ySE].getPiece().whatColor() == whatColor()) {
                    break;
                } else {
                    movesMap.add(new Point(xSE, ySE));
                    break;
                }
            } else {
                movesMap.add(new Point(xSE, ySE));
                ySE++;
                xSE++;
            }
        }

        while (xNE < 8 && yNE >= 0) {
            if (b[xNE][yNE].isOccupied()) {
                if (b[xNE][yNE].getPiece().whatColor() == whatColor()) {
                    break;
                } else {
                    movesMap.add(new Point(xNE, yNE));
                    break;
                }
            } else {
                movesMap.add(new Point(xNE, yNE));
                yNE--;
                xNE++;
            }
        }



        int lastYabove = 0;
        int lastXright = 7;
        int lastYbelow = 7;
        int lastXleft = 0;
        
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

    public String getName(){ return "Q";}

}
