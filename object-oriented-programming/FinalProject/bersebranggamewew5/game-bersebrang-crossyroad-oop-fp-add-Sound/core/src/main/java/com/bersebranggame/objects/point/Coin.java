package com.bersebranggame.objects.point;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bersebranggame.Entity;
import com.bersebranggame.behaviour.Update;

public class Coin extends Entity implements Update {
    private Animation<TextureRegion> animation;
    private Texture spriteSheet;
    private float stateTime;

    public Coin(float x, float y, float width, float height, String imagePath, int frameCols, int frameRows) {
        super(x, y, width, height);
        spriteSheet = new Texture(imagePath);  // Load the sprite sheet
        initializeAnimation(spriteSheet, frameCols, frameRows);


        // Initialize the sprite with the first frame of the animation
        this.sprite = new Sprite(animation.getKeyFrame(0));
        sprite.setBounds(x, y, width, height); // Set sprite bounds to match coin's dimensions
    }

    private void initializeAnimation(Texture spriteSheet, int frameCols, int frameRows) {
        // Split sprite sheet into frames
        TextureRegion[][] tmp = TextureRegion.split(spriteSheet,
            spriteSheet.getWidth() / frameCols,
            spriteSheet.getHeight() / frameRows);

        TextureRegion[] animationFrames = new TextureRegion[frameCols * frameRows];
        int index = 0;
        for (int i = 0; i < frameRows; i++) {
            for (int j = 0; j < frameCols; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }

        // Create animation with frame duration of 0.1 seconds
        animation = new Animation<>(0.1f, animationFrames);
        stateTime = 0f;
    }

    @Override
    public void update() {
        stateTime += com.badlogic.gdx.Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        sprite.setRegion(currentFrame);
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
        sprite.getTexture().dispose();  // Dispose sprite's texture as well
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
