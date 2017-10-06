package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.chess.game.Materials.ChessBoard;

/**
 * Created by Tobias on 29.09.2017.
 */

public class Rook extends Chess_Piece {
    public Rook(boolean white, int x, int y, ChessBoard board){
        super(white, x, y, board);
        if (white) {
            _texture = new Texture("Rook_white.png");
        } else {
            _texture = new Texture("Rook.png");
        }
    }
}
