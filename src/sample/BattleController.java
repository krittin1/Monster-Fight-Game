package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URISyntaxException;

public class BattleController {

    private Monster m1, m2;

    private GameController gameController;

    @FXML
    ImageView m1Image, m2Image;


    @FXML
    Label monster1,monste2,round;


    @FXML
    Button heal, attack;

    @FXML
    TextField healing;






    @FXML public void initialize(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    m1Image.setImage(new Image(getClass().getResource(m1.getImgPath()).toURI().toString()));
                    m2Image.setImage(new Image(getClass().getResource(m2.getImgPath()).toURI().toString()));

                    gameController = new GameController(m1, m2);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setMonster1(Monster m){
        this.m1 = m;
    }
    public void setMonster2(Monster m){
        this.m2 = m;
    }

    @FXML public void handleAtkBtnOnAction(ActionEvent event){

        // call atk method in gameController

        // check isWin
        if (gameController.isWin()) {
            if(gameController.getWinMonster().getName().equals(m1.getName())){
                monster1.setText("Congratulation " + gameController.getWinMonster().toString());

                m1Image.setVisible(true);
                m2Image.setVisible(false);
                monste2.setVisible(false);
//                display();
            }
            else{
                monste2.setText("Congratulation " + gameController.getWinMonster().toString());

                m1Image.setVisible(false);
                m2Image.setVisible(true);
                monster1.setVisible(false);
//                display();
            }
            attack.setVisible(false);
            heal.setVisible(false);


        }

        // display
        else{
            gameController.attackState();
            setMonster1(gameController.getM1());
            setMonster2(gameController.getM2());
            display();
        }

    }

//    @FXML public void handleHealBtnOnAction(ActionEvent event){
//        gameController.healState(Integer.parseInt(healing.getText()),Integer.parseInt(old.getText()));
//        setMonster1(gameController.getM1());
//        setMonster2(gameController.getM2());
//        display();
//
//    }


    @FXML public void handleHealBtnOnAction(ActionEvent event){
        gameController.healState(Integer.parseInt(healing.getText()));
        setMonster1(gameController.getM1());
        setMonster2(gameController.getM2());

        display();

    }

    public void display(){
        // call display next turn monster attribute
        round.setText(gameController.getRound()+ "");
        if(m1.getHeal() ){


            monster1.setText(m1.toString());
            monste2.setText(m2.toString());
            m1Image.setVisible(true);
            m2Image.setVisible(false);
            gameController.setM2();
            m1.setHeal();
           setMonster1(gameController.getM1());

           setMonster2(gameController.getM2());
        }
        else if (m2.getHeal() ){
            monster1.setText(m1.toString());
            monste2.setText(m2.toString());
            m1Image.setVisible(true);
            m2Image.setVisible(false);
            m2.setHeal();
            setMonster1(gameController.getM1());
            setMonster2(gameController.getM2());
        }
        else{
            if (gameController.getTurn() == 1){
                monster1.setText(m1.toString());
                m1Image.setVisible(true);
                m2Image.setVisible(false);
            }
            else{
                monste2.setText(m2.toString());
                m1Image.setVisible(false);
                m2Image.setVisible(true);
            }
        }



        // call display next turn monster image


    }




}
