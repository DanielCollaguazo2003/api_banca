package ups.edu.ec.prb.api_banca.service;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.prb.api_banca.bussines.GestionCuenta;
import ups.edu.ec.prb.api_banca.bussines.GestionMovimiento;
import ups.edu.ec.prb.api_banca.model.Cuenta;
import ups.edu.ec.prb.api_banca.model.Movimiento;

@Path("/cuentas")
public class CuentaService {

	
	@Inject
	private GestionCuenta gCuenta;
	
	@Inject
	private GestionMovimiento gMovimiento;
	
	/* °°°°°°°°°°°°
	 * 	  POST
	 * °°°°°°°°°°°° */
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON) //en que formato va recibir el parametro, que es lo que viene y como transformalo
	public Response create(Cuenta cuenta) {
		
		try {
			gCuenta.createCuenta(cuenta);
			return Response.ok(cuenta).build();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	
	/* °°°°°°°°°°°°
	 * 	   PUT
	 * °°°°°°°°°°°° */
	
	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Cuenta cuenta) {
		try {
			gCuenta.updateCuenta(cuenta);
			return Response.ok(cuenta).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "No se actualizo")).build();
		}
		
	}

	
	/* °°°°°°°°°°°°
	 * 	 DELETE
	 * °°°°°°°°°°°° */
	
//	@DELETE
//	@Path("/{numero}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response delete(@PathParam("numero") int numero) {
//	    try {
//	        gCuenta.deleteCuenta(numero);
//	        return Response.noContent().build();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        if (e.getMessage().equals("Cuenta no existe")) {
//	            return Response.status(404).entity(new Respuesta(Respuesta.ERROR, e.getMessage())).build();
//	        } else {
//	            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
//	        }
//	    }
//	}
	 
	
	/* °°°°°°°°°°°°
	 * 	   GET
	 * °°°°°°°°°°°° */
	
	//Recuperar un cliente por medio de la cedula
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public Cuenta get(@PathParam("numero") String numero) {
		Cuenta cuenta;
		System.out.print("sasasqewretwyuiyoytytrewq	erstdfhgjkllhuytrew54q32     " + numero);
		try {
			cuenta = gCuenta.getCuenta(Integer.valueOf(numero));
			return cuenta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}



	//Recuperar una lista de Cuenta
	@GET
	@Produces("application/json")
	public List<Cuenta> list() {
		List<Cuenta> cuentas = gCuenta.getCuentas();
		return cuentas;
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Movimiento> list2() {
		List<Movimiento> movs = gMovimiento.getMovimientos();
		return movs;
	}
	
}
