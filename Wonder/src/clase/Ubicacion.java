package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Ubicacion {
	// ATRIBUTOS
	private int codUbicacion;
	private String pais;
	private String ciudad;
	private int codPostal;

	// Constructores
	public Ubicacion() {
		super();

	}

	// Getters y setters
	/**
	 * @return
	 */
	public int getCodUbicacion() {
		return codUbicacion;
	}

	/**
	 * @param codUbicacion
	 */
	public void setCodUbicacion(int codUbicacion) {
		this.codUbicacion = codUbicacion;
	}

	/**
	 * @return
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return
	 */
	public int getCodPostal() {
		return codPostal;
	}

	/**
	 * @param codPostal
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
}
