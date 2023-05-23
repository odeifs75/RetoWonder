package clase;

/**
 * @author june
 * @author markel
 * @author odei
 * @author alvaro
 */
public class Confirmar {
	// ATRIBUTOS
	private String nomUsuCli;
	private String nomUsuAd;
	private boolean apto;

	// CONSTRUCTOR
	public Confirmar() {
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
	public String getnomUsuAd() {
		return nomUsuAd;
	}

	/**
	 * @param nomUsuAd
	 */
	public void setnomUsuAd(String nomUsuAd) {
		this.nomUsuAd = nomUsuAd;
	}

	/**
	 * @return
	 */
	public boolean getapto() {
		return apto;
	}

	/**
	 * @param apto
	 */
	public void setapto(boolean apto) {
		this.apto = apto;
	}
}
