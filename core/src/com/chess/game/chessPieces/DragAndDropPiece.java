package com.chess.game.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * Created by Tobias on 05.10.2017.
 */

public abstract class DragAndDropPiece extends Actor {
    protected Sprite _sprite;

    public DragAndDropPiece(int x, int y) {
        _sprite = new Sprite(new Texture("Queen_white.png"));
        setWidth(_sprite.getWidth());
        setHeight(_sprite.getHeight());
        setX(x);
        setY(y);
        addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                setX(x + getX() - (getWidth() / 2));
                setY(y + getY() - (getHeight() / 2));
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(_sprite, getX(), getY());
    }

    public void dispose(){
        _sprite.getTexture().dispose();
    }

}
