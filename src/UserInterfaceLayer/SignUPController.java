/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class SignUPController implements Initializable
{

    @FXML
    private Label Name;
    @FXML
    private Label errorLable;
    @FXML
    private ComboBox<String> userType;
    @FXML
    private Button SignUP;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confarmPassword;
    @FXML
    private Button goBack;
    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private void selectType(ActionEvent event)
    {
    }

    @FXML
    private void createNewUser(ActionEvent event)
    {
        User newUser = new User();
        newUser.setUserName(user.getText());
        newUser.setPassword(password.getText());
        newUser.setType(userType.getValue());
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.signUp(newUser);
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
