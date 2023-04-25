package clase;

import java.time.LocalDate;

public class Mensaje {
	private int codMensaje;
	private String texto;
	private LocalDate fecha;
	private String enviadoPor;
	//
	public Mensaje(int codMensaje, String texto, LocalDate fecha, String enviadoPor) {
		super();
		this.codMensaje = codMensaje;
		this.texto = texto;
		this.fecha = fecha;
		this.enviadoPor = enviadoPor;
	}
	//
	public int getCodMensaje() {
		return codMensaje;
	}
	public void setCodMensaje(int codMensaje) {
		this.codMensaje = codMensaje;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getEnviadoPor() {
		return enviadoPor;
	}
	public void setEnviadoPor(String enviadoPor) {
		this.enviadoPor = enviadoPor;
	}
}
