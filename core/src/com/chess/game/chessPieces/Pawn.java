package com.chess.game.chessPieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.chess.game.Materials.ChessBoard;
import com.chess.game.Materials.ChessBoardTile;

/**
 * Created by Tobias on 19.09.2017.
 */

public class Pawn extends DragAndDropPiece {

    public Pawn(boolean white, int x, int y) {
        super(x, y);
        if (white) {
            _sprite = new Sprite(new Texture("Pawn_white.png"));
        } else {
            _sprite = new Sprite(new Texture("Pawn.png"));
        }
    }
}
