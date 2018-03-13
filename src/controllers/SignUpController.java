package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class pageAccueil_Controller {


    @FXML
    private ImageView exit;

    @FXML
    private JFXButton connexion;

    @FXML
    void exit() {
        Platform.exit();

    }

    @FXML
    void connexion() {


    }

}
