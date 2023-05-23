package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Relacion {
	// ATRIBUTOS
	private int codRela;
	private String orienSex;
	private String zodiaco;
	private String gustos;
	private String queBuscas;
	private String descripcion;
	private String nomUsuCli;

	// CONSTRUCTOR
	public Relacion() {
		super();
	}

	/**
	 * @return
	 */
	public int getCodRela() {
		return codRela;
	}

	/**
	 * @param codRela
	 */
	public void setCodRela(int codRela) {
		this.codRela = codRela;
	}

	// GETTERS Y SETTER
	/**
	 * @return
	 */
	public String getOrienSex() {
		return orienSex;
	}

	/**
	 * @param orienSex
	 */
	public void setOrienSex(String orienSex) {
		this.orienSex = orienSex;
	}

	/**
	 * @return
	 */
	public String getZodiaco() {
		return zodiaco;
	}

	/**
	 * @param zodiaco
	 */
	public void setZodiaco(String zodiaco) {
		this.zodiaco = zodiaco;
	}

	/**
	 * @return
	 */
	public String getGustos() {
		return gustos;
	}

	/**
	 * @param gustos
	 */
	public void setGustos(String gustos) {
		this.gustos = gustos;
	}

	/**
	 * @return
	 */
	public String getQueBuscas() {
		return queBuscas;
	}

	/**
	 * @param descripcion
	 */
	public void setQueBuscas(String queBuscas) {
		this.queBuscas = queBuscas;
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
