package co.edu.uptc.parcial.crud;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.parcial.dto.CallDTO;
import co.edu.uptc.parcial.enums.ETypeCall;

public class CRUD {

	public List<CallDTO> calls;
	private static CRUD instance;

	public List<CallDTO> getCalls() {
		return calls;
	}

	public void setCalls(List<CallDTO> calls) {
		this.calls = calls;
	}

	private CRUD() {
		this.calls = new ArrayList<CallDTO>();
	}

	public static CRUD getInstance() {
		if (instance == null) {
			instance = new CRUD();
		}
		return instance;
	}

	public boolean addCall(CallDTO call) {
		if (calls.contains(call)) {
			return false;
		}
		if (!calls.contains(call)) {
			calls.add(call);
			return true;
		}
		return false;
	}

	public double calculateCallValue(CallDTO call) {
		double total = 0;

		ETypeCall etypecall = call.getEtypecall();
		double total2 = 0;
		double minuteValue = call.getValueMinute();

		switch (etypecall) {
		case MISMO:
			total = minuteValue * call.getDuration();
			total2 = total;
			break;
		case OTRO:
			total = minuteValue * call.getDuration();
			total2 = total * 1.05;
			break;
		case NACIONAL:
			total = minuteValue * call.getDuration();
			total2 = total * 1.10;
			break;
		case INTERNACIONAL:
			total = minuteValue * call.getDuration();
			total2 = total * 1.15;
			break;
		}
		return total2;
	}

	public CallDTO getCallInformation(Integer id) {
		if (id != null) {
			for (CallDTO call : this.getCalls()) {
				if (call.getId().equals(id)) {
					return call;
				}
			}

		}
		return null;
	}
	
	 public double calculateTotalCallsValueByType(ETypeCall type) {
	        double totalValue = 0;
	        for (CallDTO call : calls) {
	            if (type == null || call.getEtypecall() == type) {
	                totalValue += calculateCallValue(call);
	            }
	        }
	        return totalValue;
	    }
	
}

/*
 * 
 * public double getTotalCallsValue() { double total = 0; for (Cellphone
 * cellphone : mapCellphone.values()) { total += cellphone.getTotalCallsValue();
 * } return total; }
 * 
 * public int getTotalMinutesConsumed() { int total = 0; for (Cellphone
 * cellphone : mapCellphone.values()) { total +=
 * cellphone.getTotalMinutesConsumed(); } return total; }
 * 
 * public List<String> getCallsInformation() { List<String> callsInformation =
 * new ArrayList<>(); for (Map.Entry<String, Cellphone> entry :
 * mapCellphone.entrySet()) { String phoneNumber = entry.getKey();
 * callsInformation.add("Cellphone: " + phoneNumber); Cellphone cellphone =
 * entry.getValue(); for (Call call : cellphone.getCalls()) {
 * callsInformation.add(call.toString()); } } return callsInformation; }
 */
