/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicLayer.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import persistenceLayer.PatientDatabase;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class ForGuestSearchRecordController implements Initializable
{

    @FXML
    private TextField name;
    @FXML
    private Button searchButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField fatherName;

    @FXML
    private void SearchPatientByAge(ActionEvent event)
    {
        ArrayList<Patient> list = new ArrayList<>();
        PatientDatabase patientDatabase = new PatientDatabase();
        Patient patient = new Patient();
        patient.setName(name.getText());
        patient.setFatherName(fatherName.getText());
        list = patientDatabase.searchPatientRecord(patient);
        name.setPromptText("");
        fatherName.setPromptText("");
        for (int i = 0; i < list.size(); i++) {
            JOptionPane.showMessageDialog(null,"Name : "+list.get(i).getName()
                    +"\nFather name : "+list.get(i).getFatherName() +"\nDate of birth : "+list.get(i).getDateOfBirth()
                    +"\nGender : "+list.get(i).getGender()+"\nDoctor Name : "+list.get(i).getDoctor().getName()
                    +"\nDisease history : "+list.get(i).getDiseaseHistory()+"\nDiscription : "+list.get(i).getPrescription());

        }
    }

    @FXML
    private void cancelSearch(ActionEvent event)
    {
        name.setPromptText("");
        fatherName.setPromptText("");
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
