package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.chess.game.Materials.CollisionDetector;

/**
 * Created by Tobias on 05.10.2017.
 */

public abstract class DragAndDropPiece extends Actor {
    protected Sprite _sprite;
    protected boolean _white;
    protected float _previousX;
    protected float _previousY;
    protected Rectangle _bounds;
    protected CollisionDetector _collisionDetector;

    public DragAndDropPiece(boolean white, int x, int y) {
        _white = white;
        _sprite = new Sprite(new Texture("Queen_white.png"));
        setWidth(_sprite.getWidth());
        setHeight(_sprite.getHeight());
        setX(x);
        setY(y);
        //Should be more obvious why (smaller Hitbox to prevent premature Collision)
        _bounds = new Rectangle(x + 25, y + 25, getWidth() / 2, getHeight() / 2);
        addListener(new DragListener() {
            @Override
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                _previousX = getX();
                _previousY = getY();
            }

            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                setX(x + getX() - (getWidth() / 2));
                setY(y + getY() - (getHeight() / 2));
                _bounds.setCenter(x + getX(), y + getY());
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                float newX = x + getX() - (getWidth() / 2);
                float newY = x + getX() - (getWidth() / 2);

                if (testForIlligalMoves(newX, newY)) {
                    testForCollision();
                }
                else{
                    resetPosition();
                }
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(_sprite, getX(), getY());
    }

    public Rectangle get_bounds() {
        return _bounds;
    }

    public boolean get_white() {
        return _white;
    }

    /**
     * Function to determine wether this piece can make that move or not
     *
     * @return true if the move is legal and can be made
     */
    abstract boolean testForIlligalMoves(float x, float y);

    public void registerObserver(CollisionDetector collisionDetector) {
        _collisionDetector = collisionDetector;
    }

    public void testForCollision() {
        _collisionDetector.informAboutCollision(this);
    }

    public void reactToCollision(DragAndDropPiece collisionObjekt) {
        if (collisionObjekt.get_white() == _white) {
            resetPosition();
        } else {
            collisionObjekt.clear();
            collisionObjekt.setVisible(false);
        }
    }

    private void resetPosition(){
        setX(_previousX);
        setY(_previousY);
    }

    public void dispose() {
        _sprite.getTexture().dispose();
    }

}
