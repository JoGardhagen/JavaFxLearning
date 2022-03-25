package com.gardhagen;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class Controller implements Initializable {
   @FXML
   Label dateTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       initClock();
    }

    private void initClock(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ONE,e ->{
            LocalTime currentTime = LocalTime.now();
            dateTime.setText(currentTime.getHour() + ":" +currentTime.getMinute() +":"+ currentTime.getSecond() );
            System.out.println(currentTime.getHour() + ":" +currentTime.getMinute() +":"+ currentTime.getSecond() );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}