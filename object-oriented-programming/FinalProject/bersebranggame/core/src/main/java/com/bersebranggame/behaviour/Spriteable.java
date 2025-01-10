package com.bersebranggame.behaviour;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public interface Spriteable {
    public void setTexture(Texture texture);
    public Texture getTexture();
    public void setSprite(Sprite sprite);
    public Sprite getSprite();
    public void setImage(String image);
    public String getImage();
}
