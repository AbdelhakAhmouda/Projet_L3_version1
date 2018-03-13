package functions;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Navigation {


    public Image applicationIcon = new Image(getClass().getResourceAsStream("/images/thinking.png"));

    public void showAlert(Alert.AlertType type, String title, String header, String text){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

}
