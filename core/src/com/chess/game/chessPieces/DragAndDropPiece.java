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

public class DragAndDropPiece extends Actor{
    Sprite _sprite;

    public DragAndDropPiece(){
        _sprite = new Sprite(new Texture("Queen_white.png"));
        setWidth(_sprite.getWidth());
        setHeight(_sprite.getHeight());
        setBounds(50, 50, getWidth(), getHeight());
        setX(100);
        setY(100);
        addListener(new DragListener(){
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                setX(x + getX() - (getWidth() / 2));
                setY(y + getY() - (getHeight() / 2));
                System.out.println("Drag: " + getX() + " : "+ getY());
            }
        });
    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(_sprite, getX(), getY());
    }
}