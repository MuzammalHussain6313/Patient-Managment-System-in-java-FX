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
import java.util.ResourceBundle;

public class ForGuestSerachRecordByID implements Initializable
{
    @FXML
    private TextField ID;

    @FXML
    private javafx.scene.control.Button searchButton;

    @FXML
    private javafx.scene.control.Button cancelButton;

    @FXML
    private ComboBox<String> searcType;

    @FXML
    private void SearchPatientByAge(javafx.event.ActionEvent event)
    {
        if(searcType.getValue().equals("Doctor"))
        {
            DoctorDatabase doctorDatabase = new DoctorDatabase();
            Doctor doctor = doctorDatabase.getDoctorInfo(Integer.parseInt(ID.getText()));
            JOptionPane.showMessageDialog(null,"Name : "+doctor.getName()
            +"\nSpacialization : "+ doctor.getSpacialization().getName());
        }
        else if(searcType.getValue().equals("Patient"))
        {
            PatientDatabase patientDatabase = new PatientDatabase();
            Patient patient = patientDatabase.getPatientInfo(Integer.parseInt(ID.getText()));
            JOptionPane.showMessageDialog(null,"Name : "+patient.getName()
            +"\nFather name : "+patient.getFatherName() +"\nDate of birth : "+patient.getDateOfBirth()
            +"\nGender : "+patient.getGender()+"\nDoctor Name : "+patient.getDoctor().getName()
            +"\nDisease history : "+patient.getDiseaseHistory()+"\nDiscription : "+patient.getPrescription());
        }
    }

    @FXML
    private void cancelSearch(javafx.event.ActionEvent event)
    {
        ID.setText("");
    }

    void SearchPatientByAge(ActionEvent event)
    {

    }

    void cancelSearch(ActionEvent event)
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
	ObservableList<String> dbTypeList = FXCollections.observableArrayList("Doctor", "Patient");
	searcType.setItems(dbTypeList);
    }
}
