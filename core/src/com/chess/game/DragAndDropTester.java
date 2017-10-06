package com.chess.game;
/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.badlogic.gdx.utils.Array;
import com.chess.game.Materials.ChessBoard;
import com.chess.game.Materials.CollisionDetector;
import com.chess.game.chessPieces.Bishop;
import com.chess.game.chessPieces.DragAndDropPiece;
import com.chess.game.chessPieces.King;
import com.chess.game.chessPieces.Knight;
import com.chess.game.chessPieces.Pawn;
import com.chess.game.chessPieces.Queen;
import com.chess.game.chessPieces.Rook;


public class DragAndDropTester{
    private Stage stage;
    private CollisionDetector _collisionDetecter;

    private Array<DragAndDropPiece> _chessPieces;

    public void create () {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        _chessPieces = new Array<DragAndDropPiece>();

        //adding the Pawns
        for (int i = 0; i < 8; i++) {
            _chessPieces.add(new Pawn(true, i * 100, 100));
        }
        for (int i = 0; i < 8; i++) {
            _chessPieces.add(new Pawn(false, i * 100, 600));
        }
        //white pieces
        _chessPieces.add(new Queen(true, 300, 0));
        _chessPieces.add(new King(true, 400, 0));
        _chessPieces.add(new Rook(true, 0, 0));
        _chessPieces.add(new Rook(true, 700, 0));
        _chessPieces.add(new Knight(true, 100, 0));
        _chessPieces.add(new Knight(true, 600, 0));
        _chessPieces.add(new Bishop(true, 200, 0));
        _chessPieces.add(new Bishop(true, 500, 0));

        //BlackPieces
        _chessPieces.add(new Queen(false, 300, 700));
        _chessPieces.add(new King(false, 400, 700));
        _chessPieces.add(new Rook(false, 0, 700));
        _chessPieces.add(new Rook(false, 700, 700));
        _chessPieces.add(new Knight(false, 100, 700));
        _chessPieces.add(new Knight(false, 600, 700));
        _chessPieces.add(new Bishop(false, 200, 700));
        _chessPieces.add(new Bishop(false, 500, 700));

        _collisionDetecter = new CollisionDetector(_chessPieces);

        stage.addActor(new Image(new Texture("ChessBoard.png")));
        for (Actor actor : _chessPieces){
            stage.addActor(actor);
        }
    }

    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose () {
        for (Actor actor: stage.getActors()){
            if(actor instanceof DragAndDropPiece){
                ((DragAndDropPiece) actor).dispose();
            }
            else if(actor instanceof Image){
                // how do i dispose this :O ?
            }
        }

        stage.dispose();



    }
}