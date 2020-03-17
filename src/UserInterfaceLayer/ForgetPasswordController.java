package UserInterfaceLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicLayer.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import persistenceLayer.UserAuthentication;

public class ForgetPasswordController implements Initializable
{
    @FXML
    private Label errorLable;
    @FXML
    private ComboBox<String> userType;
    @FXML
    private TextField user;
    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField confarmPassword;
    @FXML
    private Button goBack;
    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Button forgetPasswordButton;
    @FXML
    void forgetPassword(ActionEvent event) {
        User oldUser = new User();
        oldUser.setUserName(user.getText());
        oldUser.setPassword(newPassword.getText());
        oldUser.setType(userType.getValue());
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.forgetpassword(oldUser);
    }
    @FXML
    private void goBack(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
	mainAnchorPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<String> dbTypeList = FXCollections.observableArrayList("Admin","Guest");
        userType.setItems(dbTypeList);
	// TODO
    }

}
