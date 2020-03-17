/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicLayer.Disease;
import BusinessLogicLayer.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistenceLayer.DiseaseDatabase;
import persistenceLayer.DoctorDatabase;

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class AddNewDoctorController implements Initializable
{
    @FXML
    private TextField doctorName;
    @FXML
    private Button addNewDoctor;
    @FXML
    private Button cancel;
    @FXML
    private ComboBox<String> selectDisease;
    @FXML
    private Label errorLable;

    @FXML
    private void addNewDoctor(ActionEvent event)
    {
        Disease disease = new Disease();
        disease.setName(setSelectDisease());
        Doctor doctor = new Doctor(doctorName.getText(),disease);
        DoctorDatabase doctorDatabase = new DoctorDatabase();
        doctorDatabase.insertDoctor(doctor);
        doctorName.setText("");
        errorLable.setText("A doctor record Successfully added to daatbase");
    }

    @FXML
    private void cancelDoctorInsertion(ActionEvent event)
    {
        doctorName.setText("");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
        ObservableList<String> dbTypeList = FXCollections.observableArrayList(diseaseDatabase.diseaseList());
        selectDisease.setItems(dbTypeList);
    }
    public String setSelectDisease()
    {
        return selectDisease.getValue();
    }
}
