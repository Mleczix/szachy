import java.util.ArrayList;

import java.awt.Point;

abstract public class Piece{
    private boolean killed = false;
    private String color;
    protected int x, y;


    
    public Piece(String color, int x, int y)
    {
        this.x = x; this.y = y;
        this.setColor(color);
        
    }

    public void move(Square to){
        this.x = to.getdX();
        this.y = to.getdY();
    }

    public String  whatColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isKilled()
    {
        return this.killed;
    }

    public void setKilled(boolean killed)
    {
        this.killed = killed;
    }

    abstract public String getName();

    abstract public ArrayList<Point>  getLegalMoves(Square [][] b);

}
