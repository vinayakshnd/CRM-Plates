package crm.to;

public class SubAdminTO {
	int SubadminId;
	String SubadminName;
	String SubadminAdd;
	int OfficeId;
	String SubadminPhn;
	int Delete_Status;
	
	public int getOfficeId() {
		return OfficeId;
	}
	public void setOfficeId(int officeId) {
		OfficeId = officeId;
	}
	public int getDelete_Status() {
		return Delete_Status;
	}
	public void setDelete_Status(int delete_Status) {
		Delete_Status = delete_Status;
	}
	public int getSubadminId() {
		return SubadminId;
	}
	public void setSubadminId(int subadminId) {
		SubadminId = subadminId;
	}
	public String getSubadminName() {
		return SubadminName;
	}
	public void setSubadminName(String subadminName) {
		SubadminName = subadminName;
	}
	public String getSubadminAdd() {
		return SubadminAdd;
	}
	public void setSubadminAdd(String subadminAdd) {
		SubadminAdd = subadminAdd;
	}
	public int getSubadminOffice() {
		return this.OfficeId;
	}
	public void setSubadminOffice(int OfficeId) {
		this.OfficeId = OfficeId;
	}
	public String getSubadminPhn() {
		return SubadminPhn;
	}
	public void setSubadminPhn(String subadminPhn) {
		SubadminPhn = subadminPhn;
	}
	@Override
	public String toString() {
		return "SubAdminTO [SubadminId=" + SubadminId + ", SubadminName="
				+ SubadminName + ", SubadminAdd=" + SubadminAdd
				+ ", SubadminOffice=" + this.OfficeId + ", SubadminPhn="
				+ SubadminPhn +  "]";
	}
	
}
