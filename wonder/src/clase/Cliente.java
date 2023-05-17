package clase;

import java.time.LocalDate;


/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
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
