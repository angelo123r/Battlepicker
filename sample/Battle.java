package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Battle {

    @FXML
    private Text finalCharacterHealth1;

    @FXML
    private Text finalCharacterHealth2;

    @FXML
    private Text winner;

    @FXML
    private ImageView userCharacterImage1;

    @FXML
    private ImageView userCharacterImage2;

    @FXML
    private ImageView userCharacterImage3;

    @FXML
    private ImageView userCharacterImage4;

    @FXML
    private ImageView userCharacterImage5;

    @FXML
    private ImageView enemyCharacterImage1;

    @FXML
    private ImageView enemyCharacterImage2;

    @FXML
    private ImageView enemyCharacterImage3;

    @FXML
    private ImageView enemyCharacterImage4;

    @FXML
    private ImageView enemyCharacterImage5;

    @FXML
    private Text speedTieBreaker;

    FileWriter fileWriter = new FileWriter("src/sample/battleLog");
    PrintWriter printWriter = new PrintWriter(fileWriter);

    public Battle() throws IOException {
    }


    public void addStats(Player user, Player enemy) {
        for (Character userCharacter : user.userCharacters) {
            user.setTotalHealth(user.getTotalHealth() + userCharacter.getHealth());
            user.setTotalDamage(user.getTotalDamage() + userCharacter.getDamage());
            user.setTotalSpeed(user.getTotalSpeed() + userCharacter.getSpeed());
        }

        for (Character enemyCharacter : enemy.enemyCharacters) {
            enemy.setTotalHealth(enemy.getTotalHealth() + enemyCharacter.getHealth());
            enemy.setTotalDamage(enemy.getTotalDamage() + enemyCharacter.getDamage());
            enemy.setTotalSpeed(enemy.getTotalSpeed() + enemyCharacter.getSpeed());
        }
        finalCharacterHealth1.setText("Health: " + user.getTotalHealth() + "\nDamage: " + user.getTotalDamage() + "\nSpeed: " + user.getTotalSpeed());
        finalCharacterHealth2.setText("Health: " + enemy.getTotalHealth() + "\nDamage: " + enemy.getTotalDamage() + "\nSpeed: " + enemy.getTotalSpeed());
    }

    // sets the images of the characters that are not eliminated. If they are eliminated then the picture is a red X
    public void setPlayerImages(Player user, Player enemy) {
        for (int i = 0; i < user.userCharacters.size(); i++) {
            switch (i) {
                case 0 -> userCharacterImage1.setImage(user.userCharacters.get(i).getCharacterSelectImage().getImage());
                case 1 -> userCharacterImage2.setImage(user.userCharacters.get(i).getCharacterSelectImage().getImage());
                case 2 -> userCharacterImage3.setImage(user.userCharacters.get(i).getCharacterSelectImage().getImage());
                case 3 -> userCharacterImage4.setImage(user.userCharacters.get(i).getCharacterSelectImage().getImage());
                case 4 -> userCharacterImage5.setImage(user.userCharacters.get(i).getCharacterSelectImage().getImage());
            }
        }
        for (int i = 0; i < enemy.enemyCharacters.size(); i++) {
            switch (i) {
                case 0 -> enemyCharacterImage1.setImage(enemy.enemyCharacters.get(i).getCharacterSelectImage().getImage());
                case 1 -> enemyCharacterImage2.setImage(enemy.enemyCharacters.get(i).getCharacterSelectImage().getImage());
                case 2 -> enemyCharacterImage3.setImage(enemy.enemyCharacters.get(i).getCharacterSelectImage().getImage());
                case 3 -> enemyCharacterImage4.setImage(enemy.enemyCharacters.get(i).getCharacterSelectImage().getImage());
                case 4 -> enemyCharacterImage5.setImage(enemy.enemyCharacters.get(i).getCharacterSelectImage().getImage());
            }
        }

    }


    public void battleSimulation(Player user, Player enemy) {
        int speedDraw = 0;

        if (user.getTotalSpeed() == enemy.getTotalSpeed()) {
            speedDraw = (int) (Math.random() * 2);                                                                                                              // 0 = enemy goes first, 1 = user goes first
            speedTieBreaker.setText(speedDraw != 1 ? "Enemy won the speed tie Breaker! They move first." : "User won the speed tie breaker! They move first.");
        }

        // runs until a player's health is 0 or below
        while (user.getTotalHealth() > 0 && enemy.getTotalHealth() > 0) {

            if (user.getTotalSpeed() > enemy.getTotalSpeed() || speedDraw == 1) {
                userAttack(user, enemy);

                if (enemy.getTotalHealth() > 0) {
                    enemyAttack(user, enemy);
                }

            } else {
                enemyAttack(user, enemy);

                if (user.getTotalHealth() > 0) {
                    userAttack(user, enemy);

                }
            }
        }

        if (user.getTotalHealth() > 0) {
            winner.setText("USER WON!");
        } else {
            winner.setText("ENEMY WON!");
        }
        printWriter.close();
    }

    public void userAttack(Player user, Player enemy) {
        enemy.setTotalHealth(enemy.getTotalHealth() - user.getTotalDamage());
        printWriter.println("User attacked Enemy (" + user.getTotalDamage() + " DMG). " + enemy.getTotalHealth() + "HP remaining.");
    }

    public void enemyAttack(Player user, Player enemy) {
        user.setTotalHealth(user.getTotalHealth() - enemy.getTotalDamage());
        printWriter.println("Enemy attacked User (" + enemy.getTotalDamage() + " DMG). " + user.getTotalHealth() + "HP remaining.");
    }
}
