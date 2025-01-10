package com.bersebranggame.objects.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Chicken extends Character {
    // Movement Animations
    private Animation<TextureRegion> moveUpAnimation;
    private Animation<TextureRegion> moveDownAnimation;
    private Animation<TextureRegion> moveLeftAnimation;
    private Animation<TextureRegion> moveRightAnimation;

    // Idle Animations
    private Animation<TextureRegion> idleUpAnimation;
    private Animation<TextureRegion> idleDownAnimation;
    private Animation<TextureRegion> idleLeftAnimation;
    private Animation<TextureRegion> idleRightAnimation;

    // Track animation state
    private float stateTime = 0f;
    private Animation<TextureRegion> currentAnimation;
    private boolean isMoving = false;

    public Chicken() {
        super(1f, 0.8f, 4f, "Char_001_Init.png");
        loadAnimations();
    }

    private void loadAnimations() {
        // Load movement sprite sheet
        Texture moveSheet = new Texture("Char_001.png");
        // Load idle sprite sheet
        Texture idleSheet = new Texture("Char_001_Idle.png");

        // Assuming 4 columns for animation frames
        int frameCols = 4;
        int frameRows = 4;

        // Initialize movement animations (rows 0-3 for movement)
        moveDownAnimation = initializeAnimation(moveSheet, frameCols, frameRows, 0);
        moveLeftAnimation = initializeAnimation(moveSheet, frameCols, frameRows, 1);
        moveRightAnimation = initializeAnimation(moveSheet, frameCols, frameRows, 2);
        moveUpAnimation = initializeAnimation(moveSheet, frameCols, frameRows, 3);

        // Initialize idle animations (rows 0-3 for idle in different directions)
        idleDownAnimation = initializeAnimation(idleSheet, frameCols, frameRows, 0);
        idleLeftAnimation = initializeAnimation(idleSheet, frameCols, frameRows, 1);
        idleRightAnimation = initializeAnimation(idleSheet, frameCols, frameRows, 2);
        idleUpAnimation = initializeAnimation(idleSheet, frameCols, frameRows, 3);


    }

    private Animation<TextureRegion> initializeAnimation(
        Texture spriteSheet,
        int frameCols,
        int frameRows,
        int rowIndex
    ) {
        // Split sprite sheet into frames
        TextureRegion[][] tmp = TextureRegion.split(spriteSheet,
            spriteSheet.getWidth() / frameCols,
            spriteSheet.getHeight() / frameRows);

        // Extract the specific row for this animation
        TextureRegion[] animationFrames = tmp[rowIndex];

        // Create animation with frame duration of 0.1 seconds
        return new Animation<>(0.1f, animationFrames);
    }

    @Override
    public void moveUp() {
        super.moveUp();
        currentAnimation = moveUpAnimation;
        isMoving = true;
        updateAnimationState();
    }

    @Override
    public void moveDown() {
        super.moveDown();
        currentAnimation = moveDownAnimation;
        isMoving = true;
        updateAnimationState();
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        currentAnimation = moveLeftAnimation;
        isMoving = true;
        updateAnimationState();
    }

    @Override
    public void moveRight() {
        super.moveRight();
        currentAnimation = moveRightAnimation;
        isMoving = true;
        updateAnimationState();
    }

    // Call this method when character stops moving
    public void stopMoving() {
        isMoving = false;
        // Set idle animation based on last movement direction
        if (currentAnimation == moveUpAnimation) {
            currentAnimation = idleUpAnimation;
        } else if (currentAnimation == moveDownAnimation) {
            currentAnimation = idleDownAnimation;
        } else if (currentAnimation == moveLeftAnimation) {
            currentAnimation = idleLeftAnimation;
        } else if (currentAnimation == moveRightAnimation) {
            currentAnimation = idleRightAnimation;
        }
        stateTime = 0f;
    }

    private void updateAnimationState() {
        stateTime += Gdx.graphics.getDeltaTime();
        this.sprite.setRegion(currentAnimation.getKeyFrame(stateTime, true));
    }

    @Override
    public void update() {
        // If not moving, ensure idle animation is displayed
        if (!isMoving) {
            updateAnimationState();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        // Dispose of all textures
        disposeAnimationTextures(moveUpAnimation, moveDownAnimation,
            moveLeftAnimation, moveRightAnimation,
            idleUpAnimation, idleDownAnimation,
            idleLeftAnimation, idleRightAnimation);
    }

    private void disposeAnimationTextures(Animation<TextureRegion>... animations) {
        for (Animation<TextureRegion> animation : animations) {
            if (animation != null) {
                for (TextureRegion region : animation.getKeyFrames()) {
                    if (region != null && region.getTexture() != null) {
                        region.getTexture().dispose();
                    }
                }
            }
        }
    }
}
