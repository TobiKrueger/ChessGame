package com.chess.game.Materials;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.chess.game.chessPieces.DragAndDropPiece;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Tobias on 06.10.2017.
 */

public class CollisionDetector{
    private Array<DragAndDropPiece> _pieces;
    public CollisionDetector(Array<DragAndDropPiece> pieces){
        _pieces = pieces;
        for(DragAndDropPiece piece : pieces){
            piece.registerObserver(this);
        }

    }
    public void informAboutCollision(DragAndDropPiece activePiece) {
        for(DragAndDropPiece piece: _pieces){
            if(piece.equals(activePiece)){
                //do nothing i guess ?
            }
            else if(activePiece.get_bounds().overlaps(piece.get_bounds())){
                activePiece.reactToCollision(piece);
                System.out.println("Collision");
                // _pieces.removeIndex(_pieces.indexOf(activePiece, true));
                break;
            }
        }
    }
}
