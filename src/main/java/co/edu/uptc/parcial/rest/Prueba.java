package co.edu.uptc.parcial.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 


@Path("/Prueba")
public class Prueba {
	
	@GET
	@Path("/getPrueba")
	@Produces( { MediaType.APPLICATION_JSON } )
	public String getPrueba(){
		return ("FUNCIONAAAAAAAAA");
	}

}
