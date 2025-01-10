package com.bersebranggame.objects.obstacle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.canvas.Gameplay;

public class Obstacle extends Gameplay {
    private int width, height;
    private float positionX, positionY, speed;
    private String image;

    // Default constructor
    public Obstacle() {
        this.width = 0;
        this.height = 0;
        this.positionX = 0;
        this.positionY = 0;
        this.image = "";
        this.texture = null;
    }

    // Constructor with all parameters
    public Obstacle(int width, int height, float positionX, float positionY, String image) {
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;
        this.image = image;
        this.texture = new Texture(image);
        this.sprite = new Sprite(texture);
        this.sprite.setSize(width,height);
    }

    // Constructor with optional position (position defaults to 0, 0)
    public Obstacle(int width, int height,  String image) {
        this(width, height, 0, 0,  image);
    }

    public void setImage(String image) {
        this.image = image;
        if (texture != null) {
            texture.dispose(); // Dispose previous texture to free memory
        }
        this.texture = new Texture(image);
        this.sprite = new Sprite(texture);
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        this.sprite = new Sprite(texture);
    }
}
