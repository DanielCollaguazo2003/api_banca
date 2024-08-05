package ups.edu.ec.prb.api_banca.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_CUENTA")
public class Cuenta {
	
	@Id
	@Column(name="cue_numero")
	private int numero;
	
	@Column(name="cue_cedula")
	private String cedula;
	
	@Column(name="cue_nombre")
	private String nombre;
	
	@Column(name="cue_usuario")
	private String usuario;
	
	@Column(name="cue_clave")
	private String clave;
	
	@OneToMany
	@JoinColumn (name = "cue_numero")
	private List<Movimiento> listaMovimientos;
	
	/* Getters & Setters */
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	/* ToString*/
	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", cedula=" + cedula + ", nombre=" + nombre + ", usuario=" + usuario
				+ ", clave=" + clave + ", movimientos: " + "]";
	}

}
