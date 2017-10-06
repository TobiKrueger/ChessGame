package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.chess.game.Materials.ChessBoard;

/**
 * Created by Tobias on 29.09.2017.
 */

public class Bishop extends DragAndDropPiece {

    public Bishop(boolean white, int x, int y) {
        super(white, x, y);
        if (white) {
            _sprite = new Sprite(new Texture("Pawn.png"));
        } else {
            _sprite = new Sprite(new Texture("Pawn.png"));
        }
    }

    @Override
    boolean testForIlligalMoves(float x, float y) {
        return true;
    }
}