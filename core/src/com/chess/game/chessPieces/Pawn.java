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

    private Texture _texture;

    private Rectangle _pawn;

    private final boolean _white;

    private ChessBoard _board;

    public Pawn(boolean white, int x, int y, ChessBoard board) {
        _pawn = new Rectangle(x, y, 100, 100);
        _white = white;
        _board = board;


        if(_white){
            _texture = new Texture("Pawn_white.png");
        }
        else{
            _texture = new Texture("Pawn.png");
        }

    }


    public void draw(SpriteBatch batch) {
        batch.draw(_texture, _pawn.x, _pawn.y);
    }

    @Override
    public void update() {
        if (_pawn.x <= Gdx.input.getX() && Gdx.input.getX() <= (_pawn.x + 100) && _pawn.y <= (800 - Gdx.input.getY()) && (800 - Gdx.input.getY()) <= (_pawn.y + 100)){
            float previousX = _pawn.x;
            float previousY = _pawn.y;
            //System.out.println("is touched");
            //System.out.println("Location pawn" + _pawn.x + _pawn.y);
            //System.out.println("Location curser" + Gdx.input.getX() +" - " +  Gdx.input.getY());
            if (Gdx.input.isTouched()) {
                _pawn.setPosition( Gdx.input.getX() - 50, (800 - Gdx.input.getY()) - 50);
                _board.tileAtCoordinatesOccupy( Gdx.input.getX(), (800 - Gdx.input.getY()), _white);
            }
        }
    }

    public void dispose() {
        _texture.dispose();
    }
}
