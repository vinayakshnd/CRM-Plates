package crm.to;

public class OfficeTO {
	int Office_Id;
	String Office_Name;
	String Office_Add;
	String Office_Phn;
	public int getOffice_Id() {
		return Office_Id;
	}
	public void setOffice_Id(int office_Id) {
		Office_Id = office_Id;
	}
	public String getOffice_Name() {
		return Office_Name;
	}
	public void setOffice_Name(String office_Name) {
		Office_Name = office_Name;
	}
	public String getOffice_Add() {
		return Office_Add;
	}
	public void setOffice_Add(String office_Add) {
		Office_Add = office_Add;
	}
	public String getOffice_Phn() {
		return Office_Phn;
	}
	public void setOffice_Phn(String office_Phn) {
		Office_Phn = office_Phn;
	}
	@Override
	public String toString() {
		return "OfficeTO [Office_Id=" + Office_Id + ", Office_Name="
				+ Office_Name + ", Office_Add=" + Office_Add + ", Office_Phn="
				+ Office_Phn + "]";
	}
	
}
