	/**
 * 
 * @author NguyenVu
 * @version 1.0
 *
 */
public class AsciiAverage extends AbstractAscii {
	private String VehicleID;
	/**
	 * Constructor to initialize the Vehicle ID
	 * @param VehicleID    The vehicle ID which will be calculated the ASCII average (vh0000)
	 */
	public AsciiAverage(Vanet VehicleID) {
		this.VehicleID = VehicleID.getVehicleID();
	}
	/**
	 * The method to calculate the average of the VehicleID
	 * @return   the average of VehicleID 
	 */
	@Override
	public int calAverage() {
		// Declare a value of average in type int
		int finalAverage;
		int sum = 0;
		// Add up the sum of each letter by ascii number of it
		for (int i = 0; i < VehicleID.length(); ++i) {
			sum = sum + (int) VehicleID.charAt(i);
		}
		// calculate the average in type double
		double tempAverage = (double)sum / VehicleID.length();
		// Compare the difference between average and the round down of it with 0.5
		// If the difference of them is less than 0.5 then round down the average
		if(tempAverage - Math.floor(tempAverage)  < 0.5) {
			finalAverage = (int) Math.floor(tempAverage);
		}
		// Round up the average if the difference of them is greater than 0.5
		else {
			finalAverage = (int) Math.ceil(tempAverage);
		}
		return finalAverage;
	}

}

