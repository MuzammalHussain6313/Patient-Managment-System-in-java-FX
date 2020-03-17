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
public class SearchPatientByAgeController implements Initializable
{

    @FXML
    private TextField age;

    @FXML
    private Button searchPatientByAge;

    @FXML
    private Button cancel;

    @FXML
    private Label errorLable;

    @FXML
    void cancelSearch(ActionEvent event) {
        age.setText("");
    }

    @FXML
    void searchPatientByAge(ActionEvent event) {
        try {
            ArrayList<Patient> list = new ArrayList<>();
            PatientDatabase patientDatabase = new PatientDatabase();
            list = patientDatabase.searchPatientByAge(Integer.parseInt(age.getText()));
            age.setText("");
            for (int i = 0; i < list.size(); i++) {
                JOptionPane.showMessageDialog(null, "Name : " + list.get(i).getName()
                        + "\nFather name : " + list.get(i).getFatherName() + "\nDate of birth : " + list.get(i).getDateOfBirth()
                        + "\nGender : " + list.get(i).getGender() + "\nDoctor Name : " + list.get(i).getDoctor().getName()
                        + "\nDisease history : " + list.get(i).getDiseaseHistory() + "\nDiscription : " + list.get(i).getPrescription());
            }
            //patientDatabase.searchPatientByAge(Integer.parseInt(AGE.getText()));
        }catch (NumberFormatException xe)
        {
            errorLable.setText("Please Enter A number only");
            JOptionPane.showMessageDialog(null,"Please Enter A number only");
        }
//        ArrayList<Patient> list = new ArrayList<>();
//        PatientDatabase patientDatabase = new PatientDatabase();
//
//        list = patientDatabase.searchPatientByAge(Integer.parseInt(age.getText()));
//        for(int i =0;i<list.size();i++)
//        {
//            System.out.println(list.get(i).getName());
//            System.out.println(list.get(i).getFatherName());
//            System.out.println(list.get(i).getGender());
//            System.out.println(list.get(i).getDateOfBirth());
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            System.out.println(df.format(list.get(i).getDateOfBirth()));
//            System.out.println(list.get(i).getDoctor().getName());
//            System.out.println(list.get(i).getDiseaseHistory());
//            System.out.println(list.get(i).getPrescription());
//        }
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
