package dataDriven;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.JsonReader;
import pageObjects.ReadCSVFile;

public class TestJsonResponseWithCSVData {
	
	@Test
	public void testJsonResponseWithCSVData(){
		JsonReader jsonReader= new JsonReader();
		ReadCSVFile readCsvFile= new ReadCSVFile();
		readCsvFile.getFileData();
		SoftAssert softAssert= new SoftAssert();
		
		System.out.println("Test brginss..");
		softAssert.assertTrue(verifyTimeStamps(readCsvFile.getTimeInMilliSeconds(readCsvFile.getUtcDates()),jsonReader.getMilliSeconds()), "Time is not matching");
		softAssert.assertTrue(verifyName(readCsvFile.getNames(),jsonReader.getName()),"Name is not matching");
		softAssert.assertTrue(verifyValues(readCsvFile.getValue(),jsonReader.getValues()), "Values are not matching");
		softAssert.assertTrue(verifyStatus(readCsvFile.getStatus(),jsonReader.getStatus()),"Status are not matching");
		softAssert.assertAll();
		Assert.assertTrue(1==1);
	}
	
	public boolean verifyTimeStamps(List<Long> timeFromCSV,List<Long> timeFromJson){
		if(timeFromCSV.equals(timeFromJson)){
			return true;
		}
		return false;
	}
	
	public boolean verifyName(List<String> namesFromCSV,String nameFromJson){
		for(String name:namesFromCSV){
			if(!name.equals(nameFromJson)){
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyValues(List<Long> valuesFromCSV,List<Long> valuesFromJson){
		if(valuesFromCSV.equals(valuesFromJson)){
			return true;
		}
		return false;
	}
	
	
	public boolean verifyStatus(List<Long> statusFromCSV,List<Long> statusFromJson){
		List<Long> newStatus= new ArrayList<Long>();
		for(Long l:statusFromCSV){
			newStatus.add(l+3);
		}
		if(newStatus.equals(statusFromJson)){
			return true;
		}
		return false;
	}
}
