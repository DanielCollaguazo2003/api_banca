package ups.edu.ec.prb.api_banca.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.prb.api_banca.model.Cuenta;
import ups.edu.ec.prb.api_banca.model.Movimiento;

@Stateless
public class MovimientoDAO {
	
	@PersistenceContext
	private EntityManager em;

	
	/* °°°°°°°°°°°°°°°°°°°°
	 *   INSERTAR movimientoS
	 * °°°°°°°°°°°°°°°°°°°° */
	
	public void insert(Movimiento movimiento) {
		em.persist(movimiento);
	}
	
	
	/* °°°°°°°°°°°°°°°°°°°°°°°
	 *   ACTUALIZAR movimientoS
	 * °°°°°°°°°°°°°°°°°°°°°°° */
	
	public void update(Movimiento movimiento) {
		em.merge(movimiento);
	}
	
	
	/* °°°°°°°°°°°°°°°°°°
	 *   LEER MOVIMIENTOS
	 * °°°°°°°°°°°°°°°°°° */
	
	public Movimiento read(int codigo) {
		return em.find(Movimiento.class, codigo);
	}
	
	
	/* °°°°°°°°°°°°°°°°°°°°
	 *   ELIMINAR movimientoS
	 * °°°°°°°°°°°°°°°°°°°° */
	
	public void delete(int codigo) {
		Movimiento movimiento = em.find(Movimiento.class, codigo);
		if (movimiento != null) {
			em.remove(movimiento);
		}
	}
	
	/* °°°°°°°°°°°°°°°°°°
	 *      LISTA
	 * °°°°°°°°°°°°°°°°°° */
	public List<Movimiento> getAll() {
	String jpql = "SELECT m FROM Movimiento m";
	Query query = em.createQuery(jpql, Movimiento.class);  
	return query.getResultList();  
}
	
}
