package com.chess.game.Materials;

/**
 * Created by Tobias on 20.09.2017.
 */
public class ChessBoardTile {
    private int _startX;
    private int _endX;
    private int _startY;
    private int _endY;
    private byte _occupation;

    public static final byte NOT_OCCUPIED = 0;
    public static final byte WHITE_OCCUPIED = 1;
    public static final byte BLACK_OCCUPIED = 2;

    public ChessBoardTile(int x, int y){
        // This way each cell is exactly 100 by 100 pixels big
        _startX = x;
        _endX = x + 100;
        _startY = y;
        _endY = y + 100;
        System.out.println("Cell coordinates " + _startX + " - " + _endX);
        _occupation = NOT_OCCUPIED;
    }

    public void setOccupation(byte occupation){
        _occupation = occupation;
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        return "Bounds of this cell X = " + _startX + "-" + _endX + "    Y = " + _startY + "-" + _endY;
    }
}
