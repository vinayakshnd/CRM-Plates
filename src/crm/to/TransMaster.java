package crm.to;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TransMaster {

	private int transaction_id;
	private int subadmin_id;
	private int client_id;	
	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	private Date date;
	private Date closingDate;
	
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	private float advance;
	private float total_amount;
	private float remaining_amount;
	private int isOpen;
	
	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	private ArrayList<TransSub> contents;
	
	public TransMaster() {	
		this.contents =  new ArrayList<TransSub>();
	}
	public ArrayList<TransSub> getContents() {
		return contents;
	}

	public void setContents(ArrayList<TransSub> contents) {
		this.contents = contents;
	}

	/**
	 * Add the contents to the transaction
	 * @param e
	 * @return
	 */
	public boolean addContents(TransSub e) {		
		return this.contents.add(e);				
	}
	
	public boolean removeContent(TransSub e){
		//TODO : Search for e (based on content_id)in array and then delete.
		return true;
	}
	/**
	 * transaction_id, subadmin_id, date fields are
	 * auto initialized.
	 */
	public void TrasactionTo() {
		       	
		contents = new ArrayList<TransSub>();
		
		//assign subadmin_id;
				
	}
	
	public int getSubadmin_id() {
		return subadmin_id;
	}

	public void setSubadmin_id(int subadmin_id) {
		this.subadmin_id = subadmin_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public float getAdvance() {
		return advance;
	}

	public void setAdvance(float float1) {
		this.advance = float1;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public float getRemaining_amount() {
		return remaining_amount;
	}

	public void setRemaining_amount(float remaining_amount) {
		this.remaining_amount = remaining_amount;
	}

	@Override
	public String toString() {
		return "TransMaster [transaction_id=" + transaction_id
				+ ", subadmin_id=" + subadmin_id + ", client_id=" + client_id
				+ ", date=" + date + ", closingDate=" + closingDate
				+ ", advance=" + advance + ", total_amount=" + total_amount
				+ ", remaining_amount=" + remaining_amount + ", isOpen="
				+ isOpen + ", contents=" + contents + "]";
	}
	
	

}
