package UserInterfaceLayer;

import BusinessLogicLayer.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import persistenceLayer.PatientDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ForGuestSerachRecordByAge implements Initializable
{

    @FXML
    private TextField age;

    @FXML
    private javafx.scene.control.Button searchButton;

    @FXML
    private javafx.scene.control.Button cancelButton;

    @FXML
    private void SearchPatientByAge(javafx.event.ActionEvent event)
    {
        if(age.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Enter Age frist");
        }
        else {
            ArrayList<Patient> list = new ArrayList<>();
            PatientDatabase patientDatabase = new PatientDatabase();
            list = patientDatabase.searchPatientByAge(Integer.parseInt(age.getText()));
            for (int i = 0; i < list.size(); i++) {
                JOptionPane.showMessageDialog(null,"Name : "+list.get(i).getName()
                        +"\nFather name : "+list.get(i).getFatherName() +"\nDate of birth : "+list.get(i).getDateOfBirth()
                        +"\nGender : "+list.get(i).getGender()+"\nDoctor Name : "+list.get(i).getDoctor().getName()
                        +"\nDisease history : "+list.get(i).getDiseaseHistory()+"\nDiscription : "+list.get(i).getPrescription());
            }
        }
    }

    @FXML
    private void cancelSearch(javafx.event.ActionEvent event)
    {
        age.setText("");
    }
//
//    void cancelSearch(ActionEvent event)
//    {
//
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    }
}
