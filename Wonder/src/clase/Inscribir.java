package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Inscribir {
	// ATRIBUTOS
	private String nomUsuCli;
	private int codActividad;

	// CONSTRUCTOR
	public Inscribir() {
		super();
	}

	// GETTERS Y SETTER
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

}
