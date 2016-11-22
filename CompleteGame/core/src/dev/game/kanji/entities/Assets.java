package dev.game.kanji.entities;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dev.game.main.CompleteGame;

/**
 * Created by Ha San~ on 11/22/2016.
 */
public class Assets {


    private static final java.lang.String BEST_SCORE_KEY = "kanji_best_score";
    public static TextureRegion bgMenu;
    public static int bestScore;
    public static Preferences preferences;

    public static TextureRegion getTexture(String path) {
        TextureRegion sample = new TextureRegion(new Texture(path));
        return sample;
    }

    public static void init() {
        preferences = CompleteGame.preferences;
        bgMenu = getTexture("kanjinumberback.png");
        bestScore = preferences.getInteger(BEST_SCORE_KEY, 0);
    }

    public static void dispose() {
        bgMenu.getTexture().dispose();
    }

    public static void updateHighScore(int score) {
        if (score > bestScore) {
            bestScore = score;
            preferences.putInteger(BEST_SCORE_KEY, bestScore);
            preferences.flush();
        }
    }

    public static float getCenterAlignmentPositionX(float parentWidth, float parentX, int textLength, float spaceLength) {
        float middleX = parentX + parentWidth / 2;
        System.out.println(textLength);
        float offset = (float)(textLength / 2) * spaceLength;
        System.out.println(String.format("%2s", middleX - offset));
        return (middleX - offset);


    }

}