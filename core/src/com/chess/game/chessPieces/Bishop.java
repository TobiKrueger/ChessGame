package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.chess.game.Materials.ChessBoard;

/**
 * Created by Tobias on 29.09.2017.
 */

public class Bishop extends Chess_Piece{
    public Bishop(boolean white, int x, int y, ChessBoard board){
        super(white, x, y, board);
        if (white) {
            _texture = new Texture("Pawn.png");
        } else {
            _texture = new Texture("Pawn.png");
        }
    }
}
