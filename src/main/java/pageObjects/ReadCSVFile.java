package pageObjects;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;


public class ReadCSVFile {
	private String filepath;
	private File file;
	private List<String> names= new ArrayList<String>();
	private List<String> utcDates=new ArrayList<String>();
	private List<Long> value= new ArrayList<Long>();
	private List<Long> status= new ArrayList<Long>();
	private int rowCount;
	
	public ReadCSVFile(){
		filepath=System.getProperty("user.dir")+"/src/main/resources/GoM-Atlantis-2011-ATM_LI162221.PV_2011-Dec.csv";
		file= new File(filepath);
		setRowCount(0);
	}
	
	public void getFileData(){
		try{
			@SuppressWarnings("resource")
			Scanner scanner= new Scanner(file);
			scanner.nextLine();// Ignoring the first line
			while(scanner.hasNext()){
				String line=scanner.nextLine();
				String[] values=line.split("¿");
				getNames().add(values[0]);
				getUtcDates().add(values[1]);
				getValue().add(Long.valueOf(values[3]));
				getStatus().add(Long.valueOf(values[4]));
				setRowCount(getRowCount() + 1);
			}
		}catch(Exception e){
			
		}
	}
	
	public static void main(String[] args) {
		
		ReadCSVFile onnj = new ReadCSVFile();
		onnj.getFileData();
	/*	System.out.println(onnj.getNames());
		
		System.out.println(onnj.getValue());
		System.out.println(onnj.getStatus());
		System.out.println(onnj.getRowCount());*/
		
		System.out.println(onnj.getUtcDates());
		
		System.out.println(onnj.getTimeInMilliSeconds(onnj.getUtcDates()));
	}

	public List<String> getNames() {
		return names;
	}


	public List<String> getUtcDates() {
		return utcDates;
	}

	public List<Long> getValue() {
		return value;
	}

	public List<Long> getStatus() {
		return status;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public static long getMilliSeconds(String sDate){
		SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date date=null;
		try {
			date = format.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long millis = date.getTime();
		return millis;
	}
	
	public  List<Long> getTimeInMilliSeconds(List<String> date){
		List<Long> milliSecs= new ArrayList<Long>();
		for(String milliSeconds: date){
		String[] arr=milliSeconds.split("\\.");
		String time= arr[0];
	//	System.out.println(time);
		String microSeconds=arr[1];
	//	System.out.println(microSeconds);
	//	System.out.println(getMilliSeconds(time)+Long.valueOf(microSeconds));
		milliSecs.add(getMilliSeconds(time)+Long.valueOf(microSeconds));
		}
		return milliSecs;
		}
}
