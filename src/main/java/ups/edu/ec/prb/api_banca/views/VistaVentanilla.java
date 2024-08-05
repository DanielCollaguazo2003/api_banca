package ups.edu.ec.prb.api_banca.views;

import java.util.Date;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import ups.edu.ec.prb.api_banca.bussines.GestionCuenta;
import ups.edu.ec.prb.api_banca.bussines.GestionMovimiento;
import ups.edu.ec.prb.api_banca.model.Cuenta;
import ups.edu.ec.prb.api_banca.model.Movimiento;

@Named("transacciones")  /*el objeto sea gestionado desde JSF*/
@RequestScoped /**solicitud sin .. */
public class VistaVentanilla {
	
	
	@Inject
	private GestionMovimiento gMovimiento;
	
	@Inject
	private GestionCuenta gCuenta;
	
	private Movimiento movimiento = new Movimiento();
	
	private Cuenta cuenta= new Cuenta();
	
	private int numeroCuenta = 0;
	
	private List<Movimiento> listado;
	
	
	@PostConstruct
	public void init() {
		listado = gMovimiento.getMovimientos();  /*recupere en listado los clientes que tengo en mi BD*/
	}
	
	/*GETTERS & SETTERS*/
	public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public List<Movimiento> getListado() {
        return listado;
    }

    public void setListado(List<Movimiento> listado) {
        this.listado = listado;
    }

	/**/

	
	public String guardar() {
		try {
		
		cuenta = gCuenta.getCuenta(numeroCuenta);	
			
		movimiento.setnCuenta(cuenta);
		movimiento.setFecha(new Date());
		System.out.println(this.numeroCuenta);
		System.out.println(this.movimiento);
		
		gMovimiento.createMovimiento(movimiento);
		return "listadoClientes?faces-redirect=true";
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "error";
		}
	}
	


}

