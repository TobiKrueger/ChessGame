package com.chess.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.chess.game.ChessGame;
import com.chess.game.chessPieces.Chess_Piece;
import com.chess.game.chessPieces.Pawn;

/**
 * Created by Tobias on 20.09.2017.
 */

public class MainMenuScreen implements Screen{
    private final ChessGame _game;
    private OrthographicCamera _camera;


    public MainMenuScreen(final ChessGame game){
        _game = game;

        _camera = new OrthographicCamera();
        _camera.setToOrtho(false, 800, 800);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        _game._batch.begin();
        _game._font.draw(_game._batch, "Welcome to Chess :D", 100, 150);
        _game._font.draw(_game._batch, "Tap to start a match", 100, 100);
        _game._batch.end();

        if(Gdx.input.isTouched()){
            _game.setScreen(new GameScreen(_game));
            dispose();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
