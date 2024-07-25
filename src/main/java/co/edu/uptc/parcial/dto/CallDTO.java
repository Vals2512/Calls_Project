package co.edu.uptc.parcial.dto;

import co.edu.uptc.parcial.crud.CRUD;
import co.edu.uptc.parcial.enums.ETypeCall;

public class CallDTO {

	private Integer id;
	final private String ownNumber = "32227209441";
	private String numberCalled;
	private ETypeCall etypecall;
	final private float valueMinute = 300;
	private Integer duration;
	private CRUD crud = CRUD.getInstance();

	public CallDTO() {
	}

	public CallDTO(Integer id, String numberCalled, ETypeCall etypecall, Integer duration) {
		super();
		this.id = id;
		this.numberCalled = numberCalled;
		this.etypecall = etypecall;
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwnNumber() {
		return ownNumber;
	}

	public String getNumberCalled() {
		return numberCalled;
	}

	public void setNumberCalled(String numberCalled) {
		this.numberCalled = numberCalled;
	}

	public ETypeCall getEtypecall() {
		return etypecall;
	}

	public void setEtypecall(ETypeCall etypecall) {
		this.etypecall = etypecall;
	}

	public float getValueMinute() {
		return valueMinute;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "CallDTO [id=" + id + ", numberCalled=" + numberCalled + ", etypecall=" + etypecall + ", duration="
				+ duration + ", crud=" + crud + "]";
	}
	
	

}
