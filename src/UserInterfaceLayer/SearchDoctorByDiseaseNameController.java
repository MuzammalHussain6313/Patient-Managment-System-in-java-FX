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
import javafx.scene.control.Label;
import persistenceLayer.DiseaseDatabase;
import persistenceLayer.DoctorDatabase;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Muzammal Hussain
 */
public class SearchDoctorByDiseaseNameController implements Initializable
{

    @FXML
    private Button search;

    @FXML
    private Button cancel;

    @FXML
    private ComboBox<String> selectDisease;

    @FXML
    private Label errorLable;

    @FXML
    void cancelSearch(ActionEvent event) {

    }

    @FXML
    void searchDoctorByDisease(ActionEvent event) {
        ArrayList<Doctor> list = new ArrayList<>();
        DoctorDatabase doctorDatabase = new DoctorDatabase();
        String n = selectDisease.getValue();
        list = doctorDatabase.searchDoctorBySpacialization(n);
        for(int i =0;i<list.size();i++)
        {
            JOptionPane.showMessageDialog(null,"Name : "+list.get(i).getName()
                    +"\nSpacialization : "+ list.get(i).getSpacialization().getName());
        }
    }
    public String selectDiseaseName()
    {
        return selectDisease.getValue();
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
	// TODO
    }

}
