package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.chess.game.Materials.ChessBoard;

/**
 * Created by Tobias on 29.09.2017.
 */

public class Queen extends DragAndDropPiece {


    public Queen(boolean white, int x, int y) {
        super(x, y);
        if (white) {
            _sprite = new Sprite(new Texture("Queen_white.png"));
        } else {
            _sprite = new Sprite(new Texture("Queen.png"));
        }

    }
}
