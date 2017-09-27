package com.chess.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.chess.game.ChessGame;
import com.chess.game.Materials.ChessBoard;
import com.chess.game.chessPieces.Chess_Piece;
import com.chess.game.chessPieces.Pawn;

/**
 * Created by Tobias on 20.09.2017.
 */

public class GameScreen implements Screen {
    //the main Game part
    private final ChessGame _game;

    //Camera for the right point of View
    private OrthographicCamera _camera;

    //the Textures needed for the game
    private Texture _background;

    //the pieces
    //private Pawn _pawn_black1;

    //Idea for later instead of saving every single piece by itself
    private Array<Chess_Piece> _pieces;

    //Just an idea how to handle the Chess rules by creating a board grid
    private ChessBoard _board;

    public GameScreen(final ChessGame game) {
        _game = game;

        //setting up the Camera
        _camera = new OrthographicCamera();
        _camera.setToOrtho(false, _game.SCREENSIZE_X, _game.SCREENSIZE_Y);

        //loading Textures
        _background = new Texture("ChessBoard.png");

        _board = new ChessBoard();

        //setting up the pieces
        //_pawn_black1 = new Pawn();
        _pieces = new Array<Chess_Piece>(16);
        for (int i = 0; i < 8; i++) {
            _pieces.add(new Pawn(true, i * 100, 600, _board));
        }
        for (int i = 0; i < 8; i++) {
            _pieces.add(new Pawn(false, i * 100, 100, _board));
        }


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //clearing the Screen
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        _camera.update();

        _game._batch.setProjectionMatrix(_camera.combined);

        //_pawn_black1.update();
        for (Chess_Piece piece : _pieces) {
            piece.update();
        }
        //Start rendering stuff
        _game._batch.begin();

        _game._batch.draw(_background, 0, 0);

        //creating the pieces
        //_pawn_black1.draw(_game._batch);
        for(Chess_Piece piece: _pieces){
            piece.draw(_game._batch);
        }

        _game._batch.end();


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
        _background.dispose();

    }
}
