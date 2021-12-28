import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author NguyenVu 
 * @version 1.0
 *
 */
public class EqualAverage {
	private String VehID;
	/**
	 * Constructor to initialize the vehicle ID
	 * @param VehID   the vehicle ID that will be compared (veh0000)
	 */
	public EqualAverage(String VehID) {
		this.VehID = VehID;
	}
	/**
	 * Method to compare the ASCII average of the local vehicleID with VehID (veh0000)
	 * @return The map with the vehicle ID which have average equal to VehID(veh0000)
	 * @throws IOException    The exceptions produced by failed or interrupted I/O operations.
	 * @throws FileNotFoundException 	 Signals that an attempt to open the file
	 *                                   denoted by a specified pathname has failed
	 * 						             on input error
	 */
	public HashMap<String,Integer> calAsciiEqual() throws IOException, FileNotFoundException{
		HashMap<String,Integer> listVehicleID = new HashMap<String,Integer>();
		ArrayList <String>listVehID = new ArrayList<String>(); 
		String filePath = new String("VANETData.txt");
		BufferedReader br = new BufferedReader(new FileReader(filePath)) ;
		String line;

		// Split the input by new line and add it to the dateList
		while((line = br.readLine()) != null) {
			String[] array = line.trim().split("\\s+");
			// We only get the vehicle ID with 6 characters to eliminate the vehicle ID which are less than 100 in the numeric part
			if (array[0].length() == 6) {
				listVehID.add(array[0]);
			}
		}
		br.close();

		// Make an object of the AsciiAverage class with any vehID to start (Ex: veh000)
		AsciiAverage originalVehID = new AsciiAverage(new Vanet(VehID));
		// Calculate the average of any vehID to start (Ex: veh000)
		int avgOrgVehID = originalVehID.calAverage();

		for(int i =0 ; i < listVehID.size(); ++i) {
			// Make another object of the AsciiAverage with the vehID from data
			AsciiAverage DataVehID = new AsciiAverage(new Vanet(listVehID.get(i)));
			// Calculate the average of vehID from data
			int avgDataVehID = DataVehID.calAverage();
			// if the average of vehID from data equals to average of vehID that we want to compare to then add to HashMap
			if(avgDataVehID == avgOrgVehID) {
				// add key and value to HashMap
				listVehicleID.put(listVehID.get(i), avgDataVehID);
			}
		}
		return listVehicleID;
	}
}