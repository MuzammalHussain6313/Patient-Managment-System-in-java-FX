/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicLayer.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import persistenceLayer.UserAuthentication;

public class ChangePasswordController implements Initializable
{
    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField newPassword;
    @FXML
    private Button changePassword;
    @FXML
    private Button cancel;
    @FXML
    private Label errorLable;
    @FXML
    private ComboBox<String> userType;
    @FXML
    private void ChangePassword(ActionEvent event)
    {
        User user = new User();
        user.setUserName(userName.getText());
        user.setPassword(password.getText());
        user.setType(userType.getValue());
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.changePassword(user);
    }
    @FXML
    private void cancel(ActionEvent event)
    {
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
