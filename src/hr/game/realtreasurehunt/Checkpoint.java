package hr.game.realtreasurehunt;

public class Checkpoint {

	//TODO:geteri i seteri
	private String instructions;
	private String checkpointCode;
	private double gpsLongitude;
	private double gpsLatitude;
	
	public Checkpoint(String instructions, String checkpointCode, double longitude, double latitude)
	
	{
		this.instructions = instructions;
		this.checkpointCode = checkpointCode;
		this.gpsLatitude = latitude;
		this.gpsLongitude = longitude;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getCheckpointCode() {
		return checkpointCode;
	}

	public void setCheckpointCode(String checkpointCode) {
		this.checkpointCode = checkpointCode;
	}

	public double getGpsLongitude() {
		return gpsLongitude;
	}

	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public double getGpsLatitude() {
		return gpsLatitude;
	}

	public void setGpsLatitude(double gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}


}
