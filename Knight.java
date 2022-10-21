import java.util.ArrayList;

import java.awt.Point;

public class Knight extends Piece {
    public Knight(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public ArrayList<Point> getLegalMoves(Square[][] b) {
        ArrayList<Point> movesMap = new ArrayList<Point>();

        for (int i = 2; i > -3; i--) {
            for (int k = 2; k > -3; k--) {
                if (Math.abs(i) == 2 ^ Math.abs(k) == 2) {
                    if (k != 0 && i != 0) {
                        try {
                            if (!b[x + i][y + k].isOccupied() ||
                                    b[x + i][y + k].getPiece().whatColor() != whatColor())
                                movesMap.add(new Point(x + i, y + k));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }

        return movesMap;
    }

    public String getName() {
        return "N";
    }

}
