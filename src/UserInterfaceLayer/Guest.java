package UserInterfaceLayer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Guest
{

    @FXML
    private MenuItem searchByID;

    @FXML
    private MenuItem searchByName;

    @FXML
    private MenuItem searchByAge;

    @FXML
    private Menu print;

    @FXML
    private MenuItem aboutUS;

    @FXML
    private MenuItem changePassword;

    @FXML
    private Button searchRecordButton;

    @FXML
    private Button printButton;

    @FXML
    private AnchorPane smallAnchorPane;

    @FXML
    private void searchByIdAction(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ForGuestSerachRecordByID.fxml"));
        smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchByNameAction(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ForGuestSerachRecordByName.fxml"));
        smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchByAgeAction(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ForGuestSerachRecordByAge.fxml"));
        smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void printButtonAction(javafx.event.ActionEvent event)
    {
        JOptionPane.showMessageDialog(null,"Printer Not Connected to your PC.\nPlease ! coneect a printer first.");
    }

    @FXML
    private void aboutUsAction(javafx.event.ActionEvent event)
    {
        JOptionPane.showMessageDialog(null,"Hospital not yet provide about there.");
    }

    @FXML
    private void changePasswordAction(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("forGuestChangePassword.fxml"));
        smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchRecordButtonAction(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ForGuestSearchRecord.fxml"));
        smallAnchorPane.getChildren().setAll(pane);
    }

}
