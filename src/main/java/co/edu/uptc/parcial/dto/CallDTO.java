package co.edu.uptc.parcial.dto;

import co.edu.uptc.parcial.crud.CRUD;
import co.edu.uptc.parcial.enums.ETypeCall;

public class CallDTO {

	private Integer id;
	private static String ownNumber = "32227209441";
	private String numberCalled;
	private ETypeCall etypecall;
	private static float valueMinute = 300;
	private Integer duration;
	
	public CallDTO() {
	}

	public CallDTO(Integer id, String numberCalled, ETypeCall etypecall,  Integer duration) {
		super();
		ownNumber = "32227209441";
		this.id = id;
		this.numberCalled = numberCalled;
		this.etypecall = etypecall;
		valueMinute = 300;
		this.duration = duration;
	}
	
	public CallDTO( String numberCalled, double totalValue  ) {
		ownNumber = "32227209441";
		this.numberCalled = numberCalled;
		totalValue = CRUD.calculateCallValue(this);
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
	
	

	
	
	
	
	}

