//This class would be base for objects which store each event's specific data;
//Each object hold unique event data and the data elements are stored separately by their type;

public class Event {
	// Declare expected variables;
	public String id;
	public String type;
	public int day;
	public int month;
	public int year;
	public String time;
	public String address;
	public String sector;
	public String zone;

//This constructor takes values from parameter and stores that values to declared variables;
	public Event(String id, String type, int day, int month, int year, String time, String address, String sector,
			String zone) {
		this.id = id;
		this.type = type;
		this.day = day;
		this.month = month;
		this.year = year;
		this.time = time;
		this.address = address;
		this.sector = sector;
		this.zone = zone;
	}

//Show following statement when this object is called;
	public String toString() {
		String str = "Type: " + type;
		str += "\nDate: " + (day + "/" + month + "/" + year);
		str += "\nTime: " + time;
		str += "\nAddress: " + address;
		str += "\nSector: " + sector;
		str += "\nZone: " + zone;
		return str;
	}
}