package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private ImageView chickenImage;

    @FXML
    private ImageView bearImage;

    @FXML
    private ImageView crocImage;

    @FXML
    private ImageView turtleImage;

    @FXML
    private ImageView elephantImage;

    @FXML
    private ImageView bisonImage;

    @FXML
    private ImageView birdImage;

    @FXML
    private ImageView rabbitImage;

    @FXML
    private ImageView cheetahImage;

    @FXML
    private ImageView pigImage;

    @FXML
    private Button selectBtn;

    @FXML
    private ImageView chickenEliminateImage;

    @FXML
    private ImageView bearEliminateImage;

    @FXML
    private ImageView crocEliminateImage;

    @FXML
    private ImageView turtleEliminateImage;

    @FXML
    private ImageView elephantEliminateImage;

    @FXML
    private ImageView bisonEliminateImage;

    @FXML
    private ImageView birdEliminateImage;

    @FXML
    private ImageView rabbitEliminateImage;

    @FXML
    private ImageView cheetahEliminateImage;

    @FXML
    private ImageView pigEliminateImage;

    @FXML
    private Text chickenStats;

    @FXML
    private Text bearStats;

    @FXML
    private Text crocStats;

    @FXML
    private Text turtleStats;

    @FXML
    private Text elephantStats;

    @FXML
    private Text bisonStats;

    @FXML
    private Text birdStats;

    @FXML
    private Text rabbitStats;

    @FXML
    private Text cheetahStats;

    @FXML
    private Text pigStats;

    @FXML
    private Text chickenStats2;

    @FXML
    private Text bearStats2;

    @FXML
    private Text crocStats2;

    @FXML
    private Text turtleStats2;

    @FXML
    private Text elephantStats2;

    @FXML
    private Text bisonStats2;

    @FXML
    private Text birdStats2;

    @FXML
    private Text rabbitStats2;

    @FXML
    private Text cheetahStats2;

    @FXML
    private Text pigStats2;

    @FXML
    private Text eliminateText;

    @FXML
    private Button eliminateBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    ArrayList<Character> characterArraylist = new ArrayList<>();

    Player enemy = new Player();
    Player user = new Player();

    int charactersSelected = 0;
    final int MAX_CHARACTERS_SELECT = 5;
    final int MAX_CHARACTERS_ELIMINATE = 3;

    public void initialize() {
        characterArraylist.add(new Character("Chicken", 100, 50, 30, false, chickenImage, chickenEliminateImage));
        characterArraylist.add(new Character("Bear", 130, 40, 40, false, bearImage, bearEliminateImage));
        characterArraylist.add(new Character("Crocodile", 115, 60, 20, false, crocImage, crocEliminateImage));
        characterArraylist.add(new Character("Turtle", 300, 5, 5, false, turtleImage, turtleEliminateImage));
        characterArraylist.add(new Character("Elephant", 220, 35, 15, false, elephantImage, elephantEliminateImage));
        characterArraylist.add(new Character("Bison", 200, 25, 30, false, bisonImage, bisonEliminateImage));
        characterArraylist.add(new Character("Bird", 120, 15, 70, false, birdImage, birdEliminateImage));
        characterArraylist.add(new Character("Rabbit", 80, 5, 100, false, rabbitImage, rabbitEliminateImage));
        characterArraylist.add(new Character("Cheetah", 110, 30, 60, false, cheetahImage, cheetahEliminateImage));
        characterArraylist.add(new Character("Pig", 1, 100, 1, false, pigImage, pigEliminateImage));

        selectBtn.setVisible(false);
        eliminateBtn.setVisible(false);
        eliminateText.setVisible(false);


        for (Character character : characterArraylist) {
            character.getCharacterEliminateImage().setDisable(true);
            character.getCharacterEliminateImage().setVisible(false);
        }

        enemy.selectEnemyCharacters(enemy.getEnemyCharacters(), 5, characterArraylist);
        enemy.selectEnemyCharacters(enemy.getEnemyEliminateCharacters(), 3, characterArraylist);

        chickenStats.setText("Health: " + characterArraylist.get(0).getHealth() + "\nDamage: " + characterArraylist.get(0).getDamage() + "\nSpeed: " + characterArraylist.get(0).getSpeed());
        bearStats.setText("Health: " + characterArraylist.get(1).getHealth() + "\nDamage: " + characterArraylist.get(1).getDamage() + "\nSpeed: " + characterArraylist.get(1).getSpeed());
        crocStats.setText("Health: " + characterArraylist.get(2).getHealth() + "\nDamage: " + characterArraylist.get(2).getDamage() + "\nSpeed: " + characterArraylist.get(2).getSpeed());
        turtleStats.setText("Health: " + characterArraylist.get(3).getHealth() + "\nDamage: " + characterArraylist.get(3).getDamage() + "\nSpeed: " + characterArraylist.get(3).getSpeed());
        elephantStats.setText("Health: " + characterArraylist.get(4).getHealth() + "\nDamage: " + characterArraylist.get(4).getDamage() + "\nSpeed: " + characterArraylist.get(4).getSpeed());
        bisonStats.setText("Health: " + characterArraylist.get(5).getHealth() + "\nDamage: " + characterArraylist.get(5).getDamage() + "\nSpeed: " + characterArraylist.get(5).getSpeed());
        birdStats.setText("Health: " + characterArraylist.get(6).getHealth() + "\nDamage: " + characterArraylist.get(6).getDamage() + "\nSpeed: " + characterArraylist.get(6).getSpeed());
        rabbitStats.setText("Health: " + characterArraylist.get(7).getHealth() + "\nDamage: " + characterArraylist.get(7).getDamage() + "\nSpeed: " + characterArraylist.get(7).getSpeed());
        cheetahStats.setText("Health: " + characterArraylist.get(8).getHealth() + "\nDamage: " + characterArraylist.get(8).getDamage() + "\nSpeed: " + characterArraylist.get(8).getSpeed());
        pigStats.setText("Health: " + characterArraylist.get(9).getHealth() + "\nDamage: " + characterArraylist.get(9).getDamage() + "\nSpeed: " + characterArraylist.get(9).getSpeed());

    }


    @FXML
    void clickChicken(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(0), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(0).getCharacterSelectImage());

    }

    @FXML
    void clickChickenEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(0), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(0).getCharacterEliminateImage());

    }

    @FXML
    void clickBear(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(1), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(1).getCharacterSelectImage());

    }

    @FXML
    void clickBearEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(1), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(1).getCharacterEliminateImage());

    }

    @FXML
    void clickCroc(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(2), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(2).getCharacterSelectImage());

    }

    @FXML
    void clickCrocEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(2), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(2).getCharacterEliminateImage());

    }

    @FXML
    void clickTurtle(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(3), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(3).getCharacterSelectImage());

    }

    @FXML
    void clickTurtleEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(3), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(3).getCharacterEliminateImage());

    }

    @FXML
    void clickElephant(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(4), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(4).getCharacterSelectImage());

    }

    @FXML
    void clickElephantEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(4), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(4).getCharacterEliminateImage());

    }

    @FXML
    void clickBison(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(5), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(5).getCharacterSelectImage());

    }

    @FXML
    void clickBisonEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(5), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(5).getCharacterEliminateImage());

    }

    @FXML
    void clickBird(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(6), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(6).getCharacterSelectImage());

    }

    @FXML
    void clickBirdEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(6), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(6).getCharacterEliminateImage());

    }

    @FXML
    void clickRabbit(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(7), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(7).getCharacterSelectImage());

    }

    @FXML
    void clickRabbitEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(7), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(7).getCharacterEliminateImage());

    }

    @FXML
    void clickCheetah(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(8), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(8).getCharacterSelectImage());

    }

    @FXML
    void clickCheetahEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(8), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(8).getCharacterEliminateImage());

    }

    @FXML
    void clickPig(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(9), charactersSelected, selectBtn, MAX_CHARACTERS_SELECT, characterArraylist.get(9).getCharacterSelectImage());

    }

    @FXML
    void clickPigEliminate(MouseEvent event) {
        charactersSelected = user.selectUserImages(characterArraylist.get(9), charactersSelected, eliminateBtn, MAX_CHARACTERS_ELIMINATE, characterArraylist.get(9).getCharacterEliminateImage());

    }


    @FXML
    void clickSelectBtn(MouseEvent event) {
        for (Character character : characterArraylist) {
            if (character.isPressed()) {
                user.userCharacters.add(new Player(character.getName(), character.getHealth(), character.getDamage(), character.getSpeed(), character.getCharacterSelectImage()));
            }
            character.getCharacterSelectImage().setDisable(true);
            character.setPressed(false);                                                                                                                                                                   // resets usr press on characters

            character.getCharacterEliminateImage().setDisable(false);
            character.getCharacterEliminateImage().setVisible(true);
            eliminateText.setVisible(true);
        }

        selectBtn.setDisable(true);
        charactersSelected = user.setCharactersSelected(charactersSelected);                                                                                                                               // sets charactersSelected to zero

        chickenStats2.setText("Health: " + characterArraylist.get(0).getHealth() + "\nDamage: " + characterArraylist.get(0).getDamage() + "\nSpeed: " + characterArraylist.get(0).getSpeed());
        bearStats2.setText("Health: " + characterArraylist.get(1).getHealth() + "\nDamage: " + characterArraylist.get(1).getDamage() + "\nSpeed: " + characterArraylist.get(1).getSpeed());
        crocStats2.setText("Health: " + characterArraylist.get(2).getHealth() + "\nDamage: " + characterArraylist.get(2).getDamage() + "\nSpeed: " + characterArraylist.get(2).getSpeed());
        turtleStats2.setText("Health: " + characterArraylist.get(3).getHealth() + "\nDamage: " + characterArraylist.get(3).getDamage() + "\nSpeed: " + characterArraylist.get(3).getSpeed());
        elephantStats2.setText("Health: " + characterArraylist.get(4).getHealth() + "\nDamage: " + characterArraylist.get(4).getDamage() + "\nSpeed: " + characterArraylist.get(4).getSpeed());
        bisonStats2.setText("Health: " + characterArraylist.get(5).getHealth() + "\nDamage: " + characterArraylist.get(5).getDamage() + "\nSpeed: " + characterArraylist.get(5).getSpeed());
        birdStats2.setText("Health: " + characterArraylist.get(6).getHealth() + "\nDamage: " + characterArraylist.get(6).getDamage() + "\nSpeed: " + characterArraylist.get(6).getSpeed());
        rabbitStats2.setText("Health: " + characterArraylist.get(7).getHealth() + "\nDamage: " + characterArraylist.get(7).getDamage() + "\nSpeed: " + characterArraylist.get(7).getSpeed());
        cheetahStats2.setText("Health: " + characterArraylist.get(8).getHealth() + "\nDamage: " + characterArraylist.get(8).getDamage() + "\nSpeed: " + characterArraylist.get(8).getSpeed());
        pigStats2.setText("Health: " + characterArraylist.get(9).getHealth() + "\nDamage: " + characterArraylist.get(9).getDamage() + "\nSpeed: " + characterArraylist.get(9).getSpeed());
    }


    @FXML
    void clickEliminateBtn(MouseEvent event) {
        for (Character character : characterArraylist) {
            if (character.isPressed()) {
                user.userEliminateCharacters.add(new Player(character.getName(), character.getHealth(), character.getDamage(), character.getSpeed(), character.getCharacterSelectImage()));
            }
            character.getCharacterEliminateImage().setDisable(true);
        }
        eliminateBtn.setDisable(true);
        user.subtractionCharacters(user.userCharacters, enemy.getEnemyEliminateCharacters());
        enemy.subtractionCharacters(enemy.getEnemyCharacters(), user.userEliminateCharacters);
        switchToBattleScene(event);
    }


    public void switchToBattleScene(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battleScene.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Battle battle = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        battle.addStats(user, enemy);
        battle.battleSimulation(user, enemy);
        battle.setPlayerImages(user, enemy);
    }
}
