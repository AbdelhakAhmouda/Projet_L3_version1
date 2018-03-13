package controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xpath.internal.SourceTree;
import functions.DBInfo;
import functions.mouseDrag;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.LoginModel;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.util.Optional;


public class LoginController {


    @FXML
    private ImageView buttomExit;

    @FXML
    public JFXButton inscrire;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;


    @FXML
    private JFXButton connexion;


    public Image applicationIcon = new Image(getClass().getResourceAsStream("/images/thinking.png"));





    public void showAlert(Alert.AlertType type, String title, String header, String text){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public void exitClicked(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit the app?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        }
    }

    public void minimizeClicked(MouseEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }



        @FXML
        void connexion(ActionEvent event) throws IOException {


            TrayNotification tray = new TrayNotification();

            String username_text = username.getText();
            String password_text = password.getText();
            if (username_text.equals("") || password_text.equals("")) {
                showAlert(Alert.AlertType.WARNING, "Warning", null, "Please enter username and password first !!");
                username.requestFocus();
            } else {
                LoginModel log = new LoginModel();
                log.setLogin(username_text, password_text);
                if (log.getLogin() == true) {
//                    if (log.getStatus().equals("Login")) {
//                        showAlert(Alert.AlertType.ERROR, "Error", null, "The username is currently logged in !!");
//                        username.requestFocus();
//                    } else {
//                        tray.setNotificationType(NotificationType.CUSTOM);
                    tray.setTitle("Login Success");
                    tray.setMessage("Hello " + log.getName() + ". Welcome to my apps @dzf");
                    tray.setAnimationType(AnimationType.FADE);
                    tray.showAndDismiss(Duration.millis(1500));
                    tray.setRectangleFill(Color.valueOf("#4183D7"));
                    tray.setImage(new Image("/images/icons8_Male_User_100px_2.png"));
//                        if(!log.getLevel().equals("Admin")){
//                            log.setStatus(log.getId());
//                        }

                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", null, "\n" +
                            "The username and password you entered are wrong !!");
                    username.setText("");
                    password.setText("");
                    username.requestFocus();
                }
            }



//            String username_text = username.getText();
//            String password_text = password.getText();
//
//            if(username_text.equals("admin")&&password_text.equals("admin")){
//
//                Parent inscrire_parent = FXMLLoader.load(getClass().getResource("/fxml/pageAccueil.fxml"));
//                Scene inscrire_scene = new Scene(inscrire_parent);
//                Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//                app_stage.hide();
//                app_stage.setScene(inscrire_scene);
//
//                mouseDrag md = new mouseDrag();
//                md.setDragged(inscrire_parent, app_stage);
//                app_stage.getIcons().add(applicationIcon);
//                app_stage.show();
//
//
//            }else{
//
//                Alert alert = new Alert(Alert.AlertType.ERROR, "you have missing fields or false inputs! try again.", ButtonType.OK);
//                alert.setHeaderText(null);
//                alert.show();
//
//
//            }
//
//
//    }

        }




    @FXML
    void exit(MouseEvent event) {
        exitClicked();
    }

    @FXML
    void minimize(MouseEvent event) {
        minimizeClicked(event);
    }




    @FXML
    private void setDefault(javafx.scene.input.MouseEvent event){
        buttomExit.setStyle("-fx-background-color:  #4183D7;");
    }

    @FXML
    private void setHover(javafx.scene.input.MouseEvent event){
        buttomExit.setStyle("-fx-background-color: red;");
    }







    @FXML
    void signup(ActionEvent event) {
            try {
                Parent inscrire_parent = FXMLLoader.load(getClass().getResource("/fxml/SignUp.fxml"));
                Scene inscrire_scene = new Scene(inscrire_parent);
                Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(inscrire_scene);
                app_stage.setTitle("inscrire");
                mouseDrag md = new mouseDrag();
                md.setDragged(inscrire_parent, app_stage);
                app_stage.getIcons().add(applicationIcon);
                app_stage.show();

            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Error", null, String.valueOf(e));

            }


    }





}
