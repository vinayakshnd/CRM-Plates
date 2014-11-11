package crm.to;

public class PlateTO {
	int Plate_Id;
	String Size;
	int Total_Plate;
	int Available_Plate;
	float Rate_Per_Plate;
	public int getPlate_Id() {
		return Plate_Id;
	}
	public void setPlate_Id(int plate_Id) {
		Plate_Id = plate_Id;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public int getTotal_Plate() {
		return Total_Plate;
	}
	public void setTotal_Plate(int total_Plate) {
		Total_Plate = total_Plate;
	}
	public int getAvailable_Plate() {
		return Available_Plate;
	}
	public void setAvailable_Plate(int available_Plate) {
		Available_Plate = available_Plate;
	}
	public float getRate_Per_Plate() {
		return Rate_Per_Plate;
	}
	public void setRate_Per_Plate(float rate_Per_Plate) {
		Rate_Per_Plate = rate_Per_Plate;
	}
	@Override
	public String toString() {
		return "PlateTO [Plate_Id=" + Plate_Id + ", Size=" + Size
				+ ", Total_Plate=" + Total_Plate + ", Available_Plate="
				+ Available_Plate + ", Rate_Per_Plate=" + Rate_Per_Plate + "]";
	}
	
}
