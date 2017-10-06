package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.chess.game.Materials.ChessBoard;

/**
 * Created by Tobias on 29.09.2017.
 */

public class Rook extends DragAndDropPiece {
    public Rook(boolean white, int x, int y){
        super(white, x, y);
        if (white) {
            _sprite = new Sprite(new Texture("Rook_white.png"));
        } else {
            _sprite = new Sprite(new Texture("Rook.png"));
        }
    }

    @Override
    boolean testForIlligalMoves(float x, float y) {
        return true;
    }
}
