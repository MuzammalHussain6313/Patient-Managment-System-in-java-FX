package UserInterfaceLayer;

import BusinessLogicLayer.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistenceLayer.PatientDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SearchPatientRecordController {

    @FXML
    private TextField name;

    @FXML
    private TextField fathername;

    @FXML
    private Button searchPatientRecord;

    @FXML
    private Button cancel;

    @FXML
    private Label errorLable;

    public void searchPatientRecord(javafx.event.ActionEvent actionEvent) {
        ArrayList<Patient> list = new ArrayList<>();
        PatientDatabase patientDatabase = new PatientDatabase();
        Patient patient = new Patient();
        patient.setName(name.getText());
        patient.setFatherName(fathername.getText());
        list = patientDatabase.searchPatientRecord(patient);
        for (int i = 0; i < list.size(); i++) {
            JOptionPane.showMessageDialog(null,"Name : "+list.get(i).getName()
                    +"\nFather name : "+list.get(i).getFatherName() +"\nDate of birth : "+list.get(i).getDateOfBirth()
                    +"\nGender : "+list.get(i).getGender()+"\nDoctor Name : "+list.get(i).getDoctor().getName()
                    +"\nDisease history : "+list.get(i).getDiseaseHistory()+"\nDiscription : "+list.get(i).getPrescription());
        }

    }
    public void cencelSearch (javafx.event.ActionEvent actionEvent){
    }
}