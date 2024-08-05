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
import ups.edu.ec.prb.api_banca.bussines.GestionMovimiento;
import ups.edu.ec.prb.api_banca.bussines.GestionMovimiento;
import ups.edu.ec.prb.api_banca.model.Movimiento;
import ups.edu.ec.prb.api_banca.model.Movimiento;

@Path("/movimientos")
public class MovimientoService {

	
	@Inject
	private GestionMovimiento gMovimiento;
	
	/* °°°°°°°°°°°°
	 * 	  POST
	 * °°°°°°°°°°°° */
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON) //en que formato va recibir el parametro, que es lo que viene y como transformalo
	public Response create(Movimiento Movimiento) {
		
		try {
			gMovimiento.createMovimiento(Movimiento);
			return Response.ok(Movimiento).build();
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
	public Response update(Movimiento Movimiento) {
		try {
			gMovimiento.updateMovimiento(Movimiento);
			return Response.ok(Movimiento).build();
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
//	        gMovimiento.deleteMovimiento(numero);
//	        return Response.noContent().build();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        if (e.getMessage().equals("Movimiento no existe")) {
//	            return Response.status(404).entity(new Respuesta(Respuesta.ERROR, e.getMessage())).build();
//	        } else {
//	            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
//	        }
//	    }
//	}
	 
	
	/* °°°°°°°°°°°°
	 * 	   GET
	 * °°°°°°°°°°°° */
	
	//Recuperar
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public List<Movimiento> list(@PathParam("numero") String numero) {
		try {
			List<Movimiento> Movimientos = gMovimiento.filtrarPorCuenta(Integer.valueOf(numero));
			return Movimientos;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}



	//Recuperar una lista de Movimiento
	@GET
	@Produces("application/json")
	public List<Movimiento> list() {
		List<Movimiento> Movimientos = gMovimiento.getMovimientos();
		return Movimientos;
	}
	
	
}
