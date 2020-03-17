package BusinessLogicLayer;

public class Doctor
{
    private int id;
    private String Name;
    public Disease specialization = new Disease();
    private String DiseaseName;
    public Doctor()
    {

    }
    public Doctor(int id, String name,String disease)
    {
        this.id = id;
        this.Name = name;
        DiseaseName = disease;
    }
    public Doctor(int id, String name,Disease disease)
    {
        this.id = id;
        this.Name = name;
        this.specialization = disease;
    }
    public Doctor(String name,Disease disease)
    {
        this.Name = name;
        this.specialization = disease;
    }

    public void setid(int id )
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setName(String name)
    {
        this.Name = name;
    }
    public void setSpecialization(Disease disease)
    {
        this.specialization = disease;
    }
    public String getName()
    {
        return Name;
    }
    public Disease getSpacialization()
    {
        return this.specialization;
    }
    public String getDiseaseName()
    {
        return specialization.getName();
    }

    public Disease getSpecialization() {
        return specialization;
    }

    public void getInfo(int id)
    {

    }
}
