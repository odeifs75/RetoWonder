package clase;

import java.time.LocalDate;

public class Gestion {
	private int codGestion;
	private String nomUsu1;
	private String nomUsu2;
	private LocalDate fecha;
	//
	public Gestion(int codGestion, String nomUsu1, String nomUsu2, LocalDate fecha) {
		super();
		this.codGestion = codGestion;
		this.nomUsu1 = nomUsu1;
		this.nomUsu2 = nomUsu2;
		this.fecha = fecha;
	}
	//
	public int getCodGestion() {
		return codGestion;
	}
	public void setCodGestion(int codGestion) {
		this.codGestion = codGestion;
	}
	public String getNomUsu1() {
		return nomUsu1;
	}
	public void setNomUsu1(String nomUsu1) {
		this.nomUsu1 = nomUsu1;
	}
	public String getNomUsu2() {
		return nomUsu2;
	}
	public void setNomUsu2(String nomUsu2) {
		this.nomUsu2 = nomUsu2;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
