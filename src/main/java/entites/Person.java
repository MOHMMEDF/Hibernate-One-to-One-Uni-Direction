package entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	
	@Id
	private Integer p_id;
	
	private String p_name;
	
	@OneToOne
	private Pancard pancard;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}


	public Person(Integer p_id, String p_name, Pancard pancard) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.pancard = pancard;
	}


	public Integer getP_id() {
		return p_id;
	}


	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public Pancard getPancard() {
		return pancard;
	}


	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}


	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", p_name=" + p_name + ", pancard=" + pancard + "]";
	}
	
	
	
	
}
