/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicLayer.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import persistenceLayer.DiseaseDatabase;
import persistenceLayer.DoctorDatabase;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class SearchDoctorByNameController implements Initializable
{
    @FXML
    private TextField doctorName;
    @FXML
    private Button searchDoctor;

    @FXML
    private Button cancel;

    @FXML
    void cancelDoctorSearch(ActionEvent event) {

    }

    @FXML
    void searchDoctor(ActionEvent event) {
        ArrayList<Doctor> list = new ArrayList<>();
        DoctorDatabase doctorDatabase = new DoctorDatabase();
        list = doctorDatabase.searchDoctorByNAME(doctorName.getText());
        for(int i =0;i<list.size();i++)
        {
            JOptionPane.showMessageDialog(null,"Name : "+list.get(i).getName()
                    +"\nSpacialization : "+ list.get(i).getSpacialization().getName());
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
