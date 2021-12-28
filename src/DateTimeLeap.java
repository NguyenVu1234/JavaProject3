	
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author NguyenVu
 * @version 1.0
 *
 */
public class DateTimeLeap {

	private HashMap<LocalDate,Integer> date;


	/**
	 * Method to compare the date of the current date and the local date
	 * @throws IOException The exceptions produced by failed or interrupted I/O operations.
	 * @throws FileNotFoundException Signals that an attempt to open the file
	 *                               denoted by a specified pathname has failed
	 * 						         on input error
	 */
	public void compareYear() throws IOException,FileNotFoundException{
		// Construct the HashMap
		date = new HashMap<LocalDate,Integer>();

		// Get the current date (format will be yy-mm-dd)
		LocalDate currentDate = LocalDate.now();

		// Read the input from the file path
		String filePath = new String("SimpleDates.txt");
		BufferedReader br = new BufferedReader(new FileReader(filePath)) ;
		String line;
		// First value of a HashMap is 1
		int value = 1;
		// Split the input by "." and add it to the HashMap date
		while((line = br.readLine()) != null) {
			String [] tempArray = line.split("\\.");
			// Put each local date (key) into the HashMap with the right format (yy-mm-dd) and increment the value
			date.put(LocalDate.parse(tempArray[2] + "-" + tempArray[0] + "-" + tempArray[1]), value);
			value++;
		}
		br.close();

		for(LocalDate startDate: date.keySet()) {

			// Create an object from the Period class to use the between() method to compare the date
			Period compareDate = Period.between(startDate, currentDate);
			int diffYear = compareDate.getYears();
			int diffMonth = compareDate.getMonths();
			int diffDay = compareDate.getDays();

			// Use method isLeapYear() to determine the leap year. If it returns true then the year is leap year
			if(startDate.isLeapYear()) {
				System.out.println( startDate.getYear() + " is a leap year, and the difference: " + diffYear + " years, " + 
						diffMonth + " months, and " + 	diffDay + " days.");

			}

			// If it returns false then the year is not leap year
			else {
				System.out.println( startDate.getYear() + " is not a leap year, and the difference: " + diffYear + " years, " + 
						diffMonth + " months, and " + 	diffDay + " days.");
			}


		}

	}
	/**
	 * Method to put the local date into the Map
	 */
	public void dateHashMap() {
		// Print out the output from the HashMap without sorting it
		for(LocalDate localDate: date.keySet()) {
			System.out.println(localDate+ ":" + date.get(localDate));
		}
	}

	/**
	 * Method to sort the local date of the map using TreeMap
	 */
	public void dateHashMapSort() {
		// Using TreeMap to sort the HashMap date
		Map<LocalDate,Integer> treeMap = new TreeMap<LocalDate, Integer>(date);
		for (LocalDate localDate : treeMap.keySet()) {
			// Print the output after sorting with the right format
			System.out.println(localDate + ":" + treeMap.get(localDate));
		}
	}

}

