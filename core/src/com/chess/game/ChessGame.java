package com.chess.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chess.game.Screens.MainMenuScreen;
import com.chess.game.chessPieces.Pawn;

import org.omg.CosNaming._BindingIteratorImplBase;

public class ChessGame extends Game {
    public static final int SCREENSIZE_X = 800, SCREENSIZE_Y = 800;

    //SpriteBatch is used to draw stuff to the screen
    public SpriteBatch _batch;

    //To display text to the User
    public BitmapFont _font;

    @Override
    public void create() {
        _batch = new SpriteBatch();
        _font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        _batch.dispose();
        _font.dispose();
    }
}
