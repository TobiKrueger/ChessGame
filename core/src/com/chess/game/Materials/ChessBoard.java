package com.chess.game.Materials;

import com.chess.game.chessPieces.Chess_Piece;

/**
 * Created by Tobias on 20.09.2017.
 */

public class ChessBoard {

    // two dimensional array is a good idea but very complicated easier way ???

    private ChessBoardTile[][] _tiles;

    public ChessBoard(){
        _tiles = new ChessBoardTile[8][8];
        int x = 0;
        int y = 0;

        for(int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                _tiles[row][col] = new ChessBoardTile(x, y);
                x += 100;
            }
            x = 0;
            y += 100;
        }
    }


    /**
     * Method to tell the tile wich color is on it
     * @param x specifies the x coordinate of the tile
     * @param y specifies the y coordinate of the tile
     * @param white specifies wtether the piece is white(true) or black(false)
     */
    public void tileAtCoordinatesOccupy(int x, int y, boolean white){

        byte occupation;
        if (white){
            occupation = ChessBoardTile.WHITE_OCCUPIED;
        }
        else{
            occupation = ChessBoardTile.BLACK_OCCUPIED;
        }
        tileAtCoordinatesOccupy(x, y, occupation);
    }

    /**
     * Method to tell a tile what is on it or that it is empty again
     *
     */
    public void tileAtCoordinatesOccupy(int x, int y, byte occupation){
        //checking if either of the coordinates are zero => then assigning the tile to an occupation
        // x and y are in the wrong order FAAAAACK its all because of that shitty two dimensional array
        if(x == 0){
            _tiles[(int)(y / 100)][0].setOccupation(occupation);
        }
        else if(y == 0){
            _tiles[0][(int)(x/100)].setOccupation(occupation);
        }
        else{
            _tiles[(int)(y / 100)][(int)(x/100)].setOccupation(occupation);
        }

    }
}
