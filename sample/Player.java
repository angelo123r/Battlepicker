package sample;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Player extends Character {

    public Player(String name, int health, int damage, int speed, ImageView characterSelectImage) {
        super(name, health, damage, speed, characterSelectImage);
    }

    public Player() {
    }

    ArrayList<Player> enemyCharacters = new ArrayList<>();
    ArrayList<Player> enemyEliminateCharacters = new ArrayList<>();
    ArrayList<Player> userCharacters = new ArrayList<>();
    ArrayList<Player> userEliminateCharacters = new ArrayList<>();

    ColorAdjust noSaturation = new ColorAdjust();
    ColorAdjust normalSaturation = new ColorAdjust();


    private int totalHealth, totalDamage, totalSpeed;

    public ArrayList<Player> getEnemyCharacters() {
        return enemyCharacters;
    }

    public ArrayList<Player> getEnemyEliminateCharacters() {
        return enemyEliminateCharacters;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }

    public int getTotalSpeed() {
        return totalSpeed;
    }

    public void setTotalSpeed(int totalSpeed) {
        this.totalSpeed = totalSpeed;
    }

    //method runs each time a character image is pressed, checks how many characters the user is picking
    public int selectUserImages(Character character, int charactersSelected, Button button, int maxCharacters, ImageView image) {

        if (!character.isPressed()) {
            noSaturation.setSaturation(-1);
            charactersSelected++;
            character.setPressed(true);
            image.setEffect(noSaturation);
        } else {
            normalSaturation.setSaturation(0);
            charactersSelected--;
            character.setPressed(false);
            image.setEffect(normalSaturation);
        }

        if (charactersSelected == maxCharacters) {
            button.setDisable(false);
            button.setVisible(true);
        } else {
            button.setDisable(true);
            button.setVisible(false);
        }
        return charactersSelected;
    }


    // fills an arraylist with the enemy's selected characters & the characters the enemy chose to eliminate
    public void selectEnemyCharacters(ArrayList<Player> enemyCharacterArraylist, int maxSize, ArrayList<Character> characters) {
        while (enemyCharacterArraylist.size() < maxSize) {
            int selection = (int) (Math.random() * characters.size());
            boolean exist = false;

            // checks if the character that the enemy picked already exists in the enemy's arraylist
            for (Character character : enemyCharacterArraylist) {
                if (character.getName().equals(characters.get(selection).getName())) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                enemyCharacterArraylist.add(new Player(characters.get(selection).getName(), characters.get(selection).getHealth(), characters.get(selection).getDamage(), characters.get(selection).getSpeed(), characters.get(selection).getCharacterSelectImage()));
            }
        }
    }


    // method that will check and remove any character that matches from the user/enemy characterArraylist and eliminateArraylist
    public void subtractionCharacters(ArrayList<Player> playerCharacterArraylist, ArrayList<Player> eliminateCharacterArraylist) {
        for (int i = 0; i < playerCharacterArraylist.size(); i++) {
            for (Player eliminateCharacter : eliminateCharacterArraylist) {
                if (playerCharacterArraylist.get(i).getName().equals(eliminateCharacter.getName())) {
                    playerCharacterArraylist.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    // sets the # of characters selected back to 0
    public int setCharactersSelected(int charactersSelected) {
        return 0;
    }
}
