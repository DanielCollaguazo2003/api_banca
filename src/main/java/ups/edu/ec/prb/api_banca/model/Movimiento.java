package ups.edu.ec.prb.api_banca.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_MOVIMIENTO")
public class Movimiento {
	
	@Id
	@GeneratedValue
	@Column(name="mov_codigo")
	private int codigo;
	
	@Column(name="mov_transaccion")
	private String tansaccion;
	
	@Column(name="mov_tipo")
	private boolean tipo;
	
	@Column(name="mov_fecha")
	private Date fecha;
	
	@Column(name="mov_valor")
	private double valor;
	
	/* Una cuenta puede tener muchos movientos, pero un movimiento solo pertenece a una cuenta */
	@ManyToOne
	@JoinColumn(name = "cue_numero")
	private Cuenta nCuenta;
	
	
	/* Getters & Setters */

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTansaccion() {
		return tansaccion;
	}


	public void setTansaccion(String tansaccion) {
		this.tansaccion = tansaccion;
	}


	public boolean isTipo() {
		return tipo;
	}


	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cuenta getnCuenta() {
		return nCuenta;
	}


	public void setnCuenta(Cuenta nCuenta) {
		this.nCuenta = nCuenta;
	}

	/* ToString*/
	@Override
	public String toString() {
		return "Movimiento [codigo=" + codigo + ", tansaccion=" + tansaccion + ", tipo=" + tipo + ", fecha=" + fecha
				+ ", valor=" + valor + ", nCuenta=" + nCuenta + "]";
	}




}
