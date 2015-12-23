package GUI;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class EventController {
	
	ObservableList<String> environmentList = FXCollections
			.observableArrayList("QAE", "Stage", "Production");
	ObservableList<String> devicesList = FXCollections
			.observableArrayList("iPhone 4", "iPhone 5", "iPhone 6", "iPhone 6+", "Samsung Galaxy S4");

	@FXML
	private ComboBox environmentCB;	
	@FXML
	private ComboBox deviceCB;
	
	@FXML
	private Button startRunBttn;
	
	@FXML
	private CheckBox fullRegressionChkBox;	
	@FXML
	private CheckBox smokeTestChkBox;	
	@FXML
	private CheckBox odsChkBox;	
	@FXML
	private CheckBox rioChkBox;	
	@FXML
	private CheckBox accountChkBox;	
	@FXML
	private CheckBox checkoutChkBox;
	
	@FXML
	private void startTest(){
		try {
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("../testng.xml");//path to xml..
			testng.setTestSuites(suites);
			testng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void initialize() {
		environmentCB.setValue(environmentList.get(1));
		environmentCB.setItems(environmentList);
		
		deviceCB.setValue(devicesList.get(1));
		deviceCB.setItems(devicesList);
	}
	
	
}
