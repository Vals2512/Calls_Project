package co.edu.uptc.parcial.crud;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.parcial.dto.CallDTO;
import co.edu.uptc.parcial.enums.ETypeCall;

public class CRUD {
	
	public static List<CallDTO> calls  = new ArrayList<>();

	public static List<CallDTO> getCalls() {
		return calls;
	}

	public static void setCalls(List<CallDTO> calls) {
		CRUD.calls = calls;
	}

	public CRUD() {
	}

	public static boolean addCall(CallDTO call) {
		if (calls.contains(call)) {
			return false;
		} if(!calls.contains(call)) {
			calls.add(call);
			return true;
		}
		return false;
	}
	
	public static double calculateCallValue(CallDTO call) {
		double total = 0;

		ETypeCall etypecall = call.getEtypecall();
		double total2 = 0;
		double minuteValue = call.getValueMinute();

		switch (etypecall) {
			case MISMO:
				total = minuteValue * call.getDuration();
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
	
	
	public static CallDTO getCallInformation(Integer id) {
		
		CallDTO found = new CallDTO();
		
		
		if(id != null) {
			
			for(CallDTO call : getCalls()) {
				
				if(call.getId() ==id) {
					if(call != null) {
						found = new CallDTO(call.getNumberCalled(), calculateCallValue(call));
					
					
				}
			}
			return found;
			
			
		
		}
		
		
	}
		return null;	
}
}
		
	/*

	public double getTotalCallsValue() {
		double total = 0;
		for (Cellphone cellphone : mapCellphone.values()) {
			total += cellphone.getTotalCallsValue();
		}
		return total;
	}

	public int getTotalMinutesConsumed() {
		int total = 0;
		for (Cellphone cellphone : mapCellphone.values()) {
			total += cellphone.getTotalMinutesConsumed();
		}
		return total;
	}

	public List<String> getCallsInformation() {
		List<String> callsInformation = new ArrayList<>();
		for (Map.Entry<String, Cellphone> entry : mapCellphone.entrySet()) {
			String phoneNumber = entry.getKey();
			callsInformation.add("Cellphone: " + phoneNumber);
			Cellphone cellphone = entry.getValue();
			for (Call call : cellphone.getCalls()) {
				callsInformation.add(call.toString());
			}
		}
		return callsInformation;
	}*/

	
	
	

