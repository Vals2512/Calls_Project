package co.edu.uptc.parcial.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import co.edu.uptc.parcial.crud.CRUD;
import co.edu.uptc.parcial.dto.CallDTO;
import co.edu.uptc.parcial.enums.ETypeCall;


@Path("/ManagementCalls")
public class ManagementCalls {
	private CRUD crud = CRUD.getInstance();
	
	@POST
	@Path("/createCall")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	
	public boolean createBook(CallDTO callDTO) {
		if(crud.addCall(callDTO)) {
			return true;
			
		}
		return false;
	}
	
	@GET
	@Path("/getCallByCode")
	@Produces({ MediaType.APPLICATION_JSON })
	public Map<String, String> getCallByCode(@QueryParam("id") Integer id){
		CallDTO foundCall = crud.getCallInformation(id);
		Map<String, String> call = new HashMap<String, String>();
		call.put("numberOrigin", foundCall.getOwnNumber());
		call.put("numberDestination", foundCall.getNumberCalled());
		call.put("total", String.valueOf(crud.calculateCallValue(foundCall)));
		return call;
	}
	
	 @GET
	 @Path("/getTotalCashByType")
	 @Produces({ MediaType.APPLICATION_JSON })
	 public double getTotalCashByType(@QueryParam("type") ETypeCall type) {
		 return crud.calculateTotalCallsValueByType(type);
	 }
	 
	 @GET
	    @Path("/getTotalMinutesByType")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public int getTotalMinutesByType(@QueryParam("type") ETypeCall type) {
	        return crud.calculateTotalMinutesByType(type);
	    }
	
	 @POST
	    @Path("/getCallsByFilter")
	    @Produces({ MediaType.APPLICATION_JSON })
	    @Consumes({ MediaType.APPLICATION_JSON })
	    public List<CallDTO> getCallsByFilter(CallDTO filter) {
	        return crud.getCallsByFilter(filter);
	    }
	
	
}
