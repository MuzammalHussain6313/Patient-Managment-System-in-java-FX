package UserInterfaceLayer;

import BusinessLogicLayer.Doctor;
import BusinessLogicLayer.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import persistenceLayer.DoctorDatabase;
import persistenceLayer.PatientDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ForGuestSerachRecordByName implements Initializable
{

    @FXML
    private TextField name;

    @FXML
    private javafx.scene.control.Button searchButton;

    @FXML
    private javafx.scene.control.Button cancelButton;

    @FXML
    private ComboBox<String> searcType;

    @FXML
    private void SearchPatientByAge(javafx.event.ActionEvent event)
    {
        if (searcType.getValue().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Select Patient OR doctor First");
        }
        else if(searcType.getValue().equals("Doctor"))
        {
            DoctorDatabase doctorDatabase = new DoctorDatabase();
            ArrayList<Doctor> doctor = doctorDatabase.searchDoctorByNAME(name.getText());
            for(int i=0;i<doctor.size();i++){
            JOptionPane.showMessageDialog(null,"Name : "+doctor.get(i).getName()
                    +"\nSpacialization : "+ doctor.get(i).getSpacialization().getName());}
        }
        else if(searcType.getValue().equals("Patient"))
        {
            PatientDatabase patientDatabase = new PatientDatabase();
            ArrayList<Patient> patient = patientDatabase.searchPatientByNAME(name.getText());
            for(int i=0;i<patient.size();i++) {
                JOptionPane.showMessageDialog(null, "Name : " + patient.get(i).getName()
                        + "\nFather name : " + patient.get(i).getFatherName() + "\nDate of birth : " + patient.get(i).getDateOfBirth()
                        + "\nGender : " + patient.get(i).getGender() + "\nDoctor Name : " + patient.get(i).getDoctor().getName()
                        + "\nDisease history : " + patient.get(i).getDiseaseHistory() + "\nDiscription : " + patient.get(i).getPrescription());
            }
        }
    }

    @FXML
    private void cancelSearch(javafx.event.ActionEvent event)
    {
        name.setText("");
    }
//
//    void SearchPatientByAge(ActionEvent event)
//    {
//
//    }
//
//    void cancelSearch(ActionEvent event)
//    {
//
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
	ObservableList<String> dbTypeList = FXCollections.observableArrayList("Doctor", "Patient");
	searcType.setItems(dbTypeList);
    }
}
