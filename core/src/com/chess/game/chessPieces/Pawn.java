package com.chess.game.chessPieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.chess.game.Materials.ChessBoard;
import com.chess.game.Materials.ChessBoardTile;

/**
 * Created by Tobias on 19.09.2017.
 */

public class Pawn extends Chess_Piece {

    public Pawn(boolean white, int x, int y, ChessBoard board) {
        super(white, x, y, board);
        _board = board;


        if (_white) {
            _texture = new Texture("Pawn_white.png");
        } else {
            _texture = new Texture("Pawn.png");
        }

    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(_texture, _bounds.x, _bounds.y);
    }


    //public void update() {

    //}

    public void dispose() {
        _texture.dispose();
    }
}
