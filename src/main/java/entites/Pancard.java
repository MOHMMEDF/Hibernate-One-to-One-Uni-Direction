package entites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pancard {

	@Id
	private Integer pan_id;
	
	private String address;
	
	
	public Pancard() {
		// TODO Auto-generated constructor stub
	}

	public Pancard(Integer pan_id, String address) {
		super();
		this.pan_id = pan_id;
		this.address = address;
	}

	public Integer getPan_id() {
		return pan_id;
	}

	public void setPan_id(Integer pan_id) {
		this.pan_id = pan_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pancard [pan_id=" + pan_id + ", address=" + address + "]";
	}
	
	
	
}
