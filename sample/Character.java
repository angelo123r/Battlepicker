package sample;

import javafx.scene.image.ImageView;

public class Character {

    private String name;
    private int health, damage, speed;
    private boolean pressed;
    private ImageView characterSelectImage, characterEliminateImage;

    public Character(String name, int health, int damage, int speed, boolean pressed, ImageView characterSelectImage, ImageView characterEliminateImage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.pressed = pressed;
        this.characterSelectImage = characterSelectImage;
        this.characterEliminateImage = characterEliminateImage;
    }

    public Character(String name, int health, int damage, int speed, ImageView characterSelectImage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.characterSelectImage = characterSelectImage;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public ImageView getCharacterSelectImage() {
        return characterSelectImage;
    }

    public void setCharacterSelectImage(ImageView characterSelectImage) {
        this.characterSelectImage = characterSelectImage;
    }

    public ImageView getCharacterEliminateImage() {
        return characterEliminateImage;
    }

    public void setCharacterEliminateImage(ImageView characterEliminateImage) {
        this.characterEliminateImage = characterEliminateImage;
    }
}
