package clase;

import java.time.LocalDate;
import java.util.Date;

import javax.swing.JTextField;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Actividad {
	// ATRIBUTOS
	private int codActividad;
	private String nomActividad;
	private String descripcion;
	private String fecha;
	private int cantPerIns;
	private String nomUsuCli;

	// CONSTRUCTOR
	public Actividad() {
		super();
	}

	// GETTERS Y SETTER
	/**
	 * @return
	 */
	public int getCodActividad() {
		return codActividad;
	}

	/**
	 * @param codActividad
	 */
	public void setCodActividad(int codActividad) {
		this.codActividad = codActividad;
	}

	/**
	 * @return
	 */
	public String getNomActividad() {
		return nomActividad;
	}

	/**
	 * @param nomActividad
	 */
	public void setNomActividad(String nomActividad) {
		this.nomActividad = nomActividad;
	}

	/**
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return
	 */
	public int getCantPerIns() {
		return cantPerIns;
	}

	/**
	 * @param cantPerIns
	 */
	public void setCantPerIns(int cantPerIns) {
		this.cantPerIns = cantPerIns;
	}

	/**
	 * @return
	 */
	public String getNomUsuCli() {
		return nomUsuCli;
	}

	/**
	 * @param nomUsuCli
	 */
	public void setNomUsuCli(String nomUsuCli) {
		this.nomUsuCli = nomUsuCli;
	}

}
