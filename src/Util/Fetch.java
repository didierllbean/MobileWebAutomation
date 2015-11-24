package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Fetch {
	
	public Dictionary readfromExcel() 
	{
		try
		{
			
		String sDataFile=	System.getProperty("user.dir") + "Data/Automationdata.xls";
		//test file is located in your project path         
	    FileInputStream fileIn = new FileInputStream(sDataFile);
	    //read file 
	    POIFSFileSystem fs = new POIFSFileSystem(fileIn); 
	    HSSFWorkbook filename = new HSSFWorkbook(fs);
	    //open sheet 0 which is first sheet of your worksheet
	    HSSFSheet sheet = filename.getSheetAt(0);
	    
	    
	 // create a new hashtable
	    Dictionary dict = new Hashtable();
	 	  
	    // add elements in the hashtable
	    int icount;
	    for (icount=0 ; icount<3;icount++)
	    {
	    dict.put(sheet.getRow(0).getCell(icount).getStringCellValue(), sheet.getRow(1).getCell(icount).getStringCellValue());
	    
	    // System.out.println(dict.get("id"));
	    }
	    return dict;
		}
		catch(Exception e)
		{
			return null;
		
		}
		
		
		
	}
	
	

}