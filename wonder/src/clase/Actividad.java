package clase;

import java.time.LocalDate;
import java.util.Date;

import javax.swing.JTextField;

public class Actividad {
	private int codActividad;
	private String nomActividad;
	private String descripcion;
	private String fecha;
	private String nomUsu;
	//
	public Actividad() {
		super();
	}
	

	//
	public int getCodActividad() {
		return codActividad;
	}
	public void setCodActividad(int codActividad) {
		this.codActividad = codActividad;
	}
	public String getNomActividad() {
		return nomActividad;
	}
	public void setNomActividad(String nomActividad) {
		this.nomActividad = nomActividad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
}
