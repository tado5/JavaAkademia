package sk.ness.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Student {

	@Id
	@GeneratedValue
	int ID;
	
	@GeneratedValue
	private String meno;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	private String priezvisko;
	
	private int vek ;

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getPriezvisko() {
		return priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public int getVek() {
		return vek;
	}

	public void setVek(int vek) {
		this.vek = vek;
	}

	@Override
	public String toString() {
		return "student [meno=" + meno + ", priezvisko=" + priezvisko
				+ ", vek=" + vek + "]";
	}
	
	
	
}
