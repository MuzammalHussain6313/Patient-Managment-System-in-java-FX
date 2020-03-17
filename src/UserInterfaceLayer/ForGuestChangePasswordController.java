/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicLayer.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import persistenceLayer.UserAuthentication;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class ForGuestChangePasswordController implements Initializable
{

    @FXML
    private TextField name;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;

    @FXML
    private void changePassword(ActionEvent event)
    {
        UserAuthentication u = new UserAuthentication();
        User user = new User();
        user.setUserName(name.getText());
        user.setPassword(password.getText());
        u.changePassword(user);
        JOptionPane.showMessageDialog(null,"Password changed.");
        name.setPromptText("");
        password.setPromptText("");
        confirmPassword.setPromptText("");
    }

    @FXML
    private void cancelChange(ActionEvent event)
    {
        name.setPromptText("");
        password.setPromptText("");
        confirmPassword.setPromptText("");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
	// TODO
    }

}
