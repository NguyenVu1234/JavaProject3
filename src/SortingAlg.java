import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author NguyenVu
 * @version 1.0
 *
 */
public class SortingAlg {
	private Map<LocalDate, Integer> unSortedDate ;
	private ArrayList<LocalDate> dateList;
	/**
	 * Method to sort the list of date in data file in descending order
	 * @throws IOException   The exceptions produced by failed or interrupted I/O operations.
	 * @throws FileNotFoundException     Signals that an attempt to open the file
	 *                                   denoted by a specified pathname has failed
	 * 						             on input error
	 *  
	 */
	public void sortDescending() throws IOException, FileNotFoundException{
		// Construct the map of the date 
		unSortedDate = new HashMap<LocalDate,Integer>();

		// Read the data from file path
		String filePath = new String("ComplexDates.txt");
		BufferedReader br = new BufferedReader(new FileReader(filePath)) ;
		String line;

		// Split the input by new line and add it to the dateList
		int value = 1;
		while((line = br.readLine()) != null) {
			String[] localDate = line.trim().split("\n");
			// Remove all the space between the date
			localDate[0] = localDate[0].replaceAll("\\s", "");
			// Add the localDate (key) and value with the right format to the Map
			unSortedDate.put(LocalDate.parse(localDate[0]),value);
			value++;

		}
		br.close();
		// Construct a list of date
		dateList = new ArrayList<LocalDate>();

		// Add the date from the Map to the ArrayList
		for(LocalDate keyDate : unSortedDate.keySet()) {
			dateList.add(keyDate);
		}

		// Sort the list of date in descending order
		ArrayList<LocalDate> sortedList = descendingOrder(dateList);
		// Print out the descending order
		for(int i = 0; i < sortedList.size(); ++i) {
			System.out.println(sortedList.get(i));
		}
	}
	/**
	 * Algorithm to sort the list of date in descending order
	 * The idea of sorting the date list in descending order or ascending is that I will compare 
	 * the year of the date list. If the year is same then I will compare the month of them. If both 
	 * year and month are same then I will compare the day
	 * 
	 * First I will make a nested loop and compare the first element of the list to the other elements
	 * of the list if there is a element which is greater than the first element of the list then I will 
	 * assign the first element to that element. 
	 * 
	 * @param unsortedList  The unsorted list of local date 
	 * @return   The sorted list of local date
	 */
	public ArrayList<LocalDate> descendingOrder (ArrayList<LocalDate> unsortedList){

        //Sort the array in descending order using two for loops    
		for ( int i = 0; i < unsortedList.size(); ++i) {
			for(int j = i; j < unsortedList.size(); ++j) {
				//swap elements if not in order
				if(unsortedList.get(i).getYear() < unsortedList.get(j).getYear()) {
					LocalDate temp = unsortedList.get(i);
					unsortedList.set(i, unsortedList.get(j));
					unsortedList.set(j, temp);

				}
			}
		}

		for (int i = 0; i < unsortedList.size(); ++i) {
			for(int j = i; j < unsortedList.size(); ++j) {
				if(unsortedList.get(i).getYear()== unsortedList.get(j).getYear() && unsortedList.get(i).getMonthValue() < unsortedList.get(j).getMonthValue()){
					LocalDate temp = unsortedList.get(i);
					unsortedList.set(i, unsortedList.get(j));
					unsortedList.set(j, temp);
				}
			}
		}

		for (int i = 0; i < unsortedList.size(); ++i) {
			for(int j = i; j < unsortedList.size(); ++j) {
				if(unsortedList.get(i).getYear()== unsortedList.get(j).getYear() && unsortedList.get(i).getMonthValue() == unsortedList.get(j).getMonthValue()&& unsortedList.get(i).getDayOfMonth() < unsortedList.get(j).getDayOfMonth()){
					LocalDate temp = unsortedList.get(i);
					unsortedList.set(i, unsortedList.get(j));
					unsortedList.set(j, temp);
				}
			}
		}

		return unsortedList;

	}

	/**
	 * Algorithm to sort the list of date in descending order
	 * First I will make a nested loop and compare the first element of the list to the other elements
	 * of the list if there is a element which is less than the first element of the list then I will 
	 * assign the first element to that element. 
	 */
	public void sortAscending() {
        //Sort the array in ascending order using two for loops    
		for ( int i = 0; i < dateList.size(); ++i) {
			for(int j = i; j < dateList.size(); ++j) {
				//swap elements if not in order
				if(dateList.get(i).getYear() > dateList.get(j).getYear()) {
					LocalDate temp = dateList.get(i);
					dateList.set(i, dateList.get(j));
					dateList.set(j, temp);

				}
			}
		}

		for (int i = 0; i < dateList.size(); ++i) {
			for(int j = i; j < dateList.size(); ++j) {
				if(dateList.get(i).getYear()== dateList.get(j).getYear() && dateList.get(i).getMonthValue() > dateList.get(j).getMonthValue()){
					LocalDate temp = dateList.get(i);
					dateList.set(i, dateList.get(j));
					dateList.set(j, temp);
				}
			}
		}

		for (int i = 0; i < dateList.size(); ++i) {
			for(int j = i; j < dateList.size(); ++j) {
				if(dateList.get(i).getYear()== dateList.get(j).getYear() && dateList.get(i).getMonthValue() == dateList.get(j).getMonthValue() && dateList.get(i).getDayOfMonth() > dateList.get(j).getDayOfMonth()){
					LocalDate temp = dateList.get(i);
					dateList.set(i, dateList.get(j));
					dateList.set(j, temp);
				}
			}
		}
		
		// Print out the ascending order
		for(int i = 0; i < dateList.size(); ++i) {
			System.out.println(dateList.get(i));
		}

	}
}











