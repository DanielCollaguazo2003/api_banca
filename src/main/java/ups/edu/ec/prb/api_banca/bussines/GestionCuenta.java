package ups.edu.ec.prb.api_banca.bussines;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.prb.api_banca.dao.CuentaDAO;
import ups.edu.ec.prb.api_banca.model.Cuenta;

@Stateless
public class GestionCuenta {
	
	
	@Inject
	private CuentaDAO daoCuenta;
	
	
	/*Objecto de negocio llama a un DAO*/
	public Cuenta getCuenta(int numero) throws Exception {
//		if(numero.length() != 10) { //!= si es diferente a 0
//			throw new Exception("Cedula Incorrecta");
//		}
		Cuenta Cuenta = daoCuenta.read(numero);
		if (Cuenta == null) {
			throw new Exception("Cuenta no existe");
		}
		return Cuenta;
	}
	

	
	public List<Cuenta> getCuentas() {
		return daoCuenta.getAll();
	}
 
	
	
	public void createCuenta(Cuenta Cuenta) throws Exception {
//		if (Cuenta.getCedula().length() != 10) { //!= si es diferente a 0
//			throw new Exception("Cedula Incorrecta");
//		}
		daoCuenta.insert(Cuenta);
	}
	
	
	public void updateCuenta(Cuenta Cuenta) throws Exception {
//		if (Cuenta.getCedula().length() != 10) {
//			throw new Exception("No se logro actualizar");
//		}
		daoCuenta.update(Cuenta);
		
	}

	
	public void deleteCuenta(int numero) throws Exception{
		Cuenta Cuenta = daoCuenta.read(numero);
		if(Cuenta == null) {				
			throw new Exception("Cuenta no existe");
		}
			daoCuenta.delete(numero);
		}

}
