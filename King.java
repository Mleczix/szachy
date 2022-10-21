import java.util.ArrayList;

import java.awt.Point;

public class King extends Piece{
    public King (String color, int x, int y ){
        super(color, x ,y);
    }

    @Override
    public ArrayList<Point>  getLegalMoves(Square [][] b) {
        ArrayList<Point>  movesMap = new ArrayList<Point> ();

        var x = this.x; var y = this.y;

        for (int i = 1; i > -2; i--) {
            for (int k = 1; k > -2; k--) {
                if(i == 0 && k == 0) continue;
                try{
                    if( !b[x + i][y + k].isOccupied() ||
                        b[x + i][y + k].getPiece().whatColor() != whatColor() )
                        movesMap.add(new Point(x + i, y + k));
                } catch (ArrayIndexOutOfBoundsException e){ continue; }
            }
        }

        return movesMap;
    }


    public String getName(){ return "K";}
}