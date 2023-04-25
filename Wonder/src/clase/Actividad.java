package clase;

import java.time.LocalDate;

public class Actividad {
	private int codActividad;
	private String nomActividad;
	private String descripcion;
	private LocalDate fecha;
	private String nomUsu;
	//
	public Actividad(int codActividad, String nomActividad, String descripcion, LocalDate fecha, String nomUsu) {
		super();
		this.codActividad = codActividad;
		this.nomActividad = nomActividad;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.nomUsu = nomUsu;
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
}
