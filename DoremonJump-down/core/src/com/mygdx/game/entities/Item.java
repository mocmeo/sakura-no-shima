package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.mygdx.game.gfx.Assets;
import com.mygdx.game.main.Handler;

/**
 * Created by Nghia on 11/12/2016.
 */

public class Item extends Entity {

    private static final int DEFAULT_WIDTH = Handler.GAME_WIDTH / 8;
    private static final int DEFAULT_HEIGHT = (int) (Handler.GAME_HEIGHT / 12.5);
    private static final int DEFAULT_BOUNDS_RADIUS = (int) (Handler.GAME_WIDTH / 3.2);
    private static final int DEFAULT_TYPE = 0;

    private Circle gravityCircle;

    private int type;
    private boolean alive;

    public Item(Handler handler, float x, float y, int type) {
        super(handler, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        if (type < Assets.itemTypes.size()) {
            this.type = type;
        } else {
            this.type = DEFAULT_TYPE;
        }

        gravityCircle = new Circle(x, y, DEFAULT_BOUNDS_RADIUS);
        alive = false;
    }

    @Override
    public String toString() {
        return Assets.itemTypes.get(type).toString();
    }

    @Override
    public void tick() {
        updateBounds();
        updateGravityCircle();
    }


    public int getType() {
        return type;
    }


    public boolean isAlive() {
        return alive;
    }


    public boolean isCollidable() {
        return isAlive() && getY()+getHeight() <= Handler.GAME_HEIGHT;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    @Override
    public void render(SpriteBatch batch) {
        if (alive) {
            batch.draw(Assets.itemTypes.get(type).getItemTextureRegion(), x, y, width, height);
        }
    }

    public void getNewRandomType() {
        type = (int) (Math.random() * (Assets.itemTypes.size()));
    }

    public void updateWithPlatform(Platform platform) {
        setX(platform.getX() + (platform.getWidth() - getWidth()) / 2);
        setY(platform.getY() - getHeight());
        updateBounds();
        updateGravityCircle();
    }

    private void updateGravityCircle() {
        gravityCircle.setX(x);
        gravityCircle.setY(y);
    }

    public boolean gravityRangeReached(Entity target) {
        return gravityCircle.contains(target.getMiddleX(), target.getMiddleY());
    }

    public ItemAttributes getItemAttributes() {
        return Assets.itemTypes.get(type);
    }


    public static Item createRandomItemForPlatfrom(Handler handler, Platform platform) {
        return new Item(handler, platform.getX() + (platform.getWidth() - DEFAULT_WIDTH) / 2
                , platform.getY() - DEFAULT_HEIGHT
                , (int) (Math.random() * (Assets.itemTypes.size())));
    }

    public void dispose() {

    }




}
