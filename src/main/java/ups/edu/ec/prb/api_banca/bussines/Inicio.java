package ups.edu.ec.prb.api_banca.bussines;

import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.prb.api_banca.dao.CuentaDAO;
import ups.edu.ec.prb.api_banca.dao.MovimientoDAO;
import ups.edu.ec.prb.api_banca.model.Cuenta;
import ups.edu.ec.prb.api_banca.model.Movimiento;


@Singleton
@Startup
public class Inicio {
	
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private MovimientoDAO daoMovimiento;
	
	
	@PostConstruct
	public void init() {
		
		System.out.println("Hola Mundo EJB");
		
		Cuenta cuenta = new Cuenta();
		cuenta.setNumero(1);
		cuenta.setCedula("1717273401");
		cuenta.setNombre("Domenika Delgado");
		cuenta.setUsuario("dome");
		cuenta.setClave("123");
		
		Movimiento m = new Movimiento();
		//m.setCodigo(1);
		m.setFecha(new Date());
		m.setTansaccion("Cobros");
		m.setTipo(false);
		m.setValor(100.30);
		m.setnCuenta(cuenta);
		daoMovimiento.insert(m);
		
		Movimiento m1 = new Movimiento();
		//m1.setCodigo(2);
		m1.setFecha(new Date());
		m1.setTansaccion("Cobros nuevos");
		m1.setTipo(true);
		m1.setValor(20.30);
		m1.setnCuenta(cuenta);
		daoMovimiento.insert(m1);
		
		daoCuenta.insert(cuenta);
		
		List<Movimiento> listadoMov = daoMovimiento.getAll();
		for(Movimiento mov: listadoMov) {
			System.err.println("movimientos --> " + mov.getCodigo());
		}
		
		List<Cuenta> listado = daoCuenta.getAll();
		for(Cuenta cli: listado) {
			System.err.println(cli.getNombre());
		}
		
		
	}

}
