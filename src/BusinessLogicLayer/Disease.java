package BusinessLogicLayer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Disease
{
    private int Id;
    private String Name;
    private String discription;
    //https://stackoverflow.com/questions/13381067/simplestringproperty-and-simpleintegerproperty-tableview-javafx
//    private SimpleIntegerProperty studentId;
//    private SimpleStringProperty firstName;
//    private SimpleStringProperty lastName;
    public Disease(){

    }
    public Disease(String name, String discription)
    {
        this.Name = name;
        this.discription = discription;
    }
    public Disease(int id,String name, String discription)
    {
        this.Id = id;
        this.Name = name;
        this.discription = discription;
    }

    public String getDiscription()
    {
        return discription;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }
}
