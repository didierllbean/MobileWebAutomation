package GUI;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

import Tools.ExtentReporterNG;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
	private Label warningLabel;	
	
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
		warningLabel.setPrefSize(150, 50);
		try {
			TestNG tng = new TestNG();
			generateVirtualTestNGXML(tng);
			if(getSelectedGroups().isEmpty())
				warningLabel.setText("Warning: You need to select \\n at least one Suite group");
			else
				tng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void generateVirtualTestNGXML(TestNG tng) throws Exception {
		XmlSuite suite = new XmlSuite();
		suite.setName("MobileAutomationSuite");
		suite.setParallel(ParallelMode.CLASSES);
		suite.setThreadCount(4);
		suite.addListener("Tools.ExtentReporterNG");
		
		XmlTest test = new XmlTest(suite);
		test.setName("DynamicTest");				
		test.setPackages(getPackages());
		test.setIncludedGroups(getSelectedGroups());		
		test.setExcludedGroups(getExcludedGroups());
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);	

		tng.setXmlSuites(suites);
	}

	private List<XmlPackage> getPackages() {
		List<XmlPackage> packages = new ArrayList <XmlPackage>();
		packages.add(new XmlPackage("Test"));
		return packages;
	}

	private List<String> getExcludedGroups() {
		List <String> excludedGroups = new ArrayList <String> ();
		excludedGroups.add("brokenOrDevelopment");
		
		return excludedGroups;
	}

	private List<String> getSelectedGroups() {
		List <String> selectedGroups = new ArrayList <String> ();
		
		if(fullRegressionChkBox.isSelected())
		{
			selectedGroups.add("smokeTest");
			selectedGroups.add("ODS");
			selectedGroups.add("RIO");
			selectedGroups.add("accounts");
			selectedGroups.add("checkout");
		}
		else
		{
			if(smokeTestChkBox.isSelected())
				selectedGroups.add("smokeTest");
			
			if(odsChkBox.isSelected())
				selectedGroups.add("ODS");
			
			if(rioChkBox.isSelected())
				selectedGroups.add("RIO");
			
			if(accountChkBox.isSelected())
				selectedGroups.add("accounts");
			
			if(checkoutChkBox.isSelected())
				selectedGroups.add("checkout");
		}
		
		return selectedGroups;
	}

	@FXML
	private void initialize() {
		environmentCB.setValue(environmentList.get(1));
		environmentCB.setItems(environmentList);
		
		deviceCB.setValue(devicesList.get(1));
		deviceCB.setItems(devicesList);
	}	
}