package UserInterfaceLayer;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EntryPoint extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
	try
	{
	    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	} catch (Exception e)
	{
	    System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    System.out.println("Exception occured.");
	}
    }

    public static void main(String[] args)
    {
	launch(args);
    }

}
