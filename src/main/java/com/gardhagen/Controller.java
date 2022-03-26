package com.gardhagen;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    Label dateTime,dateLabel;
    @FXML
    Button logTimeButton;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String todaysDate = LocalDateTime.now().format(dateTimeFormatter);
    static String timeLog;

    public void on_click(ActionEvent event){

        LogTimeButtonClicked();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateLabel.setText(todaysDate);
        initClock();
    }

    private void initClock(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ONE,e ->{
            LocalTime currentTime = LocalTime.now();
            dateTime.setText(currentTime.getHour() + ":" +currentTime.getMinute() +":"+ currentTime.getSecond()+":"+currentTime.getNano() );
            //System.out.println(currentTime.getHour() + ":" +currentTime.getMinute() +":"+ currentTime.getSecond() +":"+currentTime.getNano() );
            timeLog = currentTime.getHour() + ":" +currentTime.getMinute() +":"+ currentTime.getSecond()+":"+currentTime.getNano();
        }),
                new KeyFrame(Duration.millis(0.001))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    private void LogTimeButtonClicked(){
        System.out.println("Im clicked");
        System.out.println(todaysDate +" "+ timeLog);

    }
}