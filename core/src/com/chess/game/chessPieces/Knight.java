package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.chess.game.Materials.ChessBoard;

/**
 * Created by Tobias on 29.09.2017.
 */

public class Knight extends DragAndDropPiece {

    public Knight(boolean white, int x, int y){
        super(x, y);
        if (white) {
            _sprite = new Sprite(new Texture("Pawn.png"));
        } else {
            _sprite = new Sprite(new Texture("Pawn.png"));
        }
    }
}
