package com.chess.game.chessPieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.chess.game.Materials.ChessBoard;


/**
 * Created by Tobias on 19.09.2017.
 */

public abstract class Chess_Piece {
    protected Rectangle _bounds;
    protected ChessBoard _board;
    protected Texture _texture;
    protected final boolean _white;

    public Chess_Piece(){
        _white = false;

    }
    public Chess_Piece(boolean white, int x, int y, ChessBoard board){
        _bounds = new Rectangle(x, y, 100, 100);
        _texture = new Texture("badlogic.jpg");
        _white = white;
    }
    public void update() {
        if (_bounds.x <= Gdx.input.getX() && Gdx.input.getX() <= (_bounds.x + 100) && _bounds.y <= (800 - Gdx.input.getY()) && (800 - Gdx.input.getY()) <= (_bounds.y + 100)) {
            float previousX = _bounds.x;
            float previousY = _bounds.y;
            //System.out.println("is touched");
            //System.out.println("Location pawn" + _pawn.x + _pawn.y);
            //System.out.println("Location curser" + Gdx.input.getX() +" - " +  Gdx.input.getY());
            if (Gdx.input.isTouched()) {
                _bounds.setPosition(Gdx.input.getX() - 50, (800 - Gdx.input.getY()) - 50);
                //_board.tileAtCoordinatesOccupy(Gdx.input.getX(), (800 - Gdx.input.getY()), _white);
            }
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(_texture, _bounds.x, _bounds.y);
    }
}
