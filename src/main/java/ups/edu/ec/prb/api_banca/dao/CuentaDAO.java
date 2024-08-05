package ups.edu.ec.prb.api_banca.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.prb.api_banca.model.Cuenta;

@Stateless
public class CuentaDAO {
	
	@PersistenceContext
	private EntityManager em;

	
	/* °°°°°°°°°°°°°°°°°°°°
	 *   INSERTAR cuentaS
	 * °°°°°°°°°°°°°°°°°°°° */
	
	public void insert(Cuenta cuenta) {
		em.persist(cuenta);
	}
	
	
	/* °°°°°°°°°°°°°°°°°°°°°°°
	 *   ACTUALIZAR cuentaS
	 * °°°°°°°°°°°°°°°°°°°°°°° */
	
	public void update(Cuenta cuenta) {
		em.merge(cuenta);
	}
	
	
	/* °°°°°°°°°°°°°°°°°°
	 *   LEER CUENTAS
	 * °°°°°°°°°°°°°°°°°° */
	
	public Cuenta read(int numero) {
		return em.find(Cuenta.class, numero);
	}
	
	
	/* °°°°°°°°°°°°°°°°°°°°
	 *   ELIMINAR CUENTAS
	 * °°°°°°°°°°°°°°°°°°°° */
	
	public void delete(int numero) {
		Cuenta cuenta = em.find(Cuenta.class, numero);
		if (cuenta != null) {
			em.remove(cuenta);
		}
	}
	
	/* °°°°°°°°°°°°°°°°°°
	 *      LISTA
	 * °°°°°°°°°°°°°°°°°° */
	public List<Cuenta> getAll() {
	String jpql = "SELECT c FROM Cuenta c";
	Query query = em.createQuery(jpql, Cuenta.class);  
	return query.getResultList();  
}
	
}
