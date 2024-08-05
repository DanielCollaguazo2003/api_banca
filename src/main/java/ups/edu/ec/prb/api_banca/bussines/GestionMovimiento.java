package ups.edu.ec.prb.api_banca.bussines;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.prb.api_banca.dao.MovimientoDAO;
import ups.edu.ec.prb.api_banca.model.Movimiento;

@Stateless
public class GestionMovimiento {
	
	
	@Inject
	private MovimientoDAO daoMovimiento;
	
	
	/*Objecto de negocio llama a un DAO*/
	public Movimiento getMovimiento(int codigo) throws Exception {
//		if(numero.length() != 10) { //!= si es diferente a 0
//			throw new Exception("Cedula Incorrecta");
//		}
		Movimiento Movimiento = daoMovimiento.read(codigo);
		if (Movimiento == null) {
			throw new Exception("Movimiento no existe");
		}
		return Movimiento;
	}
	
	
	
	public List<Movimiento> getMovimientos() {
		return daoMovimiento.getAll();
	}
 
	public List<Movimiento> filtrarPorCuenta(int numeroCuenta) {
        return daoMovimiento.getAll().stream()
                .filter(t -> t.getnCuenta().getNumero() == numeroCuenta)
                .collect(Collectors.toList());
    }
	
	public void createMovimiento(Movimiento Movimiento) throws Exception {
//		if (Movimiento.getCedula().length() != 10) { //!= si es diferente a 0
//			throw new Exception("Cedula Incorrecta");
//		}
		daoMovimiento.insert(Movimiento);
	}
	
	
	public void updateMovimiento(Movimiento Movimiento) throws Exception {
//		if (Movimiento.getCedula().length() != 10) {
//			throw new Exception("No se logro actualizar");
//		}
		daoMovimiento.update(Movimiento);
		
	}

	
	public void deleteMovimiento(int codigo) throws Exception{
		Movimiento Movimiento = daoMovimiento.read(codigo);
		if(Movimiento == null) {				
			throw new Exception("Movimiento no existe");
		}
			daoMovimiento.delete(codigo);
		}

}
