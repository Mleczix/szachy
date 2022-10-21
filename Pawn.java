import java.util.ArrayList;

import java.awt.Point;

public class Pawn extends Piece {

    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public ArrayList<Point>  getLegalMoves(Square [][] b) {
        ArrayList<Point>  movesMap = new ArrayList<Point> ();

        if (whatColor() == "white") {
            var x = this.x + 1;
            if (x < 8 && !b[x][this.y].isOccupied())
                movesMap.add(new Point(x, this.y));

            // zbijanie

            if (this.y + 1 < 8 && b[x][this.y + 1].isOccupied() && b[x][this.y + 1].getPiece().whatColor() != whatColor())
                movesMap.add(new Point(x, this.y + 1));

            if (this.y - 1 >= 0 &&  b[x][this.y - 1].isOccupied() && b[x][this.y - 1].getPiece().whatColor() != whatColor())
                movesMap.add(new Point(x, this.y - 1));
        } else {
            var x = this.x - 1;
            if (x >= 0 && !b[x][this.y].isOccupied())
                movesMap.add(new Point(x, this.y));

            // zbijanie

            if (this.y + 1 < 8 && b[x][this.y + 1].isOccupied() && b[x][this.y + 1].getPiece().whatColor() != whatColor())
                movesMap.add(new Point(x, this.y + 1));

            if (this.y - 1 >= 0 && b[x][this.y - 1].isOccupied() && b[x][this.y - 1].getPiece().whatColor() != whatColor())
                movesMap.add(new Point(x, this.y - 1));
        }

        return movesMap;
    }

    public String getName() {
        return "P";
    }

}
