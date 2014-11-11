package crm.to;

import javax.persistence.*;


public class ClientTO {
	private int client_id;
	String client_name;
	String client_add;
	String client_phn;
	String client_site_add;
	String guaranter_name;
	String guaranter_phn;
	
	public int getClient_id() {
		return client_id;
	}
	
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	public String getClient_add() {
		return client_add;
	}
	public void setClient_add(String client_add) {
		this.client_add = client_add;
	}
	
	public String getClient_phn() {
		return client_phn;
	}
	public void setClient_phn(String client_phn) {
		this.client_phn = client_phn;
	}
	
	public String getClient_site_add() {
		return client_site_add;
	}
	public void setClient_site_add(String client_site_add) {
		this.client_site_add = client_site_add;
	}
	
	public String getGuaranter_name() {
		return guaranter_name;
	}
	public void setGuaranter_name(String guaranter_name) {
		this.guaranter_name = guaranter_name;
	}
	
	public String getGuaranter_phn() {
		return guaranter_phn;
	}
	public void setGuaranter_phn(String guaranter_phn) {
		this.guaranter_phn = guaranter_phn;
	}
}
