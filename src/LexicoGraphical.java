import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author NguyenVu
 * @version 1.0
 *
 */


public class LexicoGraphical extends AbstractSort{
	/**
	 * Constructor to sort the map of vehicle ID
	 * @param unsorted   The unsorted Map of the Vehicle ID from data
	 */
	public LexicoGraphical(HashMap<String, Integer> unsorted) {
		sortedMap(unsorted);
	}
	/**
	 * Method to sort the map of the vehicle ID 
	 */
	@Override
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		// Using TreeMap to sort the HashMap VehicleID
		Map<String,Integer> treeMap = new TreeMap<String, Integer>(unsorted);
		for (String vehID : treeMap.keySet()) {
			// Print the output with the right format
			System.out.println(vehID);
		}
		// Return the HashMap of Sorted VehID
		return treeMap;

	}
}
