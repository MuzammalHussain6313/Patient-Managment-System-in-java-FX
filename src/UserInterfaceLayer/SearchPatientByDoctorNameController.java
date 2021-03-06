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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistenceLayer.PatientDatabase;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class SearchPatientByDoctorNameController implements Initializable
{

    @FXML
    private TextField doctorName;

    @FXML
    private Button searchPatientByDoctorName;

    @FXML
    private Button cencelPatientSearch;

    @FXML
    private Label errorLable;

    @FXML
    void cencelPatientSearch(ActionEvent event) {

    }

    @FXML
    void searchPatientByDoctorName(ActionEvent event) {
        ArrayList<Patient> list = new ArrayList<>();
        PatientDatabase patientDatabase = new PatientDatabase();
        list = patientDatabase.searchPatientByDoctor(doctorName.getText());
        for(int i =0;i<list.size();i++)
        {
            JOptionPane.showMessageDialog(null,"Name : "+list.get(i).getName()
                    +"\nFather name : "+list.get(i).getFatherName() +"\nDate of birth : "+list.get(i).getDateOfBirth()
                    +"\nGender : "+list.get(i).getGender()+"\nDoctor Name : "+list.get(i).getDoctor().getName()
                    +"\nDisease history : "+list.get(i).getDiseaseHistory()+"\nDiscription : "+list.get(i).getPrescription());
        }
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
