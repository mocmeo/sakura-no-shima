package dev.game.main;

import com.badlogic.gdx.Gdx;
import dev.game.main.CompleteGame;

/**
 * Created by Lam Ngo on 11/21/2016.
 */
public class GameHandler {
    public static int GAME_WIDTH = Gdx.graphics.getWidth();
    public static int GAME_HEIGHT = Gdx.graphics.getHeight();
//public static int GAME_WIDTH = CompleteGame.WORLD_WIDTH_TEST;
//    public static int GAME_HEIGHT = CompleteGame.WORLD_HEIGHT_TEST;

    private CompleteGame completeGame;

    public GameHandler(CompleteGame completeGame) {
        this.completeGame = completeGame;
    }
}
