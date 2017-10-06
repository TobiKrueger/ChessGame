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
    private boolean _neverMovedBefore;

    public Pawn(boolean white, int x, int y) {
        super(white, x, y);
        if (white) {
            _sprite = new Sprite(new Texture("Pawn_white.png"));
        } else {
            _sprite = new Sprite(new Texture("Pawn.png"));
        }
        _neverMovedBefore = true;
    }

    @Override
    boolean testForIlligalMoves(float x, float y) {

        if ((_previousX - 50) < getX() && getX() < (_previousX + 50) && (_previousY - 50) < getY() && getY() < (_previousY + 250)){
            if(_neverMovedBefore){
                _neverMovedBefore = false;
                return true;
            }
            System.out.println("Move is legal");
            return getY() < (_previousY + 150);
        }


        return false;
    }
}
