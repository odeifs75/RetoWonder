package clase;

import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Cliente extends Usuario{
	// ATRIBUTOS
	private LocalDate fechaNac;
	private String genero;


	// CONSTRUCTOR
	/**
	 * 
	 */
	public Cliente() {
		super();	
	}

	// GETTERS Y SETTER
	/**
	 * @return
	 */
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	/**
	 * @param fechaNac
	 */
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * @return
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
